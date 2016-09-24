package edu.mum.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.mum.model.FarmerProduce;

@Transactional
public interface FarmerProduceDAO extends CrudRepository<FarmerProduce, Long>{

	@Query("SELECT fp FROM FarmerProduce WHERE fp.farmer.userId=? AND fp.remainingQuantity > 0")
	List<FarmerProduce> getByFarmerId(int farmerId);
}
