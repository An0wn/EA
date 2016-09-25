package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.DAO.IScheduleFarmerProduceDAO;
import com.mum.DAO.IScheduleProduceDAO;
import com.mum.DAO.ScheduleFarmerProduceDAO;
import com.mum.DAO.ScheduleProduceDAO;
import com.mum.model.ScheduleFarmerProduce;

@Controller
public class ScheduleFarmerProduceController {

	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/scheduleProducePage";
	}
	
	@RequestMapping(value="/scheduleProducePage", method= RequestMethod.GET)
	public String getScheduleProducePage(Model model){
		model.addAttribute("scheduleProduces", scheduleProduceDAO.getScheduleProduces());
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
	
	@Autowired
	private ScheduleProduceDAO scheduleProduceDAO;
	
	public ScheduleProduceDAO getScheduleProduceDAO() {
		return scheduleProduceDAO;
	}

	public ScheduleFarmerProduceDAO getScheduleFarmerProduceDAO() {
		return scheduleFarmerProduceDAO;
	}

	public void setScheduleProduceDAO(ScheduleProduceDAO scheduleProduceDAO) {
		this.scheduleProduceDAO = scheduleProduceDAO;
	}

	public void setScheduleFarmerProduceDAO(ScheduleFarmerProduceDAO scheduleFarmerProduceDAO) {
		this.scheduleFarmerProduceDAO = scheduleFarmerProduceDAO;
	}

	@Autowired
	private ScheduleFarmerProduceDAO scheduleFarmerProduceDAO;
	
}
