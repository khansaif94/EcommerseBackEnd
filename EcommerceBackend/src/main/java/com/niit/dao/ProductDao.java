package com.niit.dao;

import java.util.List;
import com.niit.model.Product;

public interface ProductDao
{
	
	boolean saveProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(String id);

	boolean deleteProduct(Product product);
	
	boolean updateProduct(Product product);
	
	
}
