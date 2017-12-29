package com.yz.jcs.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.yz.jcs.dao.UserDao;
import com.yz.jcs.model.User;

public class UserDaoImpl extends  SqlSessionDaoSupport implements UserDao {

	@Override
	public List<User> findUsers() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getSqlSession().selectList("findUsers");
	}

	@Override
	public int addUser(User user) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getSqlSession().insert("addUser",user);
	}

	@Override
	public int delUser(User user) {
		return getSqlSession().insert("delUser",user);
	}

}
