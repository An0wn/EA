package com.mum.model;

public class ScheduleProduceWithQuantity {

	private int availableQuantity;
	private ScheduleProduce scheduleProduce;
	private int minQuantityAmongThem;
	
	public int getMinQuantityAmongThem() {
		return minQuantityAmongThem;
	}

	public void setMinQuantityAmongThem(int minQuantityAmongThem) {
		this.minQuantityAmongThem = minQuantityAmongThem;
	}

	public ScheduleProduceWithQuantity() {
		// TODO Auto-generated constructor stub
	}
	
	public ScheduleProduceWithQuantity(ScheduleProduce scheduleProduce,int availableQuantity) {
		this.setAvailableQuantity(availableQuantity);
		this.setScheduleProduce(scheduleProduce);
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public ScheduleProduce getScheduleProduce() {
		return scheduleProduce;
	}

	public void setScheduleProduce(ScheduleProduce scheduleProduce) {
		this.scheduleProduce = scheduleProduce;
	}
}
