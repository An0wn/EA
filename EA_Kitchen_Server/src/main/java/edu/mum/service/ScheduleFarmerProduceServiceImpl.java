package edu.mum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.DAO.ScheduleFarmerProduceDAO;
import edu.mum.model.ScheduleFarmerProduce;

//@Service
public class ScheduleFarmerProduceServiceImpl implements ScheduleFarmerProduceService{

	//@Autowired
    private ScheduleFarmerProduceDAO scheduleFarmerProduceDAO;
    public void setScheduleFarmerProduceDAO(ScheduleFarmerProduceDAO scheduleFarmerProduceDAO) {
		this.scheduleFarmerProduceDAO = scheduleFarmerProduceDAO;
	}

	
	@Override
	public ScheduleFarmerProduce save(ScheduleFarmerProduce scheduleFarmerProduce) {
		// TODO Auto-generated method stub
		return scheduleFarmerProduceDAO.save(scheduleFarmerProduce);
	}

	@Override
	public List<ScheduleFarmerProduce> getScheduleFarmerProduceByFarmerId(int farmerId) {
		// TODO Auto-generated method stub
		return scheduleFarmerProduceDAO.getScheduleFarmerProduceByFarmerId(farmerId);
	}

}
