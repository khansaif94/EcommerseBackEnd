package com.niit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartDao;
import com.niit.model.Cart;

@Service("cartService")
public class CartServiceImpl implements CartService {
	
	@Autowired	
	 CartDao cartDao;

	@Override
	public List<Cart> list(String UserID) {
		// TODO Auto-generated method stub
		return cartDao.list(UserID);
	}

	@Override
	public void save(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.save(cart);
	}

	@Override
	public boolean delete(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.delete(cart);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return cartDao.delete(id);
	}

	@Override
	public boolean deletebyId(String username) {
		// TODO Auto-generated method stub
		return cartDao.deletebyId(username);
	}

	@Override
	public Cart getCartByID(int id) {
		// TODO Auto-generated method stub
		return cartDao.getCartByID(id);
	}

	@Override
	public double getTotalAmount(String UserId) {
		// TODO Auto-generated method stub
		return cartDao.getTotalAmount(UserId);
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		return cartDao.getMaxId();
	}

	@Override
	public Cart getCart(String userID, String productName) {
		// TODO Auto-generated method stub
		return cartDao.getCart(userID, productName);
	}

	
}
