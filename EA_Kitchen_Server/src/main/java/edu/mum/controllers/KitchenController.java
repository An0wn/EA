
package edu.mum.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.DAO.IKitchenDAO;
import edu.mum.model.Kitchen;
import edu.mum.model.ScheduleProduce;

@Controller
@RequestMapping("/kitchen")
public class KitchenController {

	public KitchenController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private IKitchenDAO kitchenService;

	@RequestMapping(value = "/getAllKitchen", method = RequestMethod.GET)
	public @ResponseBody List<Kitchen> getAllKitchen() {
		return  (List<Kitchen>) kitchenService.findAll();

	}

	@RequestMapping(value = "/test")
	public @ResponseBody Collection<Kitchen> test() {
		Kitchen k=new Kitchen();
		k.setKitchenName("dewei");
		k.setAddress("北京市海淀区");
		kitchenService.save(k);
		return	(Collection<Kitchen>) kitchenService.findAll();
		// "dewei xiang";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Kitchen kitchen) {
		kitchenService.save(kitchen);
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void Edit(@RequestBody Kitchen kitchen){
		kitchenService.save(kitchen);
	}
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public @ResponseBody Kitchen findOne(@PathVariable("id") int id){
		return kitchenService.findOne(id);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@PathVariable("id") int id){
		kitchenService.delete(id);
	}

}

