package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mum.DAO.IFarmerProduceDAO;

@Controller
public class FarmerProduceController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private IFarmerProduceDAO farmerProduceDAO;
	
	@RequestMapping(value="/farmerProduceList", method= RequestMethod.GET)
	public String getFarmerProducePage(Model model){
		model.addAttribute("farmerProduces", farmerProduceDAO.getFarmerProduces());
		//logger.debug("This is a debug message");
        logger.info("Method getFarmerProducePage has been called");
        //logger.warn("This is a warn message");
        //logger.error("This is an error message");
		return "farmerProducePage";
	}
	
	@RequestMapping(value="/farmerProduceList", method= RequestMethod.POST)
	public String addFarmerProducePage(Model model){
		model.addAttribute("farmerProduces", farmerProduceDAO.getFarmerProduces());
		logger.info("Method addFarmerProducePage has been called");
		return "redirect:/farmerProducePage";
	}
	
	
}
