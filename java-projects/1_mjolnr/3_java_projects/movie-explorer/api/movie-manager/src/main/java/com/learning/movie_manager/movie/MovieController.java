package com.learning.movie_manager.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.movie_manager.dto.CreateMovieRequest;
import com.learning.movie_manager.dto.MovieResponse;

import jakarta.validation.Valid;

// CONTROLLER LAYER = the "front door". It receives HTTP requests and returns HTTP responses.
// It should NOT contain business logic or DB code; it just hands work to the service.
// Request flow: Browser -> Controller -> Service -> Repository -> MySQL (and back the same way).
//
// @RestController = this class handles web requests AND whatever a method returns is written
// straight into the response body as JSON (Spring uses Jackson to convert objects to JSON).
// Like an Express router where you do res.json(data).
@RestController
// @RequestMapping on the class = base URL for every method inside. All routes here start with /movies.
@RequestMapping("/movies")
public class MovieController {
    // @Autowired = dependency injection. Spring creates ONE MovieService object and puts it
    // in this field for you. You never write "new MovieService()" yourself.
    // (Like importing a service instance in JS, but Spring wires it automatically.)
     @Autowired
    private MovieService movieService;

    // GET /movies -> list all movies.
    // @GetMapping with no path = handles GET /movies  (class path + nothing extra).
    // Like router.get("/", handler) in Express.
    // ResponseEntity<T> = the full HTTP response (status code + headers + body) with body type T.
     @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies(){
        // .ok(...) builds a 200 OK response with the given body. Like res.status(200).json(list).
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    // GET /movies/1 -> one movie.
    // {id} in the path is a placeholder; @PathVariable copies it into the method parameter.
    // Like req.params.id in Express (route "/movies/:id").
     @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    // POST /movies -> create a movie from the JSON body.
    // @RequestBody = turn the request's JSON body into a CreateMovieRequest object (like req.body in Express).
    // @Valid = run the validation rules on it (@NotBlank, @NotNull); if they fail, Spring returns 400 automatically.
    // 201 Created is the correct status for "a new resource was made" (not 200).
     @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@Valid @RequestBody CreateMovieRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(request));
    }

    // PUT /movies/1 -> replace the fields of movie 1 with the JSON body.
    // Combines @PathVariable (which movie) and @RequestBody (the new values).
     @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id, @Valid @RequestBody CreateMovieRequest request){
        return ResponseEntity.ok(movieService.updateMovie(id, request));
    }

    // DELETE /movies/1 -> remove movie 1.
    // 204 No Content = "done, and there is nothing to send back". ResponseEntity<Void> = empty body.
     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
