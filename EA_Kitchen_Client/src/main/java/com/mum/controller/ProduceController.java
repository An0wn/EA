package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mum.DAO.IProduceDAO;

@Controller
public class ProduceController {
	@Resource
	private IProduceDAO produceDAO;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/produceList", method= RequestMethod.GET)
	public String getProducePage(Model model){
		model.addAttribute("Produces", produceDAO.getProduces());
		logger.info("Method getProducePage has been called");
		return "ProducePage";
	}
	
	@RequestMapping(value="/produceList", method= RequestMethod.POST)
	public String addProducePage(@RequestParam("quantity") int quantity,@RequestParam("produceId") int produceId){
		produceDAO.addFarmerProduceWithQuantityAndId(produceId, quantity);
		logger.info("Method addProducePage has been called");
		return "redirect:/farmerProduceList";
	}
	
}
