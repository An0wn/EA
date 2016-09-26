package com.mum.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.model.Kitchen;
import com.mum.model.KitchenType;
import com.mum.service.KitchenService;

@Controller
@RequestMapping("/kitchen")
public class KitchenController {

	@Autowired
	private KitchenService kitchenService;

	public KitchenController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/list")
	public String getAllKitchen(Model model) {
		model.addAttribute("kitchens", kitchenService.getAllKitchen());
		return "kitchenList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addKitchen() {
		return "addKitchen";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	// @ResponseStatus(HttpStatus.CREATED)
	public String addKitchenA(@RequestParam("kitchenName") String name, @RequestParam("city") String city,
			@RequestParam("kitchenType") KitchenType kitchenType, @RequestParam("address") String address,
			RedirectAttributes redirectAttrs) {
		Kitchen kit = new Kitchen();
		kit.setKitchenName(name);
		kit.setAddress(address);
		kit.setCity(city);
		kit.setKitchenType(kitchenType);
		kitchenService.Add(kit);
		redirectAttrs.addFlashAttribute("kitchens", kitchenService.getAllKitchen());
		return "redirect:/kitchenList";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Model model) {
		/*
		 * ModelAndView mav=new ModelAndView(); mav.setViewName("editKitchen");
		 * mav.addObject(kitchenService.findOne(id)); return mav;
		 */
		model.addAttribute("kitchen", kitchenService.findOne(id));
		return "editKitchen";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	// @ResponseStatus(HttpStatus.CREATED)
	public String edit(@RequestParam("kitchenName") String name, @RequestParam("kitchenId") int kitchenId,
			@RequestParam("city") String city, @RequestParam("kitchenType") KitchenType kitchenType,
			@RequestParam("address") String address, RedirectAttributes redirectAttrs) {
		Kitchen kit = new Kitchen();
		kit.setKitchenName(name);
		kit.setAddress(address);
		kit.setCity(city);
		kit.setKitchenType(kitchenType);
		kit.setKitchenId(kitchenId);
		kitchenService.Add(kit);

		redirectAttrs.addFlashAttribute("kitchens", kitchenService.getAllKitchen());
		return "redirect:/kitchen/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Model model) {
		/*
		 * ModelAndView mav=new ModelAndView(); mav.setViewName("editKitchen");
		 * mav.addObject(kitchenService.findOne(id)); return mav;
		 */
		kitchenService.deleteOne(id);
		model.addAttribute("kitchens", kitchenService.getAllKitchen());
		return "kitchenList";
	}

}
