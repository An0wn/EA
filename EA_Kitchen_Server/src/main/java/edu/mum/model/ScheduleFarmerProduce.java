package edu.mum.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ScheduleFarmerProduce {
	@Id @GeneratedValue
	private int scheduleFarmerProduceId;
	
	@ManyToOne
	@JoinColumn(name="scheduleProduceId")
	private ScheduleProduce scheduleProduce;
	
	@ManyToOne
	@JoinColumn(name="farmerProduceId")
	private FarmerProduce farmerProduce;
	
	private int quantity;
	
	@Temporal(TemporalType.DATE)
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
