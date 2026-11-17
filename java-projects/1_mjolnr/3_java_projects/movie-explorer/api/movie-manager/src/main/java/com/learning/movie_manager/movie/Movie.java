package com.learning.movie_manager.movie;
import java.math.BigDecimal;

import jakarta.persistence.*;

// @Entity: tells JPA/Hibernate "this class maps to a DB table" (like a model/schema in JS ORMs)
@Entity
// @Table: customises the table. name = actual table name; uniqueConstraints = UNIQUE (title, release_year)
// so the same title can exist in different years; indexes = CREATE INDEX on title for faster lookups.
// Note: columnNames here are DB column names (release_year), not Java field names (releaseYear).
@Table(name="moviesList", uniqueConstraints = @UniqueConstraint(columnNames = {"title", "release_year"}),
        indexes = @Index(name = "idx_movies_title", columnList = "title"))
public class Movie {
    // @Id: primary key. IDENTITY = let the DB generate it (AUTO_INCREMENT).
    // Long (not int) because the column is BIGINT.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nullable = false -> NOT NULL. Column name defaults to "title" (same as the field).
    @Column(nullable = false)
    private String title;

    // name = "release_year": needed because the DB column is snake_case but the Java field is camelCase.
    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    // precision = total number of digits, scale = digits after the decimal point.
    // DECIMAL(3,1) -> 3 digits total, 1 after the point -> 0.0 to 99.9 (e.g. 8.7).
    // BigDecimal is used (not double) because decimals must be exact, no floating-point rounding errors.
    @Column(precision = 3, scale = 1)
    private BigDecimal rating;

    // length = 500 -> VARCHAR(500). Default length is 255, too short for long URLs.
    @Column(name = "poster_url", length = 500)
    private String posterUrl;

    // columnDefinition: raw SQL type used in the generated DDL, overriding Hibernate's choice.
    // A plain String would become VARCHAR(255); TEXT allows long text (the movie overview).
    // It is DB-specific, so it ties you to databases that have a TEXT type (MySQL does).
    @Column(columnDefinition = "TEXT")
    private String overview;

    // Integer (nullable) because the column allows NULL; name needed for snake_case.
    @Column(name = "runtime_minutes")
    private Integer runtimeMinutes;

    // No @Column needed: every field of an @Entity is persisted automatically, and the column name
    // defaults to the field name ("director"). The default is VARCHAR(255) and nullable, which
    // matches the table. @Column is only needed to override something: name, length, nullable, etc.
    private String director;

    // No-arg constructor: REQUIRED by JPA/Hibernate. It creates an empty Movie with "new Movie()" and then
    // fills the fields from the DB row. Jackson also uses it when turning request JSON into a Movie.
    public Movie(){}

    // Convenience constructor for creating a new Movie in our own code (e.g. seeding data, tests).
    // It has no id parameter because the DB generates the id (IDENTITY) when the movie is saved.
    public Movie(String title,Integer releaseYear,BigDecimal rating, String posterUrl, String overview , Integer runtimeMinutes, String director){
            this.title=title;
            this.releaseYear=releaseYear;
            this.rating=rating;
            this.posterUrl=posterUrl;
            this.overview=overview;
            this.runtimeMinutes=runtimeMinutes;
            this.director=director;
        }

    // Getters and setters: the fields are private (encapsulation), so other code reads/writes them through these.
    // - Jackson (Spring's JSON library) calls getX() to turn a Movie into JSON for API responses,
    //   and setX() to fill a Movie from JSON in request bodies. Without getters, the JSON would be empty/fail.
    // - Think of it like a JS object whose properties are only reachable through get/set functions.
    // - Naming matters: getReleaseYear() -> JSON key "releaseYear" (Jackson derives it from the method name).
    // - id has a setter too, but normally you let the DB generate it and don't set it yourself.
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }

    public BigDecimal getRating() { return rating; }
    public void setRating(BigDecimal rating) { this.rating = rating; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }

    public String getOverview() { return overview; }
    public void setOverview(String overview) { this.overview = overview; }

    public Integer getRuntimeMinutes() { return runtimeMinutes; }
    public void setRuntimeMinutes(Integer runtimeMinutes) { this.runtimeMinutes = runtimeMinutes; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    // toString: human-readable text for logging/debugging (e.g. System.out.println(movie)).
    // Without it, Java prints something like "Movie@1a2b3c". Like JSON.stringify(obj) for quick inspection.
    // @Override: compiler checks we really are overriding Object.toString() (catches typos in the name).
    @Override
    public String toString() {
        return "Task{id=" + id + ", title=" + title + ", releaseYear=" + releaseYear + ", rating=" + rating +  ", posterUrl=" + posterUrl + ", overview=" + overview +", overview=" + overview + ", runtimeMinutes=" + runtimeMinutes + ", director=" + director + "}";
    }

}