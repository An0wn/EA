package com.mum.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mum.config.AppConfig;
import com.mum.model.Address;
import com.mum.model.Kitchen;
import com.mum.model.Produce;
import com.mum.model.Schedule;
import com.mum.model.UserOld;

@Component
public class CustomerService {
	private static final String KitchenByAddressListURL = AppConfig.ServerUrl + "/kitchenByAddress/";// {farmerId}";
	private static final String checkAvailabilityURL = AppConfig.ServerUrl + "/checkKitchenAvailability";// {farmerId}";
	private static final String saveSchedulekitchen = AppConfig.ServerUrl + "/savekitchenSchedule";
	private static final String scheduleList = AppConfig.ServerUrl + "/scheduleByUserId/";

	@Autowired
	private RestTemplate restTemplate;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Collection<Kitchen> getKitchenByAddress(String address) {
		ParameterizedTypeReference<Collection<Kitchen>> typeRef = new ParameterizedTypeReference<Collection<Kitchen>>() {
		};
		ResponseEntity<Collection<Kitchen>> response = restTemplate.exchange(KitchenByAddressListURL + address,
				HttpMethod.GET, null, typeRef);
		return response.getBody();
	}

	public boolean checkkitchenAvailabilty(Schedule schdule) {
		return restTemplate.postForObject(checkAvailabilityURL, schdule, Boolean.class);
	}

	public Schedule savekitchenSchedule(Schedule schdule) {
		return restTemplate.postForObject(saveSchedulekitchen, schdule, Schedule.class);
	}

	public List<Schedule> scheduleByUserId(int userId) {
		ParameterizedTypeReference<List<Schedule>> typeRef = new ParameterizedTypeReference<List<Schedule>>() {
		};
		ResponseEntity<List<Schedule>> response = restTemplate.exchange(scheduleList + userId, HttpMethod.GET, null,
				typeRef);
		return response.getBody();
	}

}
