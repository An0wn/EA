package com.mum.DAO;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.EaKitchenClientApplication;
import com.mum.model.ScheduleProduce;
import com.mum.service.ScheduleFarmerProduceService;

@Component
public class ScheduleProduceDAO implements IScheduleProduceDAO{

	/*@Autowired
	ScheduleFarmerProduceService service;
	
	public ScheduleFarmerProduceService getService() {
		return service;
	}

	public void setService(ScheduleFarmerProduceService service) {
		this.service = service;
	}*/
	
	@Override
	public Collection<ScheduleProduce> getScheduleProduces() {
		// TODO Auto-generated method stub
		return null;
		//return service.getScheduleProduceList(EaKitchenClientApplication.logginInUserId);
	}

}
