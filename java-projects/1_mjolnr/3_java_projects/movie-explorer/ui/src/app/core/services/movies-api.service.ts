import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Movie } from '../models/movies';
import { mockMovies } from '../../mock_data/mock_movies';
import { catchError, of } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class MoviesApiService {
  private readonly http = inject(HttpClient);

  private readonly baseUrl = '/api/movies';

  getMovies() {
    return this.http.get<Movie[]>(`${this.baseUrl}/getMovies`).pipe(
      catchError((error: unknown) => {
        console.error('Failed to load movies from the API. Using mock data instead.', error);
        return of(mockMovies as Movie[]);
      }),
    );
  }
}
