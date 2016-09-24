package edu.mum.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.mum.model.ScheduleProduce;

@Transactional
public interface ScheduleProduceDAO extends CrudRepository<ScheduleProduce, Long>{
	
	@Query("SELECT sc FROM ScheduleProduce sc WHERE sc.date > CURRENT_DATE AND sc.remainingQuantity > 0 AND sc.produceId IN (?)")
	List<ScheduleProduce> findByProduceIdIn(String csvProduceIds);
}
