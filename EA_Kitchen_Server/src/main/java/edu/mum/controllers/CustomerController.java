package edu.mum.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.DAO.CustomerDAO;
import edu.mum.DAO.ScheduleDAO;
import edu.mum.model.Kitchen;
import edu.mum.model.Schedule;
import edu.mum.model.User;

@Controller
public class CustomerController {
	@Autowired
	CustomerDAO customerDAO;

	@Autowired
	ScheduleDAO scheduleDAO;

	@RequestMapping(value = "/kitchenByAddress/{address}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Kitchen> getKitchenByAddress(@PathVariable("address") String address) {
		List<Kitchen> kitchenList = customerDAO.getKitchenByAddress("%" + address + "%");
		return kitchenList;
	}

	@RequestMapping(value = "/checkKitchenAvailability", method = RequestMethod.POST)
	public @ResponseBody boolean checkKitchenAvailability(@RequestBody Schedule schedule) {
		return scheduleDAO.checkAvailabilityKitchen(schedule.getKitchen().getKitchenId(), schedule.getStartDate(),
				schedule.getEndDate());
	}

	@RequestMapping(value = "/savekitchenSchedule", method = RequestMethod.POST)
	public @ResponseBody Schedule savekitchenSchedule(@RequestBody Schedule schedule) {
		return scheduleDAO.save(schedule);
	}

	@RequestMapping(value = "/scheduleByUserId/{userId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Schedule> scheduleByUserId(@PathVariable("userId") int userId) {
		return scheduleDAO.getScheduleByUserId(userId);
	}

}
