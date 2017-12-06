package com.yz.jcs.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;

import com.yz.jcs.model.User;
import com.yz.jcs.service.UserService;
import com.yz.jcs.util.ResultEnum;


@RestController
@RequestMapping("/admin")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users.do")
	public View users(HttpServletRequest request) {
		List<User> users = userService.users();
		return successView(users) ;
	}
	
	@RequestMapping("/addUser.do")
	public View addUser(HttpServletRequest request) {
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		int res = userService.addUser(user);
		return successView(res) ;
	}
	
	@RequestMapping("/delUser.do")
	public View delUser(HttpServletRequest request) {
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		int res = userService.delUser(user);
		return successView(res) ;
	}
}
