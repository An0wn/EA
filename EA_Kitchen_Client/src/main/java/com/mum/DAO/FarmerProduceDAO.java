package com.mum.DAO;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.EaKitchenClientApplication;
import com.mum.model.FarmerProduce;
import com.mum.service.FarmerProduceService;

@Component
public class FarmerProduceDAO implements IFarmerProduceDAO {

	@Autowired
	FarmerProduceService service;
	
	public FarmerProduceService getService() {
		return service;
	}

	public void setService(FarmerProduceService service) {
		this.service = service;
	}

	@Override
	public List<FarmerProduce> getFarmerProduces() {
		return service.getFarmerProduceList(EaKitchenClientApplication.logginInUserId);
	}

	//Ban Added
	/*@Override
	public FarmerProduce getFarmerProduceByProduceId(int produceId) {
		// TODO Auto-generated method stub
		return service.getFarmerProduceByProduceId(produceId);
	}*/
	
}
