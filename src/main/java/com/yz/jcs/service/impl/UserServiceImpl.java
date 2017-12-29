package com.yz.jcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yz.jcs.dao.UserDao;
import com.yz.jcs.model.User;
import com.yz.jcs.service.RoleService;
import com.yz.jcs.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleService roleService;

	@Override
	public List<User> users() {
		User user = new User();
		user.setId(111);
		user.setName("22");
		userDao.addUser(user);
		roleService.list();
		return userDao.findUsers();
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public int delUser(User user) {
		return userDao.delUser(user);
	}


}
