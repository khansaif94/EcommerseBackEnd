package com.niit.EcommerceBackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.model.Product;
import com.niit.services.ProductService;

public class ProductCaseTest {

	@Autowired
	private static Product product  ;
	
	@Autowired
	private static ProductService productService;
	
    @BeforeClass
    
    public static void init()
   	{
   		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
   		context.scan("com.niit");
   		context.refresh();
   		
   		product = (Product) context.getBean("product");
   		
   		productService = (ProductService) context.getBean("productService");
   		
   	}
       
       @Test
      	public void createProductTestCase()
      	{
    	  
    	   product.setProductid("SK9485");
    	   product.setProductname("ADDIDAS ORIGINALS");
    	   product.setPrice(2000.96);
    	   product.setQuantity(20);
    	   product.setCategoryid("SK2874");
    	   product.setSupplierid("Dx459");
      		
      		 boolean flag =  productService.saveProduct(product);
      		 
      		 //compare what you are excepting VS what you are getting from save method
      		 
      		 Assert.assertEquals( "createProductTestCase" ,true, flag);
      		
      		
      }
       
       
       @Test
       public void updateProductTestCase()
       {
    	   product.setProductid("SK94851");
    	   product.setProductname("PUMA BASICS");
    	   product.setPrice(2000.96);
    	   product.setQuantity(10);
    	   product.setCategoryid("JK9874");
    	   product.setSupplierid("Dx659");
    	   
    	   boolean flag = productService.updateProduct(product);
    	   
    	   Assert.assertEquals( "updateProductTestCase" ,true, flag);
    	   
    	   
       }
       
       
      
       @Test
       public void deleteProduct()
       {
    	   product.setProductid("");
    	   
    	   boolean flag =  productService.deleteProduct( product);
    	   
    	   Assert.assertEquals( "deleteProductTestCase" ,true, flag);
    	   
    	   
    	   
       }
       
       
       @Test
       public void getProductByIDTestCase()
       {
    	   
    	   product = productService.getProductById("JK987");
    	    
    	  assertEquals("getProductByIDTestCase", null, product);
    	   
       }
       
       
      
       
       
       @Test
       public void getAllProductTestCase()
       
       {
    	   
    	  int recordsFromDao =  productService.getAllProducts().size();
    	  
    	  assertEquals("getAllProductTestCase" ,0 , recordsFromDao);
    	   
    }

}
