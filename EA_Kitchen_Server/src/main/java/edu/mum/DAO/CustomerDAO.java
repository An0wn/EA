package edu.mum.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.model.Kitchen;

@Repository
public interface CustomerDAO extends CrudRepository<Kitchen, Long> {

	@Query("select k from Kitchen k where k.Address like :address")
	List<Kitchen> getKitchenByAddress(@Param("address") String address);
	
	

}
