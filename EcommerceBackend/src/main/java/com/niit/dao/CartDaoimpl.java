package com.niit.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Cart;
@Repository("cartDao")

public class CartDaoimpl implements CartDao {
	
private static Logger log = LoggerFactory.getLogger(CartDaoimpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public CartDaoimpl() {

	}

	public void Cartdaoimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<Cart> list(String userID) {
		System.out.println("cart");
		log.debug("Starting of the method list");
		String hql = "from Cart where user_name=" + "'" + userID + "'  and status = " + "'N'";
		Query query = sessionFactory.openSession().createQuery(hql);
		log.debug("Ending of the method list");
	
		return query.list();
	}

	public void save(Cart cart) {
		log.debug("Starting of the method save");
			cart.setCartid(getMaxId()+1);
			cart.setDate_added(new java.util.Date());
			cart.setQuantity(1);
		Session session =sessionFactory.openSession();
		session.save(cart);
		session.flush();
		session.close();
		log.debug("Ending of the method save");
	}


	public double getTotalAmount(String userID) {
		log.debug("Starting of the method getTotalAmount");
		String hql = "select sum(price) from Cart where user_name=" + "'" + userID + "' " + "  and status = " + "'N'";
		log.debug("hql" + hql);

		Query query = sessionFactory.openSession().createQuery(hql);
		log.debug("Ending of the method getTotalAmount");
		return (double) query.uniqueResult();

	}


	public Cart getCart(String userID, String productName)
	{
		String hql="from Cart where user_name=? and product_name=?";
		Query query=sessionFactory.openSession().createQuery(hql);
		query.setString(0, userID);
		query.setString(1,productName);
		return (Cart) query.uniqueResult();
		
	}
	
	public int getMaxId() {
		log.debug("->->Starting of the method getMaxId");

		int maxID = 100;
		try {
			String hql = "select max(id) from Cart";
			Query query = sessionFactory.openSession().createQuery(hql);
			maxID = (int) query.uniqueResult();
		} catch (Exception e) {
			log.debug("It seems this is first record. setting initial id is 100 :");
			maxID = 100;
			e.printStackTrace();
		}
		log.debug("Max id :" + maxID);
		return (maxID + 1);

	}

	@Override
	public boolean delete(Cart cart) {
		try {
			sessionFactory.openSession().delete(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

	@Override
	public boolean delete(int id) {
		try {
			Session session =sessionFactory.openSession();
			session.delete(getCartByID(id));
			session.flush();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Cart getCartByID(int id) {
		 return   (Cart) sessionFactory.openSession().get(Cart.class, id);
			
	}

	public boolean deletebyId(String username) {
		try{
		Session session =sessionFactory.openSession();
		List<Cart>mlt = (List)session.createQuery("from Cart where user_name='"+username+"'").list();
		if(!mlt.isEmpty())
		{
			for(Cart mt : mlt){
				
						session.delete(mt);
						session.flush();
			}
		}
		
		
		return true;
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
	}
	

}

	
	
	
	

	


