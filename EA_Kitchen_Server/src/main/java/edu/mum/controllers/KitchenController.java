package edu.mum.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.DAO.KitchenDAO;
import edu.mum.model.Kitchen;
import edu.mum.model.ScheduleProduce;

@Controller
@RequestMapping("/kitchen")
public class KitchenController {

	public KitchenController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private KitchenDAO kitchenDAO;
	
//	public void setKitchenDAO(KitchenDAO kitchenDAO) {
//		this.kitchenDAO = kitchenDAO;
//	}

	@RequestMapping(value="/getAllKitchen", method = RequestMethod.GET)
	public @ResponseBody String getAllKitchen(){
		//return (Collection<Kitchen>) kitchenDAO.findAll();
		return "test";
	}  
	
	@RequestMapping("/test")
	public @ResponseBody String test(){
		return "dewei xiang";
	}
	
}
