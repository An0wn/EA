package com.mum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mum.model.FarmerProduce;
import com.mum.model.Produce;
@Component
public class ProduceService {
	private static final String ServiceURL = "http://localhost:8080/EA_Kitchen_Server/rest";
	private static final String ProduceListURL = ServiceURL+"/Produce/";//{farmerId}";
	private static final String ProduceURL = ServiceURL+"/Produce";
	
	@Autowired
	private RestTemplate restTemplate;
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Collection<Produce> getProduceList(int produceId){ //ID ???
		ParameterizedTypeReference<Collection<Produce>> typeRef = new ParameterizedTypeReference<Collection<Produce>>() {};
		ResponseEntity<Collection<Produce>> response = restTemplate.exchange(ProduceListURL+produceId, HttpMethod.GET, null, typeRef);
		return response.getBody();
	}
	
	public void saveProduce(Produce Produce){
		restTemplate.postForObject(ProduceURL, Produce, Produce.class);
	}
}
