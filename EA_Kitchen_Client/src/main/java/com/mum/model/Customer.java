package com.mum.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
	
	public Customer() {
		// TODO Auto-generated constructor stub
		setUserRole(UserRole.ROLE_CUSTOMER);
	}

	private List<Schedule> schedules=new ArrayList<Schedule>();

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
}
