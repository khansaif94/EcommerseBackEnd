package com.niit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.OrderDao;
import com.niit.model.Order;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired	
	 OrderDao orderDao;

	@Override
	public List<Order> list() {
		
		return orderDao.list();
	}

	@Override
	public boolean save(Order order) {
		return orderDao.save(order);
	}
	
	

}
