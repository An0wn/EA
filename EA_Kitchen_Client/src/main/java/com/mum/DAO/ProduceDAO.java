package com.mum.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.config.EaKitchenClientApplication;
import com.mum.model.Produce;
import com.mum.service.ProduceService;

@Component
public class ProduceDAO implements IProduceDAO {
	
	@Autowired
	ProduceService service;

	public ProduceService getService() {
		return service;
	}

	public void setService(ProduceService service) {
		this.service = service;
	}

	@Override
	public List<Produce> getProduces() {
		return service.getProduceList();
	}

	@Override
	public String addFarmerProduceWithQuantityAndId(int produceId, int quantity) {
		// TODO Auto-generated method stub
		return service.saveFarmerProduce(produceId, quantity, EaKitchenClientApplication.logginInUserId);
	}

}
