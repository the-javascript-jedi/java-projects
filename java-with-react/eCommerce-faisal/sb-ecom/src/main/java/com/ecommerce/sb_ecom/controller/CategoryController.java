package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.*;

import com.ecommerce.sb_ecom.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


// @RestController = this class handles HTTP requests, and whatever the methods
// return is sent back to the client as JSON (like an Express router returning res.json()).
@RestController
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
    @GetMapping ("/api/public/categories")
    public List<Category> getACategories(){
       return categoryService.getAllCategories();
    }

    // POST /api/public/categories -> adds a new category.
    // @RequestBody converts the JSON in the request body into a Category object.
    @PostMapping("/api/public/categories")
    public void createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }

    // DELETE /api/admin/categories/5 -> deletes the category with id 5.
    // {categoryId} in the URL is a path variable; @PathVariable copies its value
    // into the method parameter (like req.params.categoryId in Express).
    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        return categoryService.deleteCategory(categoryId);
    }

}
