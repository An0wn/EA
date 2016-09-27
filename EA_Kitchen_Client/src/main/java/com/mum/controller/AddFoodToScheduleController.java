package com.mum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mum.DAO.ProduceDAO;
import com.mum.DAO.ScheduleProduceDAO;
import com.mum.model.Customer;
import com.mum.model.Produce;
import com.mum.model.Schedule;
import com.mum.model.ScheduleProduce;
import com.mum.model.User;

@Controller
public class AddFoodToScheduleController {
	
	@Autowired
	ScheduleProduceDAO scheduleProduceDAO;
	
	@Autowired
	ProduceDAO produceDAO;
	
	
	@RequestMapping(value="/addFoodToSchedule/{scheduleId}", method=RequestMethod.GET)
	public String getAddedFoodSchedule(@PathVariable("scheduleId") int scheduleId,Model model,HttpSession session){
		
		///get all the food in schedule
		List<ScheduleProduce> scheduleProduces=scheduleProduceDAO.getScheduleProduceForSchedule(scheduleId);
		model.addAttribute("scheduleProduces", scheduleProduces);
		
		model.addAttribute("produces",produceDAO.getProduces());
		
		
		return "AddFoodToSchedule";
	}
	
	@RequestMapping(value="/addFoodToSchedule/{scheduleId}", method=RequestMethod.POST)
	public String postFoodSchedule(@PathVariable("scheduleId") int scheduleId,
			@RequestParam(value = "produces[]") String[] produceArray,
			@RequestParam(value = "quantity[]") String[] quantityArray,
			Model model,HttpSession session){
		
		//create scheduleProduce
		
		//get Schedule
		List<Schedule> schedules = (List<Schedule>)session.getAttribute("scheduleList");
		Schedule schedule=null;
		for(Schedule s:schedules){
			if(s.getScheduleId()==scheduleId){
				schedule=s;
				break;
			}
				
		}
		
		//get Produce
		List<Produce> produces = produceDAO.getProduces();
		
		//for(String produceId:produceArray){
		for(int i=0;i<produceArray.length;i++){
			Produce produce = null;
			for(Produce p:produces){
				if(p.getProduceId() == Integer.parseInt(produceArray[i])){
					produce = p;
					break;
				}
			}
			
			//we have produce, we have schedule so create ScheduleProeuce with quantity and save
			ScheduleProduce sp=new ScheduleProduce();
			sp.setDate(schedule.getStartDate());
			sp.setProduce(produce);
			sp.setQuantity(Integer.parseInt(produceArray[i]));
			sp.setRemainingQuantity(Integer.parseInt(produceArray[i]));
			sp.setSchedule(schedule);
			
			scheduleProduceDAO.saveScheduleProduce(sp);
			
		}
		
		return "redirect:/AddFoodToSchedule";
	}

}
