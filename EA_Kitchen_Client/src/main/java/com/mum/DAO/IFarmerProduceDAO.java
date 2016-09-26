package com.mum.DAO;

import java.util.Collection;
import java.util.List;

import com.mum.model.FarmerProduce;

public interface IFarmerProduceDAO {
	List<FarmerProduce> getFarmerProduces();
	
	//Ban Added
	//FarmerProduce getFarmerProduceByProduceId(int produceId);
}
