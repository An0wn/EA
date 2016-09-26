package com.mum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.mum.model.Produce;

@Component
public class ProduceService {

	//private static final String ServiceURL = "http://localhost:8081";
	private static final String ProduceListURL =  AppConfig.ServerUrl+"/Produce/";//{farmerId}";
	private static final String ProduceURL =  AppConfig.ServerUrl+"/Produce";
	
	@Autowired
	private RestTemplate restTemplate;
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<Produce> getProduceList(){ //ID ???
		ParameterizedTypeReference<List<Produce>> typeRef = new ParameterizedTypeReference<List<Produce>>() {};
		ResponseEntity<List<Produce>> response = restTemplate.exchange(ProduceListURL, HttpMethod.GET, null, typeRef);
		return response.getBody();
	}
	
	public void saveProduce(Produce Produce){
		restTemplate.postForObject(ProduceListURL, Produce, Produce.class);
	}
}
