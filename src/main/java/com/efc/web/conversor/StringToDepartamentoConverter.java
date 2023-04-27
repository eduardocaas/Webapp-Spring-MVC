package com.efc.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.efc.domain.Departamento;
import com.efc.service.DepartamentoService;

// Classe para tratar erro -> em cadastro.html de cargo, em departamentos é passado o id e o controller espera um departamento

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento>{

	@Autowired
	private DepartamentoService service;
	
	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.findById(id);
	} 

}
