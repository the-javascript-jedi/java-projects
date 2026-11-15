package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;

import java.util.List;

public interface CategoryService {
List<Category> getAllCategories();
void createCategory(Category category);
}
