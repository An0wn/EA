package edu.mum.DAO;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.mum.model.Kitchen;


@Transactional

public interface KitchenDAO extends CrudRepository<Kitchen, Integer> {

}
