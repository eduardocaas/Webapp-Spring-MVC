package com.efc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/") //Raiz do projeto redireciona a /home -> home.html
	public String home() {
		return "/home";
	}
	
}
