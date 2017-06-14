package com.niit.dao;

import java.util.List;


import com.niit.model.User;

public interface UserDao 
{

	boolean saveUser(User user);

	List<User> getAllUser();

	User getUserById(String id);

	
	 boolean deleteUser(User user);

	
	 boolean updateUser(User user);
	 
	 
	
}
