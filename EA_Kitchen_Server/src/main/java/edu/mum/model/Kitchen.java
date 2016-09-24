package edu.mum.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kitchen {

	@Id @GeneratedValue
	private int kitchenId;
	
	private String kitchenName;
	private String Address;
	private String city;
	
	@OneToMany(mappedBy="kitchen")
	private List<Schedule> schedules=new ArrayList<Schedule>();
	
	@Enumerated(EnumType.STRING)
	private KitchenType kitchenType;
	
	public KitchenType getKitchenType() {
		return kitchenType;
	}
	public void setKitchenType(KitchenType kitchenType) {
		this.kitchenType = kitchenType;
	}
	public List<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	public int getKitchenId() {
		return kitchenId;
	}
	public void setKitchenId(int kitchenId) {
		this.kitchenId = kitchenId;
	}
	public String getKitchenName() {
		return kitchenName;
	}
	public void setKitchenName(String kitchenName) {
		this.kitchenName = kitchenName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
