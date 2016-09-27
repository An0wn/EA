package com.mum.controller;

import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mum.DAO.IUserDAO;
import com.mum.model.User;

@Controller
public class HomeController {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	@Resource
	private IUserDAO userDao;
	
	@RequestMapping("/homeI")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "ABCD Team ff") String name,
			Model model) {
		model.addAttribute("name", name);
		return "home";
	}
	@RequestMapping("/")
	public String home(){
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(User user,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User puser=userDao.loginUser(user);
		if (puser.equals(null)) {
			mav.addObject("error", "username or password mismatch");
		} else {
			session.setAttribute("currentUser", puser);
			mav.addObject("currentUser", puser);
			mav.setViewName("customer");
		}
		return mav;
		//return "redirect:/customer";
	}

}
