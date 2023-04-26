package com.efc.service;

import java.util.List;

import com.efc.domain.Departamento;

public interface DepartamentoService {

	
	void save(Departamento departamento);
	void update(Departamento departamento);
	void delete(Long id);
	
	Departamento findById(Long id);
	List<Departamento> findAll();
	
	boolean departamentoCargos(Long id);
}
