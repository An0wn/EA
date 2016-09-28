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
public class ScheduleProduce {
	
	@Id @GeneratedValue
	private int scheduleProduceId;
	
	@ManyToOne
	@JoinColumn(name="scheduleId")
	private Schedule schedule;
	
	@ManyToOne
	@JoinColumn(name="produceId")
	private Produce produce;
	
	private int quantity;
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

	private int remainingQuantity;
	
	@Temporal(TemporalType.DATE)
	private Date date;

}
