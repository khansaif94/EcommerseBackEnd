package com.niit.dao;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.Product;
@Repository("productDao")

public class ProductDaoImpl implements ProductDao {
	@Autowired
	 SessionFactory sessionFactory;
	private Product product;


	public boolean saveProduct(Product product) {
		try
		{
				Session session =sessionFactory.openSession();
				session.save(product);
				session.flush();
				session.close();
		
		return true;
		} 
		catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
	}

	
	public List<Product> getAllProducts() {
		Session  session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> productList=query.list();
		session.close();
		return productList;
	}


	public Product getProductById(String id) {
		Session session=sessionFactory.openSession();
        Product product=(Product)session.get(Product.class, id);
        session.close();
        return product;
	}

	
	public boolean updateProduct(Product product) {
		try {
			Session session =sessionFactory.openSession();
			session.update(product);
			session.flush();
			session.close();
			return true;
		}
	catch (Exception e)
		{
			e.printStackTrace();
			return false;
			
		}	
	}

	
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.openSession().delete(product);
			return true;
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
			
	   }
		
		public Product getProductByID(String id) {

			
			  
			  return  (Product) sessionFactory.openSession().get(Product.class, id);
				
		}

		public Product getProductByName(String name) 
		{
			 return  (Product) sessionFactory.openSession().createQuery("from Product where name = '"+name + "'").list().get(0);
		}
		
		@SuppressWarnings("deprecation")
		public void storeFile(Product p, HttpServletRequest request)
		{
			System.out.println(request.getRealPath("/"));
			 String path=request.getRealPath("/")+"WEB-INF\\resources\\images\\"+p.getImage();
			 MultipartFile file= p.getFile();
			 
			 if (!file.isEmpty()) {
					
					try{
					byte[] bytes =file.getBytes();
					System.out.println(file.getOriginalFilename());
					
					
					File serverFile = new File(path);
					serverFile.createNewFile();
				
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
		}
		}
}
	