package com.mum.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mum.config.AppConfig;
import com.mum.model.User;

@Service
public class SecurityUserServices implements UserDetailsService {

	private static final String loadbyUserNameURL = AppConfig.ServerUrl + "/loadUserByUserName";
	// private static final String userbyUserNameURL = AppConfig.ServerUrl +
	// "/getUserByUserNameAndPassword";

	@Autowired
	private RestTemplate restTemplate;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public User findByUserName(String username) {
		return restTemplate.postForObject(loadbyUserNameURL, username, User.class);
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return findByUserName(username);
	}

	

}
