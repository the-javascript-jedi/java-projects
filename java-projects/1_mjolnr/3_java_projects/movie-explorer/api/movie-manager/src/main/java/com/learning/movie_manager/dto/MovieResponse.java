package com.learning.movie_manager.dto;

import java.math.BigDecimal;

public class MovieResponse {
    private Long id;
    private String title;
    private Integer releaseYear;
    private BigDecimal rating;
    private String posterUrl;
    private String overview;
    private Integer runtimeMinutes;
    private String director;

    public MovieResponse(){}

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

    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }
    public Integer releaseYear(){
        return this.releaseYear;
    }
    
    public BigDecimal rating(){
        return this.rating;
    }
    public String getPosterUrl(){
        return this.posterUrl;
    }
    public String getOverview(){
        return this.overview;
    }
    public Integer runtimeMinutes(){
        return this.runtimeMinutes;
    }
    public String director(){
        return this.director;
    }
}
