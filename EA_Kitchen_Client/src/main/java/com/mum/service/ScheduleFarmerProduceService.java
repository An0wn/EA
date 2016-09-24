package com.mum.service;

import java.util.Collection;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mum.model.ScheduleFarmerProduce;
import com.mum.model.ScheduleProduce;

public class ScheduleFarmerProduceService {
	private static final String ServiceURL = "http://localhost:8080/EA_Kitchen_Server/rest";
	private static final String ScheduleProduceListURL = ServiceURL+"/scheduleProduce/";//{farmerId}";
	private static final String ScheduleFarmerProduceListURL = ServiceURL+"/scheduleFarmerProduce/";//{farmerId}";
	private static final String ScheduleFarmerProduceURL = ServiceURL+"/scheduleFarmerProduce";
	
	private RestTemplate restTemplate;
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Collection<ScheduleProduce> getScheduleProduceList(int farmerId){
		ParameterizedTypeReference<Collection<ScheduleProduce>> typeRef = new ParameterizedTypeReference<Collection<ScheduleProduce>>() {};
		ResponseEntity<Collection<ScheduleProduce>> response = restTemplate.exchange(ScheduleProduceListURL+farmerId, HttpMethod.GET, null, typeRef);
		return response.getBody();
	}
	
	public Collection<ScheduleFarmerProduce> getScheduleFarmerProduceList(int farmerId){
		ParameterizedTypeReference<Collection<ScheduleFarmerProduce>> typeRef = new ParameterizedTypeReference<Collection<ScheduleFarmerProduce>>() {};
		ResponseEntity<Collection<ScheduleFarmerProduce>> response = restTemplate.exchange(ScheduleFarmerProduceListURL+farmerId, HttpMethod.GET, null, typeRef);
		return response.getBody();
	}
	
	public void saveScheduleFarmerProduce(ScheduleFarmerProduce scheduleFarmerProduce){
		restTemplate.postForObject(ScheduleFarmerProduceURL, scheduleFarmerProduce, ScheduleFarmerProduce.class);
	}	
}
