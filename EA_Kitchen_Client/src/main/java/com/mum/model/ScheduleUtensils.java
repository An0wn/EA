package com.mum.model;

import java.util.Date;

public class ScheduleUtensils {
	
	private int scheduleUtensilId;
	
	
	private Schedule schedule;
	
	
	private Utensil utensil;
	
	private int quantity;
	
	
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
