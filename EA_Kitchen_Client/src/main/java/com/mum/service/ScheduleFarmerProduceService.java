package com.mum.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
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
import com.mum.model.Schedule;
import com.mum.model.ScheduleFarmerProduce;
import com.mum.model.ScheduleProduce;

@Component
public class ScheduleFarmerProduceService {
	//private static final String ServiceURL = "http://localhost:8081";
	private static final String ScheduleProduceURL =  AppConfig.ServerUrl+"/scheduleProduce";//{farmerId}";
	private static final String ScheduleFarmerProduceURL =  AppConfig.ServerUrl+"/scheduleFarmerProduce";//{farmerId}";
	
	@Autowired
	private RestTemplate restTemplate;
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<ScheduleProduce> getScheduleProduceList(int farmerId){
		ParameterizedTypeReference<List<ScheduleProduce>> typeRef = new ParameterizedTypeReference<List<ScheduleProduce>>() {};
		ResponseEntity<List<ScheduleProduce>> response = restTemplate.exchange(ScheduleProduceURL+"/"+farmerId, HttpMethod.GET, null, typeRef);
		return response.getBody();
	}
	
	public List<ScheduleFarmerProduce> getScheduleFarmerProduceList(int farmerId){
		ParameterizedTypeReference<List<ScheduleFarmerProduce>> typeRef = new ParameterizedTypeReference<List<ScheduleFarmerProduce>>() {};
		ResponseEntity<List<ScheduleFarmerProduce>> response = restTemplate.exchange(ScheduleFarmerProduceURL+"/"+farmerId, HttpMethod.GET, null, typeRef);
		return response.getBody();
		
	}
	
	/*public void saveScheduleFarmerProduce(ScheduleFarmerProduce scheduleFarmerProduce){
		restTemplate.postForObject(ScheduleFarmerProduceURL, scheduleFarmerProduce, ScheduleFarmerProduce.class);
	}*/	
	
	public String saveScheduleFarmerProduceByIdAndQuantity(int scheduleProduceId,int quantity,int farmerId){
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("scheduleProduceId", scheduleProduceId+"");
		map.add("farmerId", farmerId+"");
		map.add("quantity", quantity+"");
		String returnMessage = restTemplate.postForObject(ScheduleFarmerProduceURL, map, String.class);
		return returnMessage;
		//restTemplate.postForObject(ScheduleFarmerProduceURL+"/{id}/{quantity}", id,quantity, ScheduleFarmerProduce.class);
	}	
	
	
	/*Schedule sc=new Schedule();
	sc.setCity("Acity");
	sc.setAddress("Address");
	
	Schedule sc2=new Schedule();
	sc2.setCity("Acit2y2");
	sc2.setAddress("Address2");
	
	Schedule sc3=new Schedule();
	sc3.setCity("Acity3");
	sc3.setAddress("Address3");
	
	
	Produce pr=new Produce();
	pr.setProduceName("ProduceName1");
	
	Produce pr2=new Produce();
	pr2.setProduceName("ProduceName12");
	
	Produce pr3=new Produce();
	pr3.setProduceName("ProduceName13");
	
	
	
	ScheduleProduce sp=new ScheduleProduce();
	sp.setDate(new Date());
	sp.setQuantity(10);
	sp.setRemainingQuantity(10);
	sp.setScheduleProduceId(1);
	sp.setProduce(pr);
	sp.setSchedule(sc);
	
	ScheduleProduce sp1=new ScheduleProduce();
	sp1.setDate(new Date());
	sp1.setQuantity(10);
	sp1.setRemainingQuantity(10);
	sp1.setScheduleProduceId(2);
	sp1.setProduce(pr2);
	sp1.setSchedule(sc);
	
	ScheduleProduce sp2=new ScheduleProduce();
	sp2.setDate(new Date());
	sp2.setQuantity(10);
	sp2.setRemainingQuantity(10);
	sp2.setScheduleProduceId(3);
	sp2.setProduce(pr3);
	sp2.setSchedule(sc2);
	
	ScheduleProduce sp3=new ScheduleProduce();
	sp3.setDate(new Date());
	sp3.setQuantity(10);
	sp3.setRemainingQuantity(10);
	sp3.setScheduleProduceId(4);
	sp3.setProduce(pr);
	sp3.setSchedule(sc3);
	
	ScheduleFarmerProduce sfp = new ScheduleFarmerProduce();
	sfp.setQuantity(12);
	sfp.setScheduleProduce(sp1);
	
	ScheduleFarmerProduce sfp2 = new ScheduleFarmerProduce();
	sfp2.setQuantity(1);
	sfp2.setScheduleProduce(sp2);
	
	ScheduleFarmerProduce sfp3 = new ScheduleFarmerProduce();
	sfp3.setQuantity(6);
	sfp3.setScheduleProduce(sp3);
	
	List<ScheduleFarmerProduce> aList= Arrays.asList(sfp,sfp2,sfp3);
	return aList;*/
}
