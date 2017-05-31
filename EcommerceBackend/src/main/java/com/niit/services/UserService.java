package com.niit.services;

import java.util.List;

import com.niit.model.User;

public interface UserService {

	boolean saveUser(User user);

	List<User> getAllUser();

	User getUserById(String id);

	
	 boolean deleteUser(User user);

	
	 boolean updateUser(User user);
	
}
