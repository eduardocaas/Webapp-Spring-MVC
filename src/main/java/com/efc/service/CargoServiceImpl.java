package com.efc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efc.dao.CargoDAO;
import com.efc.domain.Cargo;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoDAO dao;
	
	@Override
	public void save(Cargo cargo) {
		dao.save(cargo);
	}

	@Override
	public void update(Cargo cargo) {
		dao.update(cargo);	
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> findAll() {
		return dao.findAll();
	}

	@Override
	public boolean cargoFuncionarios(Long id) {
		if(findById(id).getFuncionarios().isEmpty()) {
			return false;
		}
		return true;
		
	}

}
