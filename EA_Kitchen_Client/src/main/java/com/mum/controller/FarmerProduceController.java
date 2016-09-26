package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.DAO.IFarmerProduceDAO;
import com.mum.model.ScheduleFarmerProduce;

@Controller
public class FarmerProduceController {
	
	@Resource
	private IFarmerProduceDAO farmerProduceDAO;
	
	
	@RequestMapping(value="/farmerProducePage", method= RequestMethod.POST)
	public String addFarmerProducePage(){
		//UNCOMPLETE
		return "redirect:/scheduleProducePage";
	}
	
}
