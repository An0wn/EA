package edu.mum.DAO;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.model.Produce;
import edu.mum.model.ScheduleFarmerProduce;
import edu.mum.model.ScheduleProduce;

public interface ProduceDAO extends JpaRepository<Produce, Long>{
	
	public Produce save(Produce produce);
	
	@Query("SELECT p FROM Produce p")
	public List<Produce> getAll();

}
