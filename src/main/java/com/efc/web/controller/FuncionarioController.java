package com.efc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efc.domain.Cargo;
import com.efc.domain.Funcionario;
import com.efc.domain.UF;
import com.efc.service.CargoService;
import com.efc.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.findAll());
		return "/funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.save(funcionario);
		attr.addFlashAttribute("success", "Funcionário inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> listaCargos(){
		return cargoService.findAll();
	}
	
	@ModelAttribute("ufs")
	public UF[] listaUFS(){
		return UF.values();
	}
	
}
