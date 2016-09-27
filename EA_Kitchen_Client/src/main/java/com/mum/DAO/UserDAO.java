package com.mum.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.model.User;
import com.mum.service.UserService;

@Component
public class UserDAO implements IUserDAO{

	@Autowired
	UserService userService;
	
	@Override
	public User loginUser(User user) {
		return userService.loginUser(user);
	}

}
