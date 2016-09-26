package edu.mum.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.model.ScheduleFarmerProduce;

@Repository
public interface ScheduleFarmerProduceDAO extends JpaRepository<ScheduleFarmerProduce, Long>{

	public ScheduleFarmerProduce save(ScheduleFarmerProduce scheduleFarmerProduce);
	
	@Query("SELECT sfp FROM ScheduleFarmerProduce sfp WHERE sfp.farmerProduce.farmer.userId=?")
	public List<ScheduleFarmerProduce> getScheduleFarmerProduceByFarmerId(int farmerId);
	
}
