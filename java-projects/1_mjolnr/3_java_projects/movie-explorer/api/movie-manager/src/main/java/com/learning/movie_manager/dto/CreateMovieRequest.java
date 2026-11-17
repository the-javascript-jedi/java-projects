package com.learning.movie_manager.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// DTO for the INCOMING JSON body of POST /movies (create) and PUT /movies/{id} (update).
// It is the opposite of MovieResponse: Response = data going out, Request = data coming in.
// It has no id: on create the DB generates it, on update the id comes from the URL.
public class CreateMovieRequest {
    // @NotBlank = title must not be null, empty, or only spaces.
    // Validation runs only when the controller parameter is marked @Valid; otherwise Spring replies 400 Bad Request.
     @NotBlank
    private String title;

    // @NotNull = required. The DB column release_year is NOT NULL, so without this a missing
    // year would reach the DB and fail with a 500 error instead of a clean 400.
    @NotNull
    private Integer releaseYear;

    private BigDecimal rating;
    private String posterUrl;
    private String overview;
    private Integer runtimeMinutes;
    private String director;

    // GETTERS and SETTERS: Jackson uses the setters (setTitle...) to fill this object from the request JSON.
    // Without them the fields would stay null. Same naming rule as before: setReleaseYear -> JSON key "releaseYear".
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
}
