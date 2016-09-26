package com.mum.DAO;

import java.util.Collection;

import com.mum.model.ScheduleFarmerProduce;

public interface IScheduleFarmerProduceDAO {

	//void addScheduleFarmerProduce(ScheduleFarmerProduce scheduleFarmerProduce);
	
	String addScheduleFarmerProduceWithIdAndQuantity(int quantity,int scheduleProduceId);
	
	Collection<ScheduleFarmerProduce> getScheduleFarmerProduces();
}
