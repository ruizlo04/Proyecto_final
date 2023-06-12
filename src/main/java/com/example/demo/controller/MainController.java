package com.example.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.MenuServicio;
import com.example.demo.service.ReservaServicio;
import com.example.demo.service.UsuarioServicio;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.model.Reserva;
import com.example.demo.model.Usuario;

@Controller
@RequestMapping("/user")
public class MainController {
	
	@Autowired
	private ReservaServicio reservaServicio;
	
	@Autowired
	private MenuServicio menuServicio;
	
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
//		model.addAttribute("menus",menuServicio.findAll());
//		model.addAttribute("reserva", new Reserva());

		return "nuevaReserva";
	}
	
	@PostMapping("/nuevaReserva/submit")
	public String procesarFormularioUser(@ModelAttribute("reserva") Reserva r) {
		reservaServicio.add(r);
		return "redirect:/reserva"; 
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long cod_reserva, Model model) {

		Reserva rEditar = reservaServicio.findById(cod_reserva);

		if (rEditar != null) {
			model.addAttribute("reserva", rEditar);
			return "registro";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/reserva";
		}

	}
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("reserva") Reserva r) {
		reservaServicio.edit(r);
		return "redirect:/reserva";// Volvemos a redirigir la listado a través del controller
		// para pintar la lista actualizada con la modificación hecha
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