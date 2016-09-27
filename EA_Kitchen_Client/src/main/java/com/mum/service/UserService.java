package com.mum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mum.config.AppConfig;
import com.mum.model.User;

@Component
public class UserService {
	private static final String userbyUserNameURL = AppConfig.ServerUrl + "/getUserByUserNameAndPassword";
	@Autowired
	private RestTemplate restTemplate;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public User loginUser(User user) {
		return restTemplate.postForObject(userbyUserNameURL, user, User.class);
	}

}