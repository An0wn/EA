package com.mum.DAO;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.config.EaKitchenClientApplication;
import com.mum.model.ScheduleProduce;
import com.mum.service.ScheduleFarmerProduceService;

@Component
public class ScheduleProduceDAO implements IScheduleProduceDAO{

	@Autowired
	ScheduleFarmerProduceService service;
	
	public ScheduleFarmerProduceService getService() {
		return service;
	}

	public void setService(ScheduleFarmerProduceService service) {
		this.service = service;
	}
	
	@Override
	public List<ScheduleProduce> getScheduleProduces() {
		// TODO Auto-generated method stub
		return service.getScheduleProduceList(EaKitchenClientApplication.logginInUserId);
	}

}
