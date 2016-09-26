package com.mum.model;

import java.util.Date;

public class ScheduleProduce {
	
	
	public int getScheduleProduceId() {
		return scheduleProduceId;
	}


	public void setScheduleProduceId(int scheduleProduceId) {
		this.scheduleProduceId = scheduleProduceId;
	}


	public Schedule getSchedule() {
		return schedule;
	}


	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
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


	private int scheduleProduceId;
	
	
	private Schedule schedule;
	
	
	private Produce produce;
	
	private int quantity;
	private int remainingQuantity;
	
	
	private Date date;

}
