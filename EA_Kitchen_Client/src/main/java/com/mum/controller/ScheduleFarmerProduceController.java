package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.DAO.IScheduleFarmerProduceDAO;
import com.mum.DAO.IScheduleProduceDAO;
import com.mum.model.ScheduleFarmerProduce;

@Controller
public class ScheduleFarmerProduceController {

	@Resource
	private IScheduleProduceDAO scheduleProduceDAO;
	
	@Resource
	private IScheduleFarmerProduceDAO scheduleFarmerProduceDAO;

	
	@RequestMapping(value="/scheduleProducePage", method= RequestMethod.GET)
	public String getScheduleProducePage(Model model){
		model.addAttribute("scheduleProduce", scheduleProduceDAO.getScheduleProduces());
		return "scheduleProducePage";
	}
	
	@RequestMapping(value="/scheduleProducePage", method= RequestMethod.POST)
	public String addScheduleProducePage(ScheduleFarmerProduce scheduleFarmerProduce){
		scheduleFarmerProduceDAO.addScheduleFarmerProduce(scheduleFarmerProduce);
		return "redirect:/scheduleProducePage";
	}
	
	@RequestMapping(value="/scheduleFarmerProducePage", method= RequestMethod.GET)
	public String getScheduleFarmerProducePage(Model model){
		model.addAttribute("scheduleFarmerProduce", scheduleFarmerProduceDAO.getScheduleFarmerProduces());
		return "scheduleFarmerProducePage";
	}
	
}
