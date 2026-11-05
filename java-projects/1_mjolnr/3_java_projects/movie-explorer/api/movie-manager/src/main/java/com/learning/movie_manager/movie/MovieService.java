package com.learning.movie_manager.movie;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.learning.movie_manager.dto.CreateMovieRequest;
import com.learning.movie_manager.dto.MovieResponse;

// SERVICE LAYER = the "business logic" layer, sitting between controller and repository.
// The controller asks the service for data; the service talks to the repository and shapes the result.
//
// @Service = tells Spring "create one instance of this class and manage it" so it can be
// injected (@Autowired) into other classes such as the controller.
@Service
public class MovieService {
    // Spring injects the MovieRepository here. You never implement that interface yourself:
    // Spring generates the implementation at startup.
    @Autowired
    private MovieRepository movieRepository;


    // Converts one DB entity (Movie) into a DTO (MovieResponse).
    // Why not return Movie directly? The entity mirrors the DB table. A DTO is what the API
    // sends out, so you can hide or rename fields later without touching the database.
    // "private" = only used inside this class.
    private MovieResponse toDto(Movie movie){
        return new MovieResponse(movie.getId(),movie.getTitle(),movie.getReleaseYear(),movie.getRating(),movie.getPosterUrl(),movie.getOverview(),movie.getRuntimeMinutes(),movie.getDirector());
    }

    // Copies the values from the incoming request onto a Movie entity.
    // Used by both create (a new Movie) and update (an existing Movie loaded from the DB).
    private void applyRequest(Movie movie, CreateMovieRequest request){
        movie.setTitle(request.getTitle());
        movie.setReleaseYear(request.getReleaseYear());
        movie.setRating(request.getRating());
        movie.setPosterUrl(request.getPosterUrl());
        movie.setOverview(request.getOverview());
        movie.setRuntimeMinutes(request.getRuntimeMinutes());
        movie.setDirector(request.getDirector());
    }

    // Looks a movie up by id, or throws a 404 if it doesn't exist.
    // findById returns Optional<Movie> (a box that may be empty, like a value that could be undefined in JS).
    // orElseThrow(...) = "give me the Movie, or throw this error if the box is empty".
    // ResponseStatusException makes Spring send the given HTTP status (404) back to the client.
    private Movie findMovieOrThrow(Long id){
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found with id " + id));
    }

    // READ ALL: returns every movie in the table as a list of DTOs.
    public List<MovieResponse> getAllMovies() {
         // findAll() runs SELECT * FROM movies_list and returns List<Movie>.
         return movieRepository.findAll()
                 // .stream() = start a pipeline over the list (like using array methods in JS).
                 .stream()
                 // .map(this::toDto) = convert each Movie to a MovieResponse.
                 // "this::toDto" is shorthand for movie -> this.toDto(movie). Same as movies.map(toDto) in JS.
                 .map(this::toDto)
                 // .collect(Collectors.toList()) = turn the stream back into a List (like the final array).
                 .collect(Collectors.toList());
     }

    // READ ONE: returns a single movie by id (404 if missing).
    public MovieResponse getMovieById(Long id){
        return toDto(findMovieOrThrow(id));
    }

    // CREATE: builds a new Movie from the request, saves it (INSERT), and returns it with its new id.
    public MovieResponse createMovie(CreateMovieRequest request){
        Movie movie = new Movie();
        applyRequest(movie, request);
        // save() on a Movie with no id runs INSERT. The returned object has the DB-generated id filled in.
        Movie saved = movieRepository.save(movie);
        return toDto(saved);
    }

    // UPDATE: loads the existing movie (404 if missing), overwrites its fields, and saves it.
    public MovieResponse updateMovie(Long id, CreateMovieRequest request){
        Movie movie = findMovieOrThrow(id);
        applyRequest(movie, request);
        // save() on a Movie that already has an id runs UPDATE instead of INSERT.
        Movie saved = movieRepository.save(movie);
        return toDto(saved);
    }

    // DELETE: removes the movie by id (404 if it doesn't exist).
    public void deleteMovie(Long id){
        Movie movie = findMovieOrThrow(id);
        movieRepository.delete(movie);
    }
}
