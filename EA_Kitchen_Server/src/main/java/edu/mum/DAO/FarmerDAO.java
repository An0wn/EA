package edu.mum.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.model.Farmer;


@Repository
public interface FarmerDAO extends CrudRepository<Farmer, Long>{
	
	Farmer getByUserId(int farmerId);
	
}
