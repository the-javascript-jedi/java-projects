package com.learning.task_manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Marks this class as a global error handler for every @RestController in
// the app — similar to an Express error-handling middleware
// ((err, req, res, next) => {...}) that runs no matter which route throws.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Fires automatically when a @Valid request body fails validation
    // (e.g. a @NotBlank/@Size annotation on a DTO field). Spring throws
    // MethodArgumentNotValidException before your controller code runs,
    // and this method intercepts it.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        // Build a plain { fieldName: errorMessage } map, e.g.
        // { "title": "must not be blank" }
        Map<String, String> errors = new HashMap<>();

        // One FieldError per invalid field; forEach works just like
        // Array.prototype.forEach in JS.
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        // Same as res.status(400).json(errors) in Express.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // Fallback handler for any other RuntimeException thrown in a
    // controller/service (e.g. a manually thrown "Task not found").
    // More specific @ExceptionHandler methods (like the one above) win
    // first — same idea as ordering Express error middleware from
    // specific to generic.
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        // Same as res.status(404).json({ error: ex.message }).
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}