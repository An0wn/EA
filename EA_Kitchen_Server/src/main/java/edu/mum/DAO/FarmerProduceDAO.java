package edu.mum.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.mum.model.FarmerProduce;
import edu.mum.model.ScheduleProduce;

//@Transactional
@Repository
public interface FarmerProduceDAO extends CrudRepository<FarmerProduce, Long>{

	@Query("SELECT fp FROM FarmerProduce fp WHERE fp.farmer.userId=? AND fp.remainingQuantity > 0 ORDER BY fp.date ASC")
	List<FarmerProduce> getByFarmerId(int farmerId);
	
	public FarmerProduce getByFarmerProduceId(int farmerProduceId);
	
	@Modifying
	@Transactional
	@Query("UPDATE FarmerProduce fc SET fc.remainingQuantity = :remQuantity WHERE fc.farmerProduceId = :farmerProduceId")
	void updateRemainingQuantityFor(@Param("remQuantity") int remainingQuantity, @Param("farmerProduceId") int farmerProduceId);
}
