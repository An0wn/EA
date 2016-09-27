package com.mum.DAO;

import java.util.List;

import com.mum.model.Kitchen;
import com.mum.model.Schedule;

public interface ICustomer {
	List<Kitchen> searchKitchenByAddress(String address);

	boolean checkkitchenAvailabilty(Schedule schdule);
	Schedule savekitchenSchedule(Schedule schdule);
	List<Schedule> scheduleByUserId(int userId);
}
