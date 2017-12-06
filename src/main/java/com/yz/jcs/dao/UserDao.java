package com.yz.jcs.dao;

import java.util.List;

import com.yz.jcs.model.User;

public interface UserDao {
	
	public List<User> findUsers();
	
	public int addUser(User user);

	public int delUser(User user);
	
}
