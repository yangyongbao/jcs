package com.yz.jcs.service;

import java.util.List;

import com.yz.jcs.model.User;

public interface UserService {
	
	List<User> users();
	
	int addUser(User user);
	
	int delUser(User user);

}
