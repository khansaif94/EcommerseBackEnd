package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDao;
import com.niit.model.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean saveUser(User user) {
		try
		{
				Session session =sessionFactory.openSession();
				session.save(user);
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

	@Override
	public List<User> getAllUser() 
	{
		Session  session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> userList=query.list();
		session.close();
		return userList;
	}

	@Override
	public User getUserById(String id) {
		Session session=sessionFactory.openSession();
		System.out.println(id);
		User usr=(User)session.createQuery("from User where userid= '"+id + "'").list().get(0);
		session.flush();
        session.close();
        return usr;
	}
	
	public User getUserByName(String name) {
		Session session=sessionFactory.openSession();
		User usr=(User)session.createQuery("from User where name = '"+name + "'").list().get(0);
		session.flush();
        session.close();
        return usr;
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			Session session =sessionFactory.openSession();
			session.delete(user);
			session.flush();
			session.close();
			return true;
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean updateUser(User user) {
		
		try {
			Session session =sessionFactory.openSession();
			session.update(user);
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
}
