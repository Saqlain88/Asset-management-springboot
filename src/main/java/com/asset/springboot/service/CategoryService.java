package com.asset.springboot.service;

import java.util.List;

import com.asset.springboot.model.Category;

public interface CategoryService {
	
	Category createCategory(Category category);
	Category updateCategory(Category category);
	List<Category> getAllCategory();
	Category getCategoryById(long categoryId);
	void deleteCategory(long categoryId);
	
}
