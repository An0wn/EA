package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mum.DAO.IFarmerProduceDAO;
import com.mum.model.ScheduleFarmerProduce;

@Controller
public class FarmerProduceController {
	
	@Resource
	private IFarmerProduceDAO farmerProduceDAO;
	
	@RequestMapping(value="/farmerProduceList", method= RequestMethod.GET)
	public String getFarmerProducePage(Model model){
		model.addAttribute("farmerProduces", farmerProduceDAO.getFarmerProduces());
		return "farmerProducePage";
	}
	
	@RequestMapping(value="/farmerProduceList", method= RequestMethod.POST)
	public String addFarmerProducePage(Model model){
		model.addAttribute("farmerProduces", farmerProduceDAO.getFarmerProduces());
		return "redirect:/farmerProducePage";
	}
	
	
}
