package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;

import java.util.List;

// An interface is a contract: it lists WHAT the service can do, not HOW.
// CategoryServiceImpl provides the actual code. The controller only knows this interface.
public interface CategoryService {
// Return every category.
List<Category> getAllCategories();
// Add a new category.
String createCategory(Category category);
// Delete a category by id and return a message saying what happened.
String deleteCategory(Long categoryId);

Category updateCategory(Category category, Long categoryId);
}
