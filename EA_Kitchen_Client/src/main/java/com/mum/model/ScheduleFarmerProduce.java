package com.mum.model;

import java.util.Date;


public class ScheduleFarmerProduce {
	
	private int scheduleFarmerProduceId;
	
	
	private ScheduleProduce scheduleProduce;
	
	
	private FarmerProduce farmerProduce;
	
	private int quantity;
	
	
	private Date deliveryDate;
	
	public int getScheduleFarmerProduceId() {
		return scheduleFarmerProduceId;
	}

	public void setScheduleFarmerProduceId(int scheduleFarmerProduceId) {
		this.scheduleFarmerProduceId = scheduleFarmerProduceId;
	}

	public ScheduleProduce getScheduleProduce() {
		return scheduleProduce;
	}

	public void setScheduleProduce(ScheduleProduce scheduleProduce) {
		this.scheduleProduce = scheduleProduce;
	}

	public FarmerProduce getFarmerProduce() {
		return farmerProduce;
	}

	public void setFarmerProduce(FarmerProduce farmerProduce) {
		this.farmerProduce = farmerProduce;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	
	
}
