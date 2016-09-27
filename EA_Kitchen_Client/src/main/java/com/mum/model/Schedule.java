package com.mum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class Schedule {
	
	
	private int scheduleId;
	
	private String address;
	private String city;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private Customer customer;
	
	
	private Kitchen kitchen;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
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
