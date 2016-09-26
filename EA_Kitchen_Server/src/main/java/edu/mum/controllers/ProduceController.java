package edu.mum.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.DAO.FarmerDAO;
import edu.mum.DAO.FarmerProduceDAO;
import edu.mum.DAO.ProduceDAO;
import edu.mum.model.Farmer;
import edu.mum.model.FarmerProduce;
import edu.mum.model.Produce;

@Controller
public class ProduceController {

	@Autowired
	FarmerProduceDAO farmerProduceDAO;

	@Autowired
	ProduceDAO produceDAO;
	
	@Autowired
	FarmerDAO farmerDAO;

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

	// Add the acceptance
		@RequestMapping(value = "/produce", method = RequestMethod.POST)
		@ResponseStatus(HttpStatus.CREATED)
		public @ResponseBody String saveProduce(@RequestParam("farmerId") String farmerId, @RequestParam("produceId") String produceId, @RequestParam("quantity") String quantity) {
			int quantityInt = Integer.parseInt(quantity);
			int farmerIdInt = Integer.parseInt(farmerId);
			int produceIdInt = Integer.parseInt(produceId);
			
			Farmer farmer = farmerDAO.getByUserId(farmerIdInt);
			Produce produce = produceDAO.getByProduceId(produceIdInt);
			
			FarmerProduce aFarmerProduce = new FarmerProduce();
			aFarmerProduce.setFarmer(farmer);
			aFarmerProduce.setProduce(produce);
			aFarmerProduce.setDate(new Date());
			aFarmerProduce.setQuantity(quantityInt);
			aFarmerProduce.setRemainingQuantity(quantityInt);
			
			farmerProduceDAO.save(aFarmerProduce);	
			
			return "";
		}
}
