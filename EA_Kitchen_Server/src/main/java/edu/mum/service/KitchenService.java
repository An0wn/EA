package edu.mum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.DAO.IKitchenDAO;
import edu.mum.model.Kitchen;

@Service
public class KitchenService implements IKitchenDAO {

	@Autowired
	private IKitchenDAO kitchenDAO;

	public KitchenService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public <S extends Kitchen> S save(S entity) {
		// TODO Auto-generated method stub
		return kitchenDAO.save(entity);
	}

	@Override
	public <S extends Kitchen> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return kitchenDAO.save(entities);
	}

	@Override
	public Kitchen findOne(Integer id) {
		// TODO Auto-generated method stub
		return kitchenDAO.findOne(id);
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return kitchenDAO.exists(id);
	}

	@Override
	public Iterable<Kitchen> findAll() {
		// TODO Auto-generated method stub
		return kitchenDAO.findAll();
	}

	@Override
	public Iterable<Kitchen> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return kitchenDAO.findAll(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return kitchenDAO.count();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		kitchenDAO.delete(id);
	}

	@Override
	public void delete(Kitchen entity) {
		// TODO Auto-generated method stub
		kitchenDAO.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends Kitchen> entities) {
		// TODO Auto-generated method stub
		kitchenDAO.delete(entities);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		kitchenDAO.deleteAll();
	}

}
