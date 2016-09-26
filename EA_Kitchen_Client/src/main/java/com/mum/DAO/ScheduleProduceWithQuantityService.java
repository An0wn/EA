package com.mum.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.model.FarmerProduce;
import com.mum.model.ScheduleProduce;
import com.mum.model.ScheduleProduceWithQuantity;

@Component
public class ScheduleProduceWithQuantityService implements IScheduleProduceWithQuantityService{

	@Autowired
	FarmerProduceDAO famerProduceDAO;
	
	@Autowired
	ScheduleProduceDAO scheduleProduceDAO;
	
	@Override
	public List<ScheduleProduceWithQuantity> getScheduleProduceWithQuantity() {
		// TODO Auto-generated method stub
		List<ScheduleProduce> scheduleProduces = scheduleProduceDAO.getScheduleProduces();
		List<FarmerProduce> farmerProduces = famerProduceDAO.getFarmerProduces();
		
		List<ScheduleProduceWithQuantity> spqs=new ArrayList<ScheduleProduceWithQuantity>();
		
		for(ScheduleProduce scheduleProduce:scheduleProduces){
			int produceId=scheduleProduce.getProduce().getProduceId();
			int availableQuantity = 0;
			for(FarmerProduce farmerProduce:farmerProduces){
				if(farmerProduce.getProduce().getProduceId() == produceId){
					availableQuantity+=farmerProduce.getRemainingQuantity();
				}
			}
			ScheduleProduceWithQuantity spq= new ScheduleProduceWithQuantity(scheduleProduce,availableQuantity);
			spq.setMinQuantityAmongThem(Math.min(availableQuantity, scheduleProduce.getRemainingQuantity()));
			spqs.add(spq);
		}
		
		return spqs;
	}

}
