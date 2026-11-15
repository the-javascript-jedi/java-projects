package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CategoryController {

    private List<Category> categories=new ArrayList<>();

    @GetMapping ("/api/public/categories")
    private List<Category> getACategories(){
        return categories;
    }
}
