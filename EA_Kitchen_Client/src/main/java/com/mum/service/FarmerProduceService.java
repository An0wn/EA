package com.mum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mum.model.FarmerProduce;

@Component
public class FarmerProduceService {
	private static final String ServiceURL = "http://localhost:8080/EA_Kitchen_Server/rest";
	private static final String FarmerProduceListURL = ServiceURL+"/FarmerProduce/";//{farmerId}";
	private static final String FarmerProduceURL = ServiceURL+"/FarmerProduce";
	
	@Autowired
	private RestTemplate restTemplate;
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Collection<FarmerProduce> getFarmerProduceList(int farmerId){
		ParameterizedTypeReference<Collection<FarmerProduce>> typeRef = new ParameterizedTypeReference<Collection<FarmerProduce>>() {};
		ResponseEntity<Collection<FarmerProduce>> response = restTemplate.exchange(FarmerProduceListURL+farmerId, HttpMethod.GET, null, typeRef);
		return response.getBody();
	}
	
	public void saveFarmerProduce(FarmerProduce FarmerProduce){
		restTemplate.postForObject(FarmerProduceURL, FarmerProduce, FarmerProduce.class);
	}
	
}
