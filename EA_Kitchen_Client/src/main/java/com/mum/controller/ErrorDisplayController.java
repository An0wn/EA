package com.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorDisplayController {

	@RequestMapping(value="/error/{message}", method=RequestMethod.GET)
	public String setTheErrorPage(@PathVariable String message,Model model){
		model.addAttribute("messageFromServer", message);
		return "ErrorDisplay";
	}
	
}
