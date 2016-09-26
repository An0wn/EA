package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.DAO.IProduceDAO;

@Controller
public class ProduceController {
	@Resource
	private IProduceDAO produceDAO;
		
	@RequestMapping(value="/ProducePage", method= RequestMethod.POST)
	public String addProducePage(){
		//UNCOMPLETE
		return "redirect:/ProducePage";
	}
	
}
