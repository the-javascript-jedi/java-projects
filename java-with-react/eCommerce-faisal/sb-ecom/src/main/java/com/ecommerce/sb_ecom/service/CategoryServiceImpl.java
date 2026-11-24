package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.sb_ecom.repositories.CategoryRepository;
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
//    private List<Category> categories=new ArrayList<>();

    // final = must be set once in the constructor and can never be reassigned (so it can't be null later).
    private final CategoryRepository categoryRepository;

    // Spring sees the single constructor and automatically passes in the CategoryRepository bean.
    // No @Autowired needed when there's only one constructor.
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
//        Tep db
//        return categories;
        return categoryRepository.findAll();
    }

    @Override
    public String createCategory(Category category) {
        // nextId++ uses the current value, then increases it by 1 for next time.
//        category.setCategoryId(nextId++);
//        categories.add(category);
        categoryRepository.save(category);
        return "Category added Succesfully";
    }

    @Override
    public String deleteCategory(Long categoryId) {
        // Step 1: fetch just this one row by primary key (SELECT ... WHERE category_id = ?).
        // findById returns an Optional (a box that may be empty).
        // orElseThrow -> if empty, throw a 404 error; otherwise unwrap and give us the Category.
        Category category=categoryRepository.findById(categoryId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource with "+categoryId+" not Found"));

        // Step 2: delete that row (DELETE FROM categories WHERE category_id = ?).
        categoryRepository.delete(category);

        // Step 3: return a success message to the controller (and then to the client).
        return "Category with "+categoryId+" deleted succesfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        // Step 1: check the category exists. findById returns an Optional (a box that may be empty).
        // orElseThrow -> if empty, throw a 404 error; otherwise unwrap and give us the Category.
        Category savedCategory= categoryRepository.findById(categoryId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category with id " + categoryId + " not found"));

        // Step 2: copy the id from the URL onto the request-body object.
        // The JSON body usually has no id. save() INSERTS a new row when the id is null,
        // and UPDATES the existing row when the id is set. So this line makes it an update.
        category.setCategoryId(categoryId);

        // Step 3: save() sees the id, runs an UPDATE, and returns the saved entity.
        // NOTE: this replaces the whole row with the request body (like replaceOne in MongoDB),
        // so any field the client leaves out would become null.
        savedCategory=categoryRepository.save(category);

        // Step 4: return the updated category (the controller sends it back as JSON).
        return savedCategory;
    }
}
