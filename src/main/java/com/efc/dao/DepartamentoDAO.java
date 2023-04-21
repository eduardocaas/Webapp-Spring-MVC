package com.efc.dao;

import java.util.List;

import com.efc.domain.Departamento;

public interface DepartamentoDAO {
	
	void save(Departamento departamento);
	void update(Departamento departamento);
	void delete(Long id);
	
	Departamento findById(Long id);
	List<Departamento> findAll();
}
