package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/bodas")
	public String mostrarBodas() {
		return "bodas";
	}
	
	@GetMapping("/eventos")
	public String mostrarEventos() {
		return "eventos";
	}

	
}
