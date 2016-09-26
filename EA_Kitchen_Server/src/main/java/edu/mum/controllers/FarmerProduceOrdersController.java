package edu.mum.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import edu.mum.DAO.FarmerProduceDAO;
import edu.mum.DAO.ScheduleFarmerProduceDAO;
import edu.mum.DAO.ScheduleProduceDAO;
import edu.mum.model.FarmerProduce;
import edu.mum.model.Produce;
import edu.mum.model.Schedule;
import edu.mum.model.ScheduleFarmerProduce;
import edu.mum.model.ScheduleProduce;

@Controller
public class FarmerProduceOrdersController {


	/*@Autowired
	ScheduleFarmerProduceService scheduleFarmerProduceService;
	

	public void setScheduleFarmerProduceService(ScheduleFarmerProduceService scheduleFarmerProduceService) {
		this.scheduleFarmerProduceService = scheduleFarmerProduceService;
	}
*/
	@Autowired
	ScheduleFarmerProduceDAO scheduleFarmerProduceDAO;

	@Autowired
	ScheduleProduceDAO scheduleProduceDAO;

	@Autowired
	FarmerProduceDAO farmerProduceDAO;

	
	//get the scheduleProduce Requests
	@RequestMapping(value="/scheduleProduce/{farmerId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<ScheduleProduce> getScheduleProduce(@PathVariable("farmerId") int farmerId){
		/*
		 * Get the list of all the valid produce that the farmer with farmerId has
		 * then collect the produceIds in an string 
		 * and find the requested produces
		 * */
		List<FarmerProduce> farmerProduces=farmerProduceDAO.getByFarmerId(farmerId);
		
		Set<Produce> produces=new HashSet<>();//farmerProduces.stream().map(map -> map.getProduce()).collect(Collectors.toList());
		
		for(FarmerProduce farmerProduce:farmerProduces){
			produces.add(farmerProduce.getProduce());
		}
		
		if(produces.isEmpty())
			return new ArrayList<ScheduleProduce>();
		List<ScheduleProduce> scheduleProduces=scheduleProduceDAO.findByProduceIdIn(produces);
		return scheduleProduces;
	}
	
	//Add the acceptance
	@RequestMapping(value="/scheduleFarmerProduce", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody String saveScheduleFarmerProduce(@RequestParam("farmerId") String farmerId,@RequestParam("scheduleProduceId") String scheduleProduceId,@RequestParam("quantity") String quantity){
		
		int quantityInt=Integer.parseInt(quantity);
		int farmerIdInt=Integer.parseInt(farmerId);
		int scheduleProduceIdInt=Integer.parseInt(scheduleProduceId);
		
		
		ScheduleProduce scheduleProduce = scheduleProduceDAO.getByScheduleProduceId(scheduleProduceIdInt);
		List<FarmerProduce> farmerProduces = farmerProduceDAO.getByFarmerId(farmerIdInt);
		
		//Double Check to see if the quanitiy fits or already claimed by others
		if(scheduleProduce.getRemainingQuantity() == 0){
			//it means someone else has fulfilled the task 
			return "Somebody else already agreed to deliver the produce";
		}
		
		//iterate so that the 
		int quantityNow=quantityInt;
		for(FarmerProduce farmerProduce:farmerProduces){
			
			int quantityToSet=Math.min(quantityNow, farmerProduce.getRemainingQuantity());
			quantityNow -=quantityToSet;
			
			ScheduleFarmerProduce sfp = new ScheduleFarmerProduce();
			sfp.setDeliveryDate(scheduleProduce.getDate());
			sfp.setFarmerProduce(farmerProduce);
			sfp.setQuantity(quantityToSet);
			sfp.setScheduleProduce(scheduleProduce);
			
			
			scheduleFarmerProduceDAO.save(sfp);
			//now that the quanitty is accepted we need to change the remaining quantity for both the produce and the scheuldeProduce
			scheduleProduceDAO.updateRemainingQuantityFor(scheduleProduce.getRemainingQuantity()-quantityToSet, scheduleProduceIdInt);
			//update the quantity for thefarmerproduce
			farmerProduceDAO.updateRemainingQuantityFor(farmerProduce.getRemainingQuantity()-quantityToSet, farmerProduce.getFarmerProduceId());
			
			//if not equals zero then run the quantity again
			//if 0, it means its full
			if(quantityNow==0){
				break;
			}
		}
		
				
		return "";
	}
	
	//Get the List of Accepted list
	@RequestMapping(value="/scheduleFarmerProduce/{farmerId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<ScheduleFarmerProduce> getScheduleFarmerProduce(@PathVariable("farmerId") int farmerId){
		
		return scheduleFarmerProduceDAO.getScheduleFarmerProduceByFarmerId(farmerId);
		
	}
	
	//Get the farmerProduce List
	
	@RequestMapping(value="/FarmerProduce/{farmerId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<FarmerProduce> getFarmerProduce(@PathVariable("farmerId") int farmerId){
		
		return farmerProduceDAO.getByFarmerId(farmerId);
		
	}
	
	
	
	
}
