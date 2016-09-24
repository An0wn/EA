package edu.mum.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.mum.model.ScheduleFarmerProduce;

@Transactional
public interface ScheduleFarmerProduceDAO extends CrudRepository<ScheduleFarmerProduce, Long>{

	public ScheduleFarmerProduce save(ScheduleFarmerProduce scheduleFarmerProduce);
	
	@Query("SELECT sfp FROM ScheduleFarmerProduce sfp WHERE sfp.farmerProduce.farmer.userId=?")
	public List<ScheduleFarmerProduce> getScheduleFarmerProduceByFarmerId(int farmerId);
	
}
