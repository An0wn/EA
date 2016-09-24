package com.mum.model;

import java.util.ArrayList;
import java.util.List;

public class Produce {

	
	private int produceId;
	
	private String produceName;
	private double producePrice;
	
	
	private List<FarmerProduce> farmerProduces=new ArrayList<FarmerProduce>();
	
	
	private List<ScheduleProduce> scheduleProduces=new ArrayList<ScheduleProduce>();

	
	public List<ScheduleProduce> getScheduleProduces() {
		return scheduleProduces;
	}
	public void setScheduleProduces(List<ScheduleProduce> scheduleProduces) {
		this.scheduleProduces = scheduleProduces;
	}
	public List<FarmerProduce> getFarmerProduces() {
		return farmerProduces;
	}
	public void setFarmerProduces(List<FarmerProduce> farmerProduces) {
		this.farmerProduces = farmerProduces;
	}
	public int getProduceId() {
		return produceId;
	}
	public void setProduceId(int produceId) {
		this.produceId = produceId;
	}
	public String getProduceName() {
		return produceName;
	}
	public void setProduceName(String produceName) {
		this.produceName = produceName;
	}
	public double getProducePrice() {
		return producePrice;
	}
	public void setProducePrice(double producePrice) {
		this.producePrice = producePrice;
	}
}
