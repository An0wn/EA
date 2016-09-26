package com.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/homeI")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "ABCD Team ff") String name,
			Model model) {
		model.addAttribute("name", name);
		return "home";
	}
}
