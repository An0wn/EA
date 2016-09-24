package com.mum.DAO;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.mum.model.ScheduleProduce;
import com.mum.service.ScheduleFarmerProduceService;

import edu.mum.application.EaKitchenClientApplication;

public class ScheduleProduceDAO implements IScheduleProduceDAO{

	@Autowired
	ScheduleFarmerProduceService service;
	
	@Override
	public Collection<ScheduleProduce> getScheduleProduces() {
		// TODO Auto-generated method stub
		return service.getScheduleProduceList(EaKitchenClientApplication.logginInUserId);
	}

}
