package com.mum.DAO;

import org.springframework.security.core.userdetails.UserDetails;


public interface IUserDAO {
	UserDetails getUserByUserName(String username);
	boolean loginUser(String username, String password);
}
