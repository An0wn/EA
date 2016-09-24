package edu.mum.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produce {

	@Id @GeneratedValue
	private int produceId;
	
	private String produceName;
	private double producePrice;
	
	@OneToMany(mappedBy="produce")
	private List<FarmerProduce> farmerProduces=new ArrayList<FarmerProduce>();
	
	@OneToMany(mappedBy="produce")
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
