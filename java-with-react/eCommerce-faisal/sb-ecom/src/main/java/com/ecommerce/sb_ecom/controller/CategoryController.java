package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.*;

import com.ecommerce.sb_ecom.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


// @RestController = this class handles HTTP requests, and whatever the methods
// return is sent back to the client as JSON (like an Express router returning res.json()).
@RestController
@RequestMapping("/api")
public class CategoryController {

    // Constructor injection: Spring sees this constructor needs a CategoryService,
    // looks for a bean of that type (CategoryServiceImpl, marked with @Service),
    // and passes it in automatically. We never write "new CategoryServiceImpl()" ourselves.
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // The controller depends on the INTERFACE, not the implementation,
    // so the implementation can be swapped later without touching this class.
    private CategoryService categoryService;

    // GET /api/public/categories -> returns all categories as a JSON array.
    // The controller only handles the web layer; the actual work is delegated to the service.
    @GetMapping ("/public/categories")
    public ResponseEntity<List<Category>> getACategories(){
       return new ResponseEntity(categoryService.getAllCategories(),HttpStatus.OK);
    }

    // POST /api/public/categories -> adds a new category.
    // @RequestBody converts the JSON in the request body into a Category object.
    // The return type changed from void to ResponseEntity<String> so we can send back
    // a message (the string returned by the service) along with an HTTP status code,
    // like res.status(200).send(message) in Express.
    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
       // The <> (diamond) lets the compiler infer ResponseEntity<String> from the
       // method's return type, so we don't repeat the type here.
       return new ResponseEntity<>(categoryService.createCategory(category),HttpStatus.OK) ;
    }

    // DELETE /api/admin/categories/5 -> deletes the category with id 5.
    // {categoryId} in the URL is a path variable; @PathVariable copies its value
    // into the method parameter (like req.params.categoryId in Express).
    // Fix: the return type was String but we returned a ResponseEntity, which caused
    // "Cannot infer type arguments for ResponseEntity<>". Declaring the return type as
    // ResponseEntity<String> lets us control both the body and the HTTP status code.
    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        try{
            // Happy path: service deletes the category and returns a message -> 200 OK.
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        // The service throws ResponseStatusException when the id doesn't exist
        // (like a throw inside an async function). We catch it here and reply with
        // 404 NOT_FOUND, using the exception's reason as the response body.
        catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,@PathVariable Long categoryId){
        // @RequestBody fills `category` from the JSON body; @PathVariable fills categoryId from the URL.
        // PUT /admin/categories/{categoryId} -> updates the name of an existing category.
        // If the service throws ResponseStatusException (id not found), the next line never
        // finishes and Spring turns the exception into a 404 response automatically.
        categoryService.updateCategory(category,categoryId);
        // Reached only if the update worked. We send back a message plus 200 OK
        // (the generic type is String because the body is a String, matching ResponseEntity<String>).
        return new ResponseEntity<>("Category with categoryId " + categoryId + "is updated", HttpStatus.OK);
    }

}
