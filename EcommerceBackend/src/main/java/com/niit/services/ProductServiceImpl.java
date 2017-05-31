package com.niit.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService
{
	@Autowired	
	 ProductDao productDao;

	@Override
	public boolean saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.saveProduct(product) ;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts() ;
	}

	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return productDao.getProductById(id) ;
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(product) ;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(product) ;
	}
	
	public void storeFile(Product p, HttpServletRequest request)
	{
		productDao.storeFile(p,request);
	}
	
		
}
