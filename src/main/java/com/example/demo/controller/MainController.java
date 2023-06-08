package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ReservaServicio;
import com.example.demo.service.UsuarioServicio;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.model.Reserva;
import com.example.demo.model.Usuario;

@Controller
@RequestMapping("/user")
public class MainController {
	
	@Autowired
	private ReservaServicio reservaServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
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
	
	@GetMapping("/nuevaReserva")
	public String mostrarFormularioUser(Model model) {
		model.addAttribute("reserva", new Reserva());
		return "nuevaReserva";
	}
	
	@PostMapping("/nuevaReserva/submit")
	public String procesarFormularioUser(@ModelAttribute("reserva") Reserva r) {
		reservaServicio.add(r);
		return "redirect:/index/"; 
	}
	
//	@GetMapping("/hazteUsuario")
//	public String hazteUser(Model model) {
//		model.addAttribute("usuario", new Usuario());
//		return "hazteUsuario";
//	}
//	
//	@PostMapping("/hazteUsuario/submit")
//	public String procesarHacerteUser(@ModelAttribute("usuario") Usuario u) {
//		usuarioServicio.add(u);
//		return "redirect:/index/"; 
//	}
	
}