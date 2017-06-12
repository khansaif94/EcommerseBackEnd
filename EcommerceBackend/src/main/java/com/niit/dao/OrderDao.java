package com.niit.dao;

import java.util.List;

import com.niit.model.Order;



public interface OrderDao {
	
public List<Order> list();
	
	public boolean save(Order order );

}
