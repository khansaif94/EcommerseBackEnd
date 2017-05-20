package com.niit.services;

import java.util.List;

import com.niit.model.Category;

public interface CategoryService {
	boolean saveCategory(Category category);

	List<Category> getAllCategory();

	Category getCategoryById(String id);

	
	 boolean deleteCategory(Category category);

	
	 boolean updateCategory(Category category);
	

}
