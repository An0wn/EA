package com.mum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mum.config.AppConfig;
import com.mum.model.FarmerProduce;

@Component
public class FarmerProduceService {
	
	private static final String FarmerProduceListURL = AppConfig.ServerUrl+"/farmerProduce/";//{farmerId}";
	private static final String FarmerProduceURL = AppConfig.ServerUrl+"/farmerProduce";
	
	@Autowired
	private RestTemplate restTemplate;
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<FarmerProduce> getFarmerProduceList(int farmerId){
		ParameterizedTypeReference<List<FarmerProduce>> typeRef = new ParameterizedTypeReference<List<FarmerProduce>>() {};
		ResponseEntity<List<FarmerProduce>> response = restTemplate.exchange(FarmerProduceListURL+farmerId, HttpMethod.GET, null, typeRef);
		return response.getBody();
	}
	
	public void saveFarmerProduce(FarmerProduce FarmerProduce){
		restTemplate.postForObject(FarmerProduceURL, FarmerProduce, FarmerProduce.class);
	}
	
	/*//Ban Added
	public FarmerProduce getFarmerProduceByProduceId(int produceId){
		return restTemplate.postForObject(FarmerProduceListURL+"{produceId}", produceId, FarmerProduce.class);
	}
	//End Ban Added
*/}
