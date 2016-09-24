package com.mum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Schedule {
	
	
	private int scheduleId;
	

	private Customer customer;
	
	
	private Kitchen kitchen;
	
	
	private Date startDate;
	
	
	private Date endDate;
	
	
	private List<ScheduleUtensils> scheduleUtensils = new ArrayList<ScheduleUtensils>();
	
	
	private List<ScheduleProduce> scheduleProduces = new ArrayList<ScheduleProduce>();

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Kitchen getKitchen() {
		return kitchen;
	}

	public void setKitchen(Kitchen kitchen) {
		this.kitchen = kitchen;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<ScheduleUtensils> getScheduleUtensils() {
		return scheduleUtensils;
	}

	public void setScheduleUtensils(List<ScheduleUtensils> scheduleUtensils) {
		this.scheduleUtensils = scheduleUtensils;
	}

	public List<ScheduleProduce> getScheduleProduces() {
		return scheduleProduces;
	}

	public void setScheduleProduces(List<ScheduleProduce> scheduleProduces) {
		this.scheduleProduces = scheduleProduces;
	}

}
