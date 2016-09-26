package com.mum.DAO;

import java.util.Collection;

import com.mum.model.FarmerProduce;

public interface IFarmerProduceDAO {
	Collection<FarmerProduce> getFarmerProduces();
	
	//Ban Added
	//FarmerProduce getFarmerProduceByProduceId(int produceId);
}
