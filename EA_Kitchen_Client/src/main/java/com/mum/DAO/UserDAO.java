package com.mum.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.mum.service.UserService;

public class UserDAO implements IUserDAO {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	UserService userService;

	@Override
	public UserDetails getUserByUserName(String username) {
		return userService.loadUserByUsername(username);
	}

	@Override
	public boolean loginUser(String username, String password) {
		UserDetails userDetails = userService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			return true;
		}
		return false;
	}
}
