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
public class ScheduleUtensils {
	@Id @GeneratedValue
	private int scheduleUtensilId;
	
	@ManyToOne
	@JoinColumn(name="scheduleId")
	private Schedule schedule;
	
	@ManyToOne
	@JoinColumn(name="utensilId")
	private Utensil utensil;
	
	private int quantity;
	
	@Temporal(TemporalType.DATE)
	private Date deliveryDate;

	public int getScheduleUtensilId() {
		return scheduleUtensilId;
	}

	public void setScheduleUtensilId(int scheduleUtensilId) {
		this.scheduleUtensilId = scheduleUtensilId;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Utensil getUtensil() {
		return utensil;
	}

	public void setUtensil(Utensil utensil) {
		this.utensil = utensil;
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
