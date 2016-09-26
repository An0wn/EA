package edu.mum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.DAO.FarmerProduceDAO;
import edu.mum.DAO.ProduceDAO;
import edu.mum.model.FarmerProduce;
import edu.mum.model.Produce;

@Controller
public class ProduceController {

	@Autowired
	FarmerProduceDAO farmerProduceDAO;
	
	@Autowired
	ProduceDAO produceDAO;
	
	// Get the farmerProduce List

		@RequestMapping(value = "/farmerProduce/{farmerId}", method = RequestMethod.GET)
		@ResponseStatus(HttpStatus.OK)
		public @ResponseBody List<FarmerProduce> getFarmerProduce(@PathVariable("farmerId") int farmerId) {

			return farmerProduceDAO.getByFarmerId(farmerId);

		}

		// Get the Produce List

			@RequestMapping(value = "/produce", method = RequestMethod.GET)
			@ResponseStatus(HttpStatus.OK)
			public @ResponseBody List<Produce> getProduce() {

				return produceDAO.getAll();

			}

}
