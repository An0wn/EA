package com.mum.model;

import java.util.ArrayList;
import java.util.List;

public class Utensil {

	
	private int utensilId;
	
	private String utensilName;
	private int quantity;
	private int remainingQuantity;
	
	
	private List<ScheduleUtensils> scheduleUtensils = new ArrayList<ScheduleUtensils>();

	public List<ScheduleUtensils> getScheduleUtensils() {
		return scheduleUtensils;
	}

	public void setScheduleUtensils(List<ScheduleUtensils> scheduleUtensils) {
		this.scheduleUtensils = scheduleUtensils;
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

	public int getUtensilId() {
		return utensilId;
	}

	public void setUtensilId(int utensilId) {
		this.utensilId = utensilId;
	}

	public String getUtensilName() {
		return utensilName;
	}

	public void setUtensilName(String utensilName) {
		this.utensilName = utensilName;
	}
}
