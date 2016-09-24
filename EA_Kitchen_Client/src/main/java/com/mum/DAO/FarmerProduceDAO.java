package com.mum.DAO;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.mum.model.FarmerProduce;
import com.mum.service.FarmerProduceService;

import edu.mum.application.EaKitchenClientApplication;

public class FarmerProduceDAO implements IFarmerProduceDAO {

	@Autowired
	FarmerProduceService service;
	
	@Override
	public Collection<FarmerProduce> getFarmerProduces() {
		return service.getFarmerProduceList(EaKitchenClientApplication.logginInUserId);
	}
	
}
