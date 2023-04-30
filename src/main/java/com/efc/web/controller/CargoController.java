package com.efc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efc.domain.Cargo;
import com.efc.domain.Departamento;
import com.efc.service.CargoService;
import com.efc.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.findAll());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes attr) {
		cargoService.save(cargo);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) { // Traz os campos pra editar
		model.addAttribute("cargo", cargoService.findById(id));
		return "cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cargo cargo, RedirectAttributes attr) {
		cargoService.update(cargo);
		attr.addFlashAttribute("success", "Cargo atualizado com sucesso.");
		return "redirect:/cargos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if(cargoService.cargoFuncionarios(id)) {
			attr.addFlashAttribute("fail", "Cargo não removido. Tem funcionário(s) vinculado(s).");
		}
		else {
			cargoService.delete(id);
			attr.addFlashAttribute("success", "Cargo removido com sucesso.");
		}
		return "redirect:/cargos/listar";
	}
	
	
	@ModelAttribute("departamentos") // Injeta os departamentos no model departamentos -> pode ser visto em cadastro.html (Cargo)
	public List<Departamento> listaDepartamentos(){
		return departamentoService.findAll();
	}
	
	
	
	
	
}
