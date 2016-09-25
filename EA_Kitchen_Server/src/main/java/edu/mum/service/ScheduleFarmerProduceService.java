package edu.mum.service;

import java.util.List;

import edu.mum.model.ScheduleFarmerProduce;

public interface ScheduleFarmerProduceService {

	public ScheduleFarmerProduce save(ScheduleFarmerProduce scheduleFarmerProduce);
	
	public List<ScheduleFarmerProduce> getScheduleFarmerProduceByFarmerId(int farmerId);

}
