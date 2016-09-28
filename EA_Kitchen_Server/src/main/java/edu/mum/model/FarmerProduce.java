package edu.mum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FarmerProduce {

	@Id @GeneratedValue
	private int farmerProduceId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Farmer farmer;
	
	@ManyToOne
	@JoinColumn(name="produceId")
	private Produce produce;
	
	private int quantity;
	private int remainingQuantity;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany(mappedBy="farmerProduce")
	private List<ScheduleFarmerProduce> scheduleFarmerProduces = new ArrayList<ScheduleFarmerProduce>();
	

	/*public List<ScheduleFarmerProduce> getScheduleFarmerProduces() {
		return scheduleFarmerProduces;
	}
*/
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
