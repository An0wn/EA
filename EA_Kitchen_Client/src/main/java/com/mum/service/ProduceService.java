package com.mum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.mum.config.AppConfig;
import com.mum.model.Produce;

@Component
public class ProduceService {

	//private static final String ServiceURL = "http://localhost:8081";
	private static final String ProduceListURL =  AppConfig.ServerUrl+"/produce/";//{farmerId}";
	private static final String ProduceURL =  AppConfig.ServerUrl+"/produce";
	
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
	
	public String saveFarmerProduce(int produceId,int quantity, int farmerId){
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("produceId", produceId+"");
		map.add("farmerId", farmerId+"");
		map.add("quantity", quantity+"");
		String returnMessage = restTemplate.postForObject(ProduceListURL, map, String.class);
		return returnMessage;
	}
}
