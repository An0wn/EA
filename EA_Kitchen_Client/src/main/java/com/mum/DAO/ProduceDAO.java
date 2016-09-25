package com.mum.DAO;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.EaKitchenClientApplication;
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
	public Collection<Produce> getProduces() {
		return service.getProduceList(EaKitchenClientApplication.logginInUserId);
	}

}
