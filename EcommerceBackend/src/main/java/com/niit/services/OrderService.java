package com.niit.services;

import java.util.List;

import com.niit.model.Order;

public interface OrderService {
	
public List<Order> list();
	
	public boolean save(Order order );


}
