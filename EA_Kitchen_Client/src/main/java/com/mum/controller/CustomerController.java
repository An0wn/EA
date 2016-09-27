package com.mum.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.DAO.ICustomer;
import com.mum.model.Address;
import com.mum.model.Customer;
import com.mum.model.Kitchen;
import com.mum.model.Schedule;
import com.mum.model.User;
import com.mum.validator.DateValidator;

@Controller
public class CustomerController {

	@Resource
	private ICustomer customer;

	@Autowired
	DateValidator dateValidator;

	@RequestMapping("/customer")
	public String CustomerMainPage() {
		return "customer";
	}

	@RequestMapping(value = "/searchKitchen", method = RequestMethod.GET)
	public ModelAndView searchKitchen(@RequestParam("Address") String address,
			HttpSession session/* , RedirectAttributes redirect */) {
		ModelAndView mav = new ModelAndView();
		List<Kitchen> kitchens = customer.searchKitchenByAddress(address);
		if (kitchens.size() < 0) {
			mav.addObject("error", "no kicthen in that area");
		} else {
			session.setAttribute("kitchens", kitchens);
			mav.addObject("kitchens", kitchens);
			mav.setViewName("SearchKitchedList");
		}
		// redirect.addFlashAttribute("kitchens",kitchens);
		// return

		return mav;
	}

	@RequestMapping(value = "/availableKitchen")
	public String availableKitchen(Address model) {
		return "redirect:/farmerProducePage";
	}

	@RequestMapping(value = "/checkAvailability")
	public void checkAvailability(int kitchenId, Date date) {

	}

	@RequestMapping(value = "/schedulekitchen", method = RequestMethod.POST)
	public ModelAndView schedulekitchen(@RequestParam("kitchenId") int kitchenId, HttpSession session) {
		List<Kitchen> kitchenlist = (List<Kitchen>) session.getAttribute("kitchens");
		Kitchen k = kitchenlist.stream().filter(x -> x.getKitchenId() == kitchenId).collect(Collectors.toList()).get(0);
		ModelAndView mav = new ModelAndView();
		mav.addObject("schedule", new Schedule());
		mav.addObject("currentKitchen", k);
		session.setAttribute("currentKitchen", k);
		mav.setViewName("ScheduleKitchen");
		return mav;
	}

	@RequestMapping(value = "/saveschedulekitchen", method = RequestMethod.POST)
	public String saveschedulekitchen(@Valid @ModelAttribute("schedule") Schedule schedule, BindingResult result,
			HttpSession session, RedirectAttributes redirect) {
		dateValidator.validate(schedule, result);
		if (result.hasErrors()) {
			return "ScheduleKitchen";
		} else {
			Customer loggedUser = new Customer((User) session.getAttribute("currentUser"));
			Kitchen k = (Kitchen) session.getAttribute("currentKitchen");
			schedule.setCustomer(loggedUser);
			schedule.setKitchen(k);
			if (customer.checkkitchenAvailabilty(schedule)) {
				customer.savekitchenSchedule(schedule);
				return "redirect:/scheduleList";
			} else {
				redirect.addFlashAttribute("error", "Kitchen is not available.try another");
				return "redirect:/customer";
			}
		}

	}

	@RequestMapping(value = "/scheduleList", method = RequestMethod.GET)
	public ModelAndView scheduleList(HttpSession session) {
		Customer loggedUser = new Customer((User) session.getAttribute("currentUser"));
		ModelAndView mav = new ModelAndView();
		List<Schedule> schedules = customer.scheduleByUserId(loggedUser.getUserId());
		session.setAttribute("scheduleList", schedules);
		mav.addObject("schedules", schedules);
		mav.addObject("currenUser", loggedUser);
		mav.setViewName("ScheduleList");
		return mav;
	}

}
