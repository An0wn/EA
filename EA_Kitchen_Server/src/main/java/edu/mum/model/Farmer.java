package edu.mum.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Farmer extends User{
	public Farmer() {
		// TODO Auto-generated constructor stub
		setUserRole(UserRole.ROLE_FARMER);
	}
	
	@OneToMany(mappedBy="farmer")
	private List<FarmerProduce> farmerProduces=new ArrayList<FarmerProduce>();

	/*public List<FarmerProduce> getFarmerProduces() {
		return farmerProduces;
	}*/

	public void setFarmerProduces(List<FarmerProduce> farmerProduces) {
		this.farmerProduces = farmerProduces;
	}

	

	
}
