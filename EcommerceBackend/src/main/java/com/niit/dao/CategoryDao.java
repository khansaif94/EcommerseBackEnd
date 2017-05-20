package com.niit.dao;

import java.util.List;
import com.niit.model.Category;


public interface CategoryDao 
{
	boolean saveCategory(Category category);

	List<Category> getAllCategory();

	Category getCategoryById(String id);

	 boolean deleteCategory(Category category);
	
	 boolean updateCategory(Category category);
	
}
