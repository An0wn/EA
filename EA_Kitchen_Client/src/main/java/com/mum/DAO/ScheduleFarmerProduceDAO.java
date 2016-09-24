package com.mum.DAO;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.mum.model.ScheduleFarmerProduce;
import com.mum.service.ScheduleFarmerProduceService;

import edu.mum.application.EaKitchenClientApplication;

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

}
