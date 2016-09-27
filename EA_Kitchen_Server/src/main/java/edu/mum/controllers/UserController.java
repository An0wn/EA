package edu.mum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.mum.DAO.UserDAO;
import edu.mum.model.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/getUserByUserNameAndPassword", method = RequestMethod.POST)
	public @ResponseBody User getUserByUserNameAndPassword(@RequestBody User user) {
		User uer = userDAO.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		return uer;

	}

}
