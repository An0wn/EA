package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.DAO.IProduceDAO;

public class ProduceController {
	@Resource
	private IProduceDAO produceDAO;
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/ProducePage";
	}
	
	@RequestMapping(value="/ProducePage", method= RequestMethod.POST)
	public String addProducePage(){
		//UNCOMPLETE
		return "redirect:/ProducePage";
	}
	
}
