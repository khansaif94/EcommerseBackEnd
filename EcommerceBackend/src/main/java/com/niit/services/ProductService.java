package com.niit.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.niit.model.Product;

public interface ProductService 
{

	boolean saveProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(String id);

	boolean deleteProduct(Product product);
	
	boolean updateProduct(Product product);
	
	public void storeFile(Product product, HttpServletRequest request);
}
