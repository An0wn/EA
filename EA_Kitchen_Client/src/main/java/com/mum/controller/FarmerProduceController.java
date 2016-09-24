package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.DAO.IFarmerProduceDAO;
import com.mum.model.ScheduleFarmerProduce;

public class FarmerProduceController {
	
	@Resource
	private IFarmerProduceDAO farmerProduceDAO;
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/farmerProducePage";
	}
	
	@RequestMapping(value="/farmerProducePage", method= RequestMethod.POST)
	public String addFarmerProducePage(){
		//UNCOMPLETE
		return "redirect:/scheduleProducePage";
	}
	
}
