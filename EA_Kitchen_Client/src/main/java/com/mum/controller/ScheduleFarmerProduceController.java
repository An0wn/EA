package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mum.DAO.FarmerProduceDAO;
import com.mum.DAO.IScheduleFarmerProduceDAO;
import com.mum.DAO.IScheduleProduceDAO;
import com.mum.DAO.ScheduleFarmerProduceDAO;
import com.mum.DAO.ScheduleProduceDAO;
import com.mum.DAO.ScheduleProduceWithQuantityService;
import com.mum.model.ScheduleFarmerProduce;
import com.mum.model.ScheduleProduce;


@Controller
public class ScheduleFarmerProduceController {

	@Autowired
	private ScheduleProduceWithQuantityService scheduleProduceWithQuantityService;
	
	@Autowired
	private ScheduleFarmerProduceDAO scheduleFarmerProduceDAO;
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/scheduleProduceList";
	}
	
	@RequestMapping(value="/scheduleProduceList", method= RequestMethod.GET)
	public String getScheduleProducePage(Model model){
		model.addAttribute("scheduleProduceWithQuantity", scheduleProduceWithQuantityService.getScheduleProduceWithQuantity());
		return "ScheduleProducePage";
	}
	
	@RequestMapping(value="/scheduleProduceList", method= RequestMethod.POST)
	public String addScheduleProducePage(@RequestParam("quantity") int quantity,@RequestParam("scheduleProduceId") int scheduleProduceId){
		
		String returnMessage=scheduleFarmerProduceDAO.addScheduleFarmerProduceWithIdAndQuantity(quantity, scheduleProduceId);
		if(returnMessage.equals("")){//everyting is fine
			return "redirect:/scheduleFarmerProduceList";
		}
		else{//somthing went wrong, send a message
			return "redirect:/error/"+returnMessage;
		}
		
	}
	
	@RequestMapping(value="/scheduleFarmerProduceList", method= RequestMethod.GET)
	public String getScheduleFarmerProducePage(Model model){
		model.addAttribute("scheduleFarmerProduces", scheduleFarmerProduceDAO.getScheduleFarmerProduces());
		return "ScheduleFarmerProducePage";
	}
	
	
	
}
