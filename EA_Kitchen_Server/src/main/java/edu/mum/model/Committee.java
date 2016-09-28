package edu.mum.model;

import javax.persistence.Entity;

@Entity
public class Committee extends User{
	
	public Committee() {
		// TODO Auto-generated constructor stub
		setUserRole(UserRole.ROLE_COMMITTEE);
	}
	
	

}
