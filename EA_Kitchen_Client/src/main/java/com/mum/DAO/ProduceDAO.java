package com.mum.DAO;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.mum.model.Produce;
import com.mum.service.ProduceService;

import edu.mum.application.EaKitchenClientApplication;

public class ProduceDAO implements IProduceDAO {
	
	@Autowired
	ProduceService service;

	@Override
	public Collection<Produce> getProduces() {
		return service.getProduceList(EaKitchenClientApplication.logginInUserId);
	}

}
