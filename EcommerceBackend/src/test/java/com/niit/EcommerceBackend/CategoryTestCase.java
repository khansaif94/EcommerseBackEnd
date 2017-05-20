package com.niit.EcommerceBackend;



import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.model.Category;
import com.niit.services.CategoryService;


public class CategoryTestCase 
{
	@Autowired
	private static Category category;
	
	@Autowired
	private static CategoryService categoryService;
	
    @BeforeClass
    
    public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		category = (Category) context.getBean("category");
		
		categoryService = (CategoryService) context.getBean("categoryService");
		
	}
    
    @Test
   	public void createCategoryTestCase()
   	{
   		category.setCategoryid("SK28741");
   		category.setCategoryname("Formals");
   		category.setCategory_description("wear Formals Shoes");
   		
   		 boolean flag = categoryService.saveCategory(category);
   		 
   		 //compare what you are excepting VS what you are getting from save method
   		 
   		 Assert.assertEquals( "createCategoryTestCase" ,true, flag);
   		
   		
   }
    
    
    @Test
    public void updateCategoryTestCase()
    {
 	   
 	   category.setCategoryid("JK9874");
 	   category.setCategoryname("Semi-Formals");
 	   category.setCategory_description("semi formal look");
 	   
 	   boolean flag = categoryService.updateCategory(category);
 	   
 	   Assert.assertEquals( "updateCategoryTestCase" ,true, flag);
 	   
 	   
    }
    
    
   
    @Test
    public void deleteCategory()
    {
 	   category.setCategoryid("SK6547");
 	   
 	   boolean flag = categoryService.deleteCategory(category);
 	   
 	   Assert.assertEquals( "deleteCategoryTestCase" ,true, flag);
 	   
 	   
 	   
    }
    
    
    @Test
    public void getCategoryByIDTestCase()
    {
 	   
 	  category = categoryService.getCategoryById("JK987");
 	  
 	  
 	 // Assert.assertNotNull("getCategoryByIDTestCase", category);
 	  
 	  
 	  Assert.assertEquals("getCategoryByIDTestCase", null, category);
 	   
    }
    
    
   
    
    
    @Test
    public void getAllCategoriesTestCase()
    
    {
 	   
 	  int recordsFromDao =  categoryService.getAllCategory().size();
 	  
 	  Assert.assertEquals("getAllCategoriesTestCase" ,1 , recordsFromDao);
 	   
 }
}
