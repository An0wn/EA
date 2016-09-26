package com.mum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FarmerProduce {

	private int farmerProduceId;
	private Farmer farmer;
	private Produce produce;
	private int quantity;
	private int remainingQuantity;
	private Date date;
	private List<ScheduleFarmerProduce> scheduleFarmerProduces = new ArrayList<ScheduleFarmerProduce>();

	public List<ScheduleFarmerProduce> getScheduleFarmerProduces() {
		return scheduleFarmerProduces;
	}

	public void setScheduleFarmerProduces(List<ScheduleFarmerProduce> scheduleFarmerProduces) {
		this.scheduleFarmerProduces = scheduleFarmerProduces;
	}

	public int getFarmerProduceId() {
		return farmerProduceId;
	}

	public void setFarmerProduceId(int farmerProduceId) {
		this.farmerProduceId = farmerProduceId;
	}


	public Produce getProduce() {
		return produce;
	}

	public void setProduce(Produce produce) {
		this.produce = produce;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
}
