package com.mum.DAO;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.EaKitchenClientApplication;
import com.mum.model.ScheduleFarmerProduce;
import com.mum.service.ScheduleFarmerProduceService;

@Component
public class ScheduleFarmerProduceDAO implements IScheduleFarmerProduceDAO{

	@Autowired
	ScheduleFarmerProduceService service;
	
	@Override
	public void addScheduleFarmerProduce(ScheduleFarmerProduce scheduleFarmerProduce) {
		// TODO Auto-generated method stub
		service.saveScheduleFarmerProduce(scheduleFarmerProduce);
			
	}

	@Override
	public Collection<ScheduleFarmerProduce> getScheduleFarmerProduces() {
		// TODO Auto-generated method stub
		return service.getScheduleFarmerProduceList(EaKitchenClientApplication.logginInUserId);
	}

	@Override
	public void addScheduleFarmerProduceWithIdAndQuantity(int quantity, int scheduleProduceId) {
		// TODO Auto-generated method stub
		service.saveScheduleFarmerProduceByIdAndQuantity(scheduleProduceId, quantity,EaKitchenClientApplication.logginInUserId);
		
	}

}
