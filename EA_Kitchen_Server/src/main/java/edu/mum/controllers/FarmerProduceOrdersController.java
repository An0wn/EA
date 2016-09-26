package edu.mum.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
import edu.mum.service.ScheduleFarmerProduceService;

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
		
		List<Produce> produces=new ArrayList<>();//farmerProduces.stream().map(map -> map.getProduce()).collect(Collectors.toList());
		
		for(FarmerProduce farmerProduce:farmerProduces){
			produces.add(farmerProduce.getProduce());
		}
		
		if(produces.isEmpty())
			return new ArrayList<ScheduleProduce>();
		List<ScheduleProduce> scheduleProduces=scheduleProduceDAO.findByProduceIdIn(produces);
		return scheduleProduces;
		/*Schedule sc=new Schedule();
		sc.setCity("Acity");
		sc.setAddress("Address");
		
		Schedule sc2=new Schedule();
		sc2.setCity("Acit2y2");
		sc2.setAddress("Ad2");
		
		Schedule sc3=new Schedule();
		sc3.setCity("Acity3");
		sc3.setAddress("Address3");
		
		
		Produce pr=new Produce();
		pr.setProduceName("ProduceName1");
		
		Produce pr2=new Produce();
		pr2.setProduceName("ProduceName12");
		
		Produce pr3=new Produce();
		pr3.setProduceName("ProduceName13");
		
		
		
		ScheduleProduce sp=new ScheduleProduce();
		sp.setDate(new Date());
		sp.setQuantity(10);
		sp.setRemainingQuantity(10);
		sp.setScheduleProduceId(1);
		sp.setProduce(pr);
		sp.setSchedule(sc);
		
		ScheduleProduce sp1=new ScheduleProduce();
		sp1.setDate(new Date());
		sp1.setQuantity(10);
		sp1.setRemainingQuantity(10);
		sp1.setScheduleProduceId(2);
		sp1.setProduce(pr2);
		sp1.setSchedule(sc);
		
		ScheduleProduce sp2=new ScheduleProduce();
		sp2.setDate(new Date());
		sp2.setQuantity(10);
		sp2.setRemainingQuantity(10);
		sp2.setScheduleProduceId(3);
		sp2.setProduce(pr3);
		sp2.setSchedule(sc2);
		
		ScheduleProduce sp3=new ScheduleProduce();
		sp3.setDate(new Date());
		sp3.setQuantity(10);
		sp3.setRemainingQuantity(10);
		sp3.setScheduleProduceId(4);
		sp3.setProduce(pr);
		sp3.setSchedule(sc3);
		
		List<ScheduleProduce> aList= Arrays.asList(sp,sp1,sp2,sp3);
		return aList;*/
	}
	
	//Add the acceptance
	/*@RequestMapping(value="/scheduleFarmerProduce", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveScheduleFarmerProduce(@RequestBody ScheduleFarmerProduce scheduleFarmerProduce){
		scheduleFarmerProduceService.save(scheduleFarmerProduce);
	}*/
	@RequestMapping(value="/scheduleFarmerProduce", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveScheduleFarmerProduce(@RequestParam("farmerId") String farmerId,@RequestParam("scheduleProduceId") String scheduleProduceId,@RequestParam("quantity") String quantity){
		
		ScheduleProduce scheduleProduce = scheduleProduceDAO.getByScheduleProduceId(Integer.parseInt(scheduleProduceId));
		FarmerProduce farmerProduce= farmerProduceDAO.getByFarmerId(Integer.parseInt(farmerId)).get(0);
		
		ScheduleFarmerProduce sfp = new ScheduleFarmerProduce();
		sfp.setDeliveryDate(scheduleProduce.getDate());
		sfp.setFarmerProduce(farmerProduce);
		sfp.setQuantity(Integer.parseInt(quantity));
		sfp.setScheduleProduce(scheduleProduce);
		
		scheduleFarmerProduceDAO.save(sfp);
	}
	
	//Get the List of Accepted list
	@RequestMapping(value="/scheduleFarmerProduce/{farmerId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Collection<ScheduleFarmerProduce> getScheduleFarmerProduce(@PathVariable("farmerId") int farmerId){
		
		return scheduleFarmerProduceDAO.getScheduleFarmerProduceByFarmerId(farmerId);
		
	}
	
	
	
	
	
}
