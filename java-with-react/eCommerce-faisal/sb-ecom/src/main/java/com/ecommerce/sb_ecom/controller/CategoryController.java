package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.*;

import com.ecommerce.sb_ecom.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CategoryController {
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private CategoryService categoryService;

    @GetMapping ("/api/public/categories")
    public List<Category> getACategories(){
       return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public void createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }

}
