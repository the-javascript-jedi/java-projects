package com.learning.movie_manager.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public class CreateMovieRequest {
     @NotBlank
    private String title;
    private Integer releaseYear;
    private BigDecimal rating;
    private String posterUrl;
    private String overview;
    private Integer runtimeMinutes;
    private String director;
}

