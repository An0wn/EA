package edu.mum.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.DAO.ScheduleProduceDAO;
import edu.mum.model.ScheduleProduce;

@Controller
public class ScheduleProduceForCustomerController {
	
	@Autowired
	ScheduleProduceDAO scheduleProduceDAO;
	
	
	@RequestMapping(value = "/scheduleProduce/{customerId}/{scheduleId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<ScheduleProduce> getScheduleProduce(@PathVariable("customerId") int customerId
			,@PathVariable("scheduleId") int scheduleId) {
		
		//get the scheuleProduce By CustomerId and scheduleId
		return scheduleProduceDAO.findByCustomerIdAndScheduleId(customerId,scheduleId);
	}

}
