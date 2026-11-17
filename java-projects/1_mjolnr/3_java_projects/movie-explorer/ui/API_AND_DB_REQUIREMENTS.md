# Movie Explorer: API and Database Requirements

Backend assumption: Spring Boot + a SQL database. The Angular UI calls `/api/...`.

## 1. APIs

### Movies
| Method & path | Used by | Request | Response |
|---|---|---|---|
| `GET /api/movies` | Dashboard "Trending" list | optional `?query=`, `?page=`, `?size=` | `200` `Movie[]` |
| `GET /api/movies/{id}` | Details page (`/movie/:id`) | none | `200` `MovieDetails`, or `404` |

Notes:
- Search is a query param on the list endpoint (`GET /api/movies?query=mid`), not a separate endpoint.
- The current UI calls `/api/movies/getMovies`. Rename it to `GET /api/movies` and update `MoviesApiService`.

### Watchlist (requires login)
| Method & path | Used by | Request | Response |
|---|---|---|---|
| `GET /api/watchlist` | Watchlist page, header badge count | none | `200` `Movie[]` for the logged-in user |
| `POST /api/watchlist` | "+" button on a card | `{ "movieId": 3 }` | `201`, or `409` if already added |
| `DELETE /api/watchlist/{movieId}` | Remove from watchlist | none | `204` |

The user comes from the auth token, never from the URL.

### Auth
| Method & path | Request | Response |
|---|---|---|
| `POST /api/auth/register` | `{ "email", "password" }` | `201` |
| `POST /api/auth/login` | `{ "email", "password" }` | `200` `{ "token": "..." }` |

### Optional later
- `GET /api/genres` and `?genre=` on the movie list
- `PATCH /api/watchlist/{movieId}` to mark a movie as watched
- `POST /api/movies`, `PUT /api/movies/{id}`

### Response shapes
```ts
// Movie (list cards, watchlist)
{ id: number; title: string; year: number; rating: number; posterUrl: string }

// MovieDetails (details page): Movie plus
{ overview: string; runtimeMinutes: number; director: string; genres?: string[] }
```

### Error format
The UI's `toErrorMessage` expects:
- General errors: `{ "error": "message" }`
- Validation errors: `{ "fieldName": "message" }`

Return these from the Spring `GlobalExceptionHandler`. Map `DataIntegrityViolationException` to `409`.

## 2. Database

3 tables: `users`, `movies`, `watchlist`.

```sql
CREATE TABLE users (
  id             BIGINT PRIMARY KEY AUTO_INCREMENT,
  email          VARCHAR(255) NOT NULL UNIQUE,
  password_hash  VARCHAR(255) NOT NULL,
  created_at     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE movies (
  id               BIGINT PRIMARY KEY AUTO_INCREMENT,
  title            VARCHAR(255) NOT NULL,
  release_year     INT NOT NULL,
  rating           DECIMAL(3,1),
  poster_url       VARCHAR(500),
  overview         TEXT,
  runtime_minutes  INT,
  director         VARCHAR(255),
  UNIQUE (title, release_year)
);
CREATE INDEX idx_movies_title ON movies (title);

CREATE TABLE watchlist (
  id        BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id   BIGINT NOT NULL,
  movie_id  BIGINT NOT NULL,
  added_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  watched   BOOLEAN NOT NULL DEFAULT FALSE,   -- optional, for the later PATCH
  UNIQUE (user_id, movie_id),                 -- a movie once per user
  FOREIGN KEY (user_id)  REFERENCES users(id),
  FOREIGN KEY (movie_id) REFERENCES movies(id)
);
```

### Key rules
- `watchlist` stores only IDs. Titles come from joining to `movies`.
- `UNIQUE (user_id, movie_id)` enforces one entry per movie per user. The database enforces it, and the service also checks first to return a clean `409`.
- `year` is a reserved word in some databases, so the column is `release_year`. Map it to `year` in the DTO.

### Watchlist query
```sql
SELECT m.id, m.title, m.release_year AS year, m.rating, m.poster_url
FROM watchlist w
JOIN movies m ON m.id = w.movie_id
WHERE w.user_id = :userId
ORDER BY w.added_at DESC;
```

## 3. Possible later additions
| Addition | New tables |
|---|---|
| Genres | `genres(id, name)`, `movie_genres(movie_id, genre_id)` |
| Cast | `people`, `movie_cast` |

If you skip auth at first, drop `users` and `watchlist.user_id`, and make `movie_id` UNIQUE on its own. That gives a global watchlist with 2 tables.
