package com.efc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efc.dao.DepartamentoDAO;
import com.efc.domain.Departamento;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDAO dao;
	
	@Override
	public void save(Departamento departamento) {
		dao.save(departamento);		
	}

	@Override
	public void update(Departamento departamento) {
		dao.update(departamento);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Departamento findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public List<Departamento> findAll() {
		return dao.findAll();
	}

	@Override
	public boolean departamentoCargos(Long id) {
		if(findById(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}

	
	
}
