package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

// @Service registers this class as a Spring bean. Without it, Spring wouldn't know
// this class exists and couldn't inject it into the controller (that was the
// "required a bean of type CategoryService that could not be found" error).
@Service
public class CategoryServiceImpl implements CategoryService{

    // Temporary in-memory "database". The data is lost when the app restarts.
    // Declared as List (interface), created as ArrayList (implementation).
    private List<Category> categories=new ArrayList<>();

    // Counter used to give each new category a unique id (1, 2, 3, ...).
    private long nextId=1;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public String createCategory(Category category) {
        // nextId++ uses the current value, then increases it by 1 for next time.
        category.setCategoryId(nextId++);
        categories.add(category);
        return "Category added Succesfully";
    }

    @Override
    public String deleteCategory(Long categoryId) {
        // Look through the list for the category whose id matches.
        // stream().filter(...) is like array.filter() in JS, and
        // findFirst() picks the first match. orElse(null) gives null if nothing matched
        // (c -> ... is an arrow function, same idea as in JS).
        // .equals() is used instead of == because categoryId is a Long object, not a primitive.
        Category category=categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));

        categories.remove(category);

        return "Category with "+categoryId+" deleted succesfully";
        //        return "";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        // `category` is the new data from the request body; `categoryId` says which one to update.
        // Optional<Category> is a box that either holds a Category or is empty
        // (a safer alternative to returning null). findFirst() returns this box.
        Optional<Category> optionalCategory=categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst();

        if(optionalCategory.isPresent()){
            // .get() takes the Category out of the box (safe here because isPresent() was true).
            Category existingCategory=optionalCategory.get();
            // Copy the new name onto the object already in the list. Because the list holds
            // references to objects, changing it here updates the stored category (no "save" needed).
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        }else{
           // No category has this id -> 404 NOT_FOUND is the standard status for an update on a missing resource.
           // Throwing stops the method; Spring turns the exception into the HTTP error response.
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category with id " + categoryId + " not found");
        }
    }
}
