package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ReservaServicio;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.model.Reserva;

@Controller
@RequestMapping("/user")
public class MainController {
	
	@Autowired
	private ReservaServicio reservaServicio;
	
	@GetMapping("/bodas")
	public String mostrarBodas() {
		return "bodas";
	}
	
	@GetMapping("/eventos")
	public String mostrarEventos() {
		return "eventos";
	}

	@GetMapping("/registroUser")
	public String mostrarRegistro() {
		return "registroUser";
	}
	
	@GetMapping("/nuevoUser")
	public String mostrarFormularioUser(Model model) {
		model.addAttribute("reserva", new Reserva());
		return "registroUser";
	}
	
	@PostMapping("/nuevoUser/submit")
	public String procesarFormularioUser(@ModelAttribute("reserva") Reserva r) {
		reservaServicio.add(r);
		return "redirect:/index/"; 
	}
	
}
