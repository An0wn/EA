package edu.mum.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import edu.mum.DAO.UserDAO;
import edu.mum.model.User;

@Controller
public class UserController {
	
	//@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/getUserByUserName/{username}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User getUserByUserName(@PathVariable("username") String username){	
		User user=new User();
		user.setPassword("abc");
		user.setUsername("abc");
		return user;
		//return userDAO.getUserByUserName(username);
		
	}

}
