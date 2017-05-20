package com.niit.EcommerceBackend;



import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.model.Supplier;
import com.niit.services.SupplierService;

public class SupplierTestCase {

static	AnnotationConfigApplicationContext context;
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierService supplierService;
	
    @BeforeClass 
    public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplier = (Supplier) context.getBean("supplier");
		System.out.println(supplier);
		supplierService = (SupplierService) context.getBean("supplierService");
		
	}
    
    @Test
   	public void createSupplierTestCase()
   	{
   	supplier = (Supplier) context.getBean("supplier");
   	System.out.println(supplier);
    	supplier.setSupplierid("Dx459");
   		supplier.setSuppliername("Cool shoes corp");
   		supplier.setSupplieradd("x street YTcity ");
   		
   		 boolean flag = supplierService.saveSupplier(supplier);
   		 
   		 //compare what you are excepting VS what you are getting from save method
   		 
   		 Assert.assertEquals( "createSupplieryTestCase" ,true, flag);
   			
   }
    
    
    @Test
    public void updateSupplierTestCase()
    {
 	   
    	supplier.setSupplierid("cs986");
    	supplier.setSuppliername("NIKE");
    	supplier.setSupplieradd("semi formal look");
 	   
 	   boolean flag = supplierService.updateSupplier(supplier);
 	   
 	   Assert.assertEquals( "updateSupplierTestCase" ,true, flag);
 	   
 	   
    }
    
    
   
    @Test
    public void deleteSupplier()
    {
    	supplier.setSupplierid("Dx659");
 	   
 	   boolean flag = supplierService.deleteSupplier(supplier);
 	   
 	   Assert.assertEquals( "deleteSupplierTestCase" ,true, flag);
 	   
 	   
 	   
    }
    
    
    @Test
    public void getSupplierByIDTestCase()
    {
 	   
    	supplier = supplierService.getSupplierById("cs98");
 	  
 	  Assert.assertEquals("getSupplierByIDTestCase", null, supplier);
 	   
    }
    
    
   
    
    
    @Test
    public void getAllSupplierTestCase()
    
    {
 	   
 	  int recordsFromDao =  supplierService.getAllSupplier().size();
 	  
 	  Assert.assertEquals("getAllSupplierTestCase" ,1, recordsFromDao);
 	   
 }
	
}
