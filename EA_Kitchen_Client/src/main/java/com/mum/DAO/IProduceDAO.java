package com.mum.DAO;

import java.util.List;

import com.mum.model.Produce;

public interface IProduceDAO {
	List<Produce> getProduces();
	
	String addFarmerProduceWithQuantityAndId(int produceId,int quantity);
}
