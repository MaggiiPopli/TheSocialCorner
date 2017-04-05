package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {
	
	public boolean validate(String username, String password);
	
	public boolean saveUser(User u);
	
	public List<User> getAllUsers(String username);
}
