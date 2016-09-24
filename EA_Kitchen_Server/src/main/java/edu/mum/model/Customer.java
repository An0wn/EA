package edu.mum.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User{
	
	public Customer() {
		// TODO Auto-generated constructor stub
		setUserRole(UserRole.ROLE_CUSTOMER);
	}

	@OneToMany(mappedBy="customer")
	private List<Schedule> schedules=new ArrayList<Schedule>();

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
}
