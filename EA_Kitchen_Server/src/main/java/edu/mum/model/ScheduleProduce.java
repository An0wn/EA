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
	private int remainingQuantity;
	
	@Temporal(TemporalType.DATE)
	private Date date;

}
