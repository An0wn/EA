package com.mum.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.model.Address;
import com.mum.model.Kitchen;
import com.mum.model.Schedule;
import com.mum.service.CustomerService;

@Component
public class Customer implements ICustomer {

	@Autowired
	CustomerService customerService;

	public List<Kitchen> searchKitchenByAddress(String address) {
		return (List<Kitchen>) customerService.getKitchenByAddress(address);
	}

	public boolean checkkitchenAvailabilty(Schedule schdule) {
		return customerService.checkkitchenAvailabilty(schdule);
	}

	public Schedule savekitchenSchedule(Schedule schdule) {
		return customerService.savekitchenSchedule(schdule);
	}

	public List<Schedule> scheduleByUserId(int userId) {
		return customerService.scheduleByUserId(userId);
	}

}
