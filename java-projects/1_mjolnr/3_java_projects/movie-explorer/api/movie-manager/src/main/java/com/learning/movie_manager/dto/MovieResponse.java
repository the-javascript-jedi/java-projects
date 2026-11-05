package com.learning.movie_manager.dto;

import java.math.BigDecimal;

// DTO (Data Transfer Object) = the shape of the data we SEND OUT in API responses.
// It is separate from the Movie entity so the API format and the DB table can change independently.
// Jackson turns this object into JSON, e.g. {"id":1,"title":"Inception",...}.
public class MovieResponse {
    // Private fields: only reachable through the getters below (encapsulation).
    private Long id;
    private String title;
    private Integer releaseYear;
    private BigDecimal rating;
    private String posterUrl;
    private String overview;
    private Integer runtimeMinutes;
    private String director;

    // Empty constructor: handy for frameworks and tools that create an object first, then fill it.
    public MovieResponse(){}

    // Full constructor: MovieService.toDto() uses this to build a response in one line.
    // "this.id = id" means: store the constructor argument in the object's own field.
    public MovieResponse(Long id, String title,Integer releaseYear,BigDecimal rating,String posterUrl, String overview,Integer runtimeMinutes,String director){
        this.id=id;
        this.title=title;
        this.releaseYear=releaseYear;
        this.rating=rating;
        this.posterUrl=posterUrl;
        this.overview=overview;
        this.runtimeMinutes=runtimeMinutes;
        this.director=director;
    }

    // GETTERS: Jackson builds the JSON by calling every getX() method.
    // The name MUST start with "get": getReleaseYear() -> JSON key "releaseYear".
    // A method named just releaseYear() would be ignored and that field would be missing from the JSON.
    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }
    public Integer getReleaseYear(){
        return this.releaseYear;
    }

    public BigDecimal getRating(){
        return this.rating;
    }
    public String getPosterUrl(){
        return this.posterUrl;
    }
    public String getOverview(){
        return this.overview;
    }
    public Integer getRuntimeMinutes(){
        return this.runtimeMinutes;
    }
    public String getDirector(){
        return this.director;
    }
}
