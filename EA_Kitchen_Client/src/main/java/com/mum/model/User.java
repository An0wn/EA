package com.mum.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

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
		this.userId =u.getUserId();
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.userRole = u.getUserRole();
	}

	public User() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(UserRole.ROLE_COMMITTEE.toString()));
        authorityList.add(new SimpleGrantedAuthority(UserRole.ROLE_CUSTOMER.toString()));
        authorityList.add(new SimpleGrantedAuthority(UserRole.ROLE_FARMER.toString()));
        return authorityList;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
