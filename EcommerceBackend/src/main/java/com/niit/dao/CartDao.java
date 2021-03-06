package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDao
{
	public List<Cart> list(String UserID);
	public void save(Cart cart);
	public boolean delete(Cart cart );
	public boolean delete(int id);
	
	public boolean deletebyId(String username);
	
	public Cart getCartByID(int id);
	public double getTotalAmount(String UserId);
	public int getMaxId();
	public Cart getCart(String userID, String productName);
	
	
}