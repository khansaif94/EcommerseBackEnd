package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Order;

@Transactional
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Order> list() {
		return sessionFactory.openSession().createQuery("from Order").list() ;
		
	}

	@Override
	public boolean save(Order order) {

		try
		{
				Session session =sessionFactory.openSession();
				session.save(order);
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
	}
	


