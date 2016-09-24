package com.mum.model;

import java.util.ArrayList;
import java.util.List;

public class Farmer extends User{
	public Farmer() {
		// TODO Auto-generated constructor stub
		setUserRole(UserRole.ROLE_FARMER);
	}
	
	private List<FarmerProduce> farmerProduces=new ArrayList<FarmerProduce>();

	public List<FarmerProduce> getFarmerProduces() {
		return farmerProduces;
	}

	public void setFarmerProduces(List<FarmerProduce> farmerProduces) {
		this.farmerProduces = farmerProduces;
	}

	

	
}
