package edu.mum.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.model.Schedule;

@Repository
public interface ScheduleDAO extends JpaRepository<Schedule, Long> {

	@Query("select case when (count(s) > 0)  then false else true end from Schedule s where s.kitchen.kitchenId = :kitchenId and s.startDate between :startDate and :endDate and s.startDate between :startDate and :endDate")
	boolean checkAvailabilityKitchen(@Param("kitchenId") int kitchenId, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	 Schedule save(Schedule schedule);
	 
	 @Query("select s from Schedule s where s.customer.userId=:userId")
	 List<Schedule> getScheduleByUserId(@Param("userId")int userId);
}
