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
public class Schedule {
	
	@Id @GeneratedValue
	private int scheduleId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="kitchenId")
	private Kitchen kitchen;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@OneToMany(mappedBy="schedule")
	private List<ScheduleUtensils> scheduleUtensils = new ArrayList<ScheduleUtensils>();
	
	@OneToMany(mappedBy="schedule")
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
