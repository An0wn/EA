package com.mum.model;

public class User {

	private int userId;
	private String username;
	private String password;

	private UserRole userRole;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	protected void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public User(User u) {
		this.userId =u.userId;
		this.username = u.username;
		this.password = u.password;
		this.userRole = u.userRole;
	}

	public User() {
	}
}
