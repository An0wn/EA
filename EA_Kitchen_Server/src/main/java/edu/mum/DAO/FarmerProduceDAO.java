package edu.mum.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.mum.model.FarmerProduce;

//@Transactional
@Repository
public interface FarmerProduceDAO extends CrudRepository<FarmerProduce, Long>{

	@Query("SELECT fp FROM FarmerProduce fp WHERE fp.farmer.userId=? AND fp.remainingQuantity > 0 ORDER BY fp.date ASC")
	List<FarmerProduce> getByFarmerId(int farmerId);
	
	/*@Query("SELECT fp FROM FarmerProduce WHERE fp.farmer.userId=? AND fp.remainingQuantity > 0 ORDER BY date ASC LIMIT 1")
	FarmerProduce getAByFarmerIdOrderByDateASC(int farmerId);*/
}
