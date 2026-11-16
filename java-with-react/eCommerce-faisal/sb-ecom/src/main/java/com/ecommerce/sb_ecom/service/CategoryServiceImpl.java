package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
    public void createCategory(Category category) {
        // nextId++ uses the current value, then increases it by 1 for next time.
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        // Look through the list for the category whose id matches.
        // stream().filter(...) is like array.filter() in JS, and
        // findFirst() picks the first match. orElse(null) gives null if nothing matched
        // (c -> ... is an arrow function, same idea as in JS).
        // .equals() is used instead of == because categoryId is a Long object, not a primitive.
        Category category=categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst().orElse(null);
        if(category==null){
            return "Category not Found!!";
        }
        categories.remove(category);

        return "Category with "+categoryId+" deleted succesfully";
        //        return "";
    }
}
