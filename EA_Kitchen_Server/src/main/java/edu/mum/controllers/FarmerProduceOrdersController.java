package edu.mum.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.DAO.FarmerProduceDAO;
import edu.mum.DAO.ScheduleFarmerProduceDAO;
import edu.mum.DAO.ScheduleProduceDAO;
import edu.mum.model.FarmerProduce;
import edu.mum.model.ScheduleFarmerProduce;
import edu.mum.model.ScheduleProduce;

@Controller
public class FarmerProduceOrdersController {

	//@Autowired
	ScheduleFarmerProduceDAO scheduleFarmerProduceDAO;
	//@Autowired
	ScheduleProduceDAO scheduleProduceDAO;
	//@Autowired
	FarmerProduceDAO farmerProduceDAO;
	
	//get the scheduleProduce Requests
	@RequestMapping(value="/scheduleProduce/{farmerId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Collection<ScheduleProduce> getScheduleProduce(@PathVariable("farmerId") int farmerId){
		/*
		 * Get the list of all the valid produce that the farmer with farmerId has
		 * then collect the produceIds in an string 
		 * and find the requested produces
		 * */
		List<FarmerProduce> farmerProduces=farmerProduceDAO.getByFarmerId(farmerId);
		String queryInValue="";
		for(int i=0;i<farmerProduces.size();i++){
			queryInValue+=farmerProduces.get(i).getFarmerProduceId();
			if(i==farmerProduces.size())
				queryInValue+=",";
		}
		
		return scheduleProduceDAO.findByProduceIdIn(queryInValue);
	}
	
	//Add the acceptance
	@RequestMapping(value="/scheduleFarmerProduce", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveScheduleFarmerProduce(@RequestBody ScheduleFarmerProduce scheduleFarmerProduce){
		scheduleFarmerProduceDAO.save(scheduleFarmerProduce);
	}
	
	//Get the List of Accepted list
	@RequestMapping(value="/scheduleFarmerProduce/{farmerId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Collection<ScheduleFarmerProduce> getScheduleFarmerProduce(@PathVariable("farmerId") int farmerId){
		
		return scheduleFarmerProduceDAO.getScheduleFarmerProduceByFarmerId(farmerId);
		
	}
	
	
	
	
	
}
