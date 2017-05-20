package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveCategory(Category category) {
		try
		{
				Session session =sessionFactory.openSession();
				session.save(category);
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

	public List<Category> getAllCategory() {
		Session  session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> categoryList=query.list();
		session.close();
		return categoryList;
	}

	public Category getCategoryById(String id) {
		Session session=sessionFactory.openSession();
        Category category=(Category)session.get(Category.class, id);
        session.close();
        return category;
	}

	public boolean updateCategory(Category category) 
	{
		
		try {
				Session session =sessionFactory.openSession();
				session.update(category);
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
		
		public boolean deleteCategory(Category category) {
		try {
			Session session =sessionFactory.openSession();
			session.delete(category);
			session.flush();
			session.close();
			return true;
			} 
			catch (Exception e) {
				e.printStackTrace();
				return false;
				
			}
	}
		
		public Category getCategoryByID(String id)
		{
			Session session= sessionFactory.openSession();
			Category cat=(Category)session.get(Category.class, id);
			session.flush();
			session.close();
			return cat;
				
		}

		public Category getCategoryByName(String name)
		{
			Session session= sessionFactory.openSession();
			Category cat=(Category)session.createQuery("from Category where name = '"+name + "'").list().get(0);
			session.flush();
			session.close();
			return cat;
				

	    }

}
