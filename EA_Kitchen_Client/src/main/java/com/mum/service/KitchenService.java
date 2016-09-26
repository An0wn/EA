package com.mum.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mum.config.AppConfig;
import com.mum.model.Kitchen;
import com.mum.model.ScheduleProduce;

@Component
public class KitchenService {
	private static final String kitchenList = AppConfig.ServerUrl + "/kitchen/getAllKitchen";
	private static final String addKitchen = AppConfig.ServerUrl + "/kitchen/add";
	private static final String editKitchen = AppConfig.ServerUrl + "/kitchen/edit";
	private static final String deleteKitchen = AppConfig.ServerUrl + "/kitchen/delete/{id}";
	private static final String findOne = AppConfig.ServerUrl + "/kitchen/find/{id}";

	public KitchenService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private RestTemplate restTemplate;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Kitchen> getAllKitchen() {
		ParameterizedTypeReference<List<Kitchen>> typeRef = new ParameterizedTypeReference<List<Kitchen>>() {
		};
		ResponseEntity<List<Kitchen>> response = restTemplate.exchange(kitchenList, HttpMethod.GET, null, typeRef);
		return response.getBody();
	}

	public Kitchen findOne(int id) {
		
		return restTemplate.getForObject(findOne, Kitchen.class, id);
		 
	}
	public void deleteOne(int id) {		
		 restTemplate.postForObject(deleteKitchen,id, Kitchen.class);
		 
	}
	public void Add(Kitchen kitchen) {
		restTemplate.postForLocation(addKitchen, kitchen, Kitchen.class);
	}

	public void edit(Kitchen kitchen) {
		restTemplate.postForLocation(addKitchen, kitchen, Kitchen.class);
	}
}
