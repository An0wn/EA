package com.mum.DAO;

import java.util.Collection;
import java.util.List;

import com.mum.model.ScheduleProduce;

public interface IScheduleProduceDAO {
	List<ScheduleProduce> getScheduleProduces();
	
	List<ScheduleProduce> getScheduleProduceForSchedule(int scheduleId);
	
	void saveScheduleProduce(ScheduleProduce scheduleProduce);
}
