<<<<<<< HEAD
package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.DAO.IProduceDAO;
import com.mum.DAO.ProduceDAO;

@Controller
public class ProduceController {
	@Resource
	private IProduceDAO produceDAO;
	
	@RequestMapping(value="/produceList", method= RequestMethod.GET)
	public String getProducePage(Model model){
		model.addAttribute("Produces", produceDAO.getProduces());
		return "ProducePage";
	}
	
	@RequestMapping(value="/produceList", method= RequestMethod.POST)
	public String addProducePage(Model model){
		model.addAttribute("Produces", produceDAO.getProduces());
		return "redirect:/ProducePage";
	}
	
}
=======
package com.mum.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.DAO.IProduceDAO;

@Controller
public class ProduceController {
	@Resource
	private IProduceDAO produceDAO;
	
	
	@RequestMapping(value="/ProduceList", method= RequestMethod.POST)
	public String addProducePage(){
		//UNCOMPLETE
		return "redirect:/ProducePage";
	}
	
}
>>>>>>> 772304a8f77baf29cb21580c9a7fbbfd83af84ee
