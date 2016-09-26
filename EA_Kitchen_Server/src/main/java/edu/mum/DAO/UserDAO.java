package edu.mum.DAO;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.mum.model.User;

@Transactional
public interface UserDAO extends CrudRepository<User, String> {
	@Query("SELECT u FROM User u where u.username=?")
	User getUserByUserName(String userName);

}
