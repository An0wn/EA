package edu.mum.DAO;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.mum.model.Produce;
import edu.mum.model.ScheduleProduce;

//@Transactional
@Repository
public interface ScheduleProduceDAO extends CrudRepository<ScheduleProduce, Long>{
	
	@Query("SELECT sc FROM ScheduleProduce sc WHERE sc.date > CURRENT_DATE AND "
			+ "sc.remainingQuantity > 0 AND sc.produce IN :produces")
	public List<ScheduleProduce> findByProduceIdIn(@Param("produces") Set<Produce> produces);
	
	public ScheduleProduce getByScheduleProduceId(int scheduleProduceId);
	
	@Modifying
	@Transactional
	@Query("UPDATE ScheduleProduce sc SET sc.remainingQuantity = :remQuantity WHERE sc.scheduleProduceId = :scheduleProduceId")
	void updateRemainingQuantityFor(@Param("remQuantity") int remainingQuantity, @Param("scheduleProduceId") int scheduleProduceId);
}
