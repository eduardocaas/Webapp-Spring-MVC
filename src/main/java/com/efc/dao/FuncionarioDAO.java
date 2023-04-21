package com.efc.dao;

import java.util.List;

import com.efc.domain.Funcionario;


public interface FuncionarioDAO {

	void save(Funcionario cargo);
	void update(Funcionario cargo);
	void delete(Long id);
	
	Funcionario findById(Long id);
	List<Funcionario> findAll();
	
}
