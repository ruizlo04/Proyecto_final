package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Usuario;
import com.example.demo.model.Reserva;
import com.example.demo.service.MenuServicio;
import com.example.demo.service.ReservaServicio;
import com.example.demo.service.UsuarioServicio;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
	
	@Autowired
	private ReservaServicio reservaServicio;
	
	@Autowired
	private MenuServicio menuServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;

	public ReservaController(ReservaServicio reservaServicio) {
		super();
		this.reservaServicio = reservaServicio;
	}
	
	@GetMapping({ "/", "/list" })
	public String listarTodos(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName  = authentication.getName();
		System.out.println(currentUserName);
		
		Usuario currentUser = usuarioServicio.findByUsername(currentUserName );
		List<Reserva> listaReservas = new ArrayList<>();
		listaReservas = reservaServicio.findByNombre(currentUser.getId());
//				.map(List::of).orElseGet(Collections::emptyList);

		System.out.println(listaReservas.size());
		model.addAttribute("lista", listaReservas);
		return "reserva";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("reserva", new Reserva());
		return "registro";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("reserva") Reserva r) {
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
		return "redirect:/reserva/";// Volvemos a redirigir la listado a través del controller
		// para pintar la lista actualizada con la modificación hecha
	}
	
	@GetMapping("/nuevaReserva")
	public String mostrarFormularioUser(Model model) {
		model.addAttribute("menus",menuServicio.findAll());
//		model.addAttribute("usuario", usuarioServicio.findAll());
		model.addAttribute("reserva", new Reserva());
		
//		System.out.println("por aqui");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName  = authentication.getName();
//		System.out.println(currentUserName);
		
		Usuario currentUser = usuarioServicio.findByUsername(currentUserName );
		List<Reserva> listaReservas = new ArrayList<>();
		listaReservas = reservaServicio.findByNombre(currentUser.getId());
//				.map(List::of).orElseGet(Collections::emptyList);

		System.out.println(listaReservas.size());
		model.addAttribute("lista", listaReservas);
		return "nuevaReserva";
	}
	
	@PostMapping("/nuevaReserva/submit")
	public String procesarFormularioUser(@ModelAttribute("reserva") Reserva r, @ModelAttribute("usuario") Usuario u) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName  = authentication.getName();
		Usuario currentUser = usuarioServicio.findByUsername(currentUserName );
		
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
	    r.setUsuario(currentUser);
	    reservaServicio.guardarReservaConUsuario(r);
	    return "redirect:/index/"; 
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		reservaServicio.delete(id);
		return "redirect:/reserva/";
	}

	@GetMapping("/cliente")
	public String showForm(Model model) {

		Usuario usuario = new Usuario();
		model.addAttribute("usuarioForm", usuario);

		return "redirect:/registro/";

	}

	public String submit(@ModelAttribute("reservaForm") Reserva reserva, Model model) {

		model.addAttribute("reserva", reserva);

		return "view";
	}
	

}