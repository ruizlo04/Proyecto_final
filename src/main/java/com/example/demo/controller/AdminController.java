package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UsuarioServicio;
import com.example.demo.model.Reserva;
import com.example.demo.model.Usuario;
import com.example.demo.service.MenuServicio;
import com.example.demo.service.ReservaServicio;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private MenuServicio menuServicio;
	
	@Autowired
	private ReservaServicio reservaServicio;

	@GetMapping("/usuarios")
	public String Usuarios(Model model) {
	    model.addAttribute("usuarioList", usuarioServicio.findAll());    
	    return "admin";
	}

	@GetMapping("/reservas")
	public String Reservas(Model model) {
	    model.addAttribute("lista", reservaServicio.findAll());    
	    return "reserva";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuarioAdmin";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("usuario") Usuario u) {
		System.out.println(u.getPassword());
		String passEncripted = new BCryptPasswordEncoder().encode(u.getPassword());
		System.out.println(passEncripted);
		u.setPassword(passEncripted);
		usuarioServicio.add(u);
		return "redirect:/admin/usuarios";
	}
	

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		Usuario uEditar = usuarioServicio.findById(id);

		if (uEditar != null) {
			model.addAttribute("usuario", uEditar);
			return "usuarioAdmin";
		} else {
			
			return "redirect:/admin/usuarios";
		}

	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario") Usuario u) {
		usuarioServicio.edit(u);
		return "redirect:/admin/usuarios";
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		usuarioServicio.delete(id);
		return "redirect:/admin/usuarios";
	}
	

	@GetMapping("/nueva")
	public String mostrarFormRes(Model model) {
		model.addAttribute("menus", menuServicio.findAll());
		model.addAttribute("reserva", new Reserva());

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();

		Usuario currentUser = usuarioServicio.findByUsername(currentUserName);
		List<Reserva> listaReservas = new ArrayList<>();
		listaReservas = reservaServicio.findByNombre(currentUser.getId());

		System.out.println(listaReservas.size());
		model.addAttribute("lista", listaReservas);
		return "reservaAdmin";
	}
	
	@PostMapping("/nueva/submit")
	public String procesarFormRes(@ModelAttribute("reserva") Reserva r, @ModelAttribute("usuario") Usuario u) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		Usuario currentUser = usuarioServicio.findByUsername(currentUserName);

		r.setUsuario(currentUser);
		reservaServicio.guardarReservaConUsuario(r);
		return "redirect:/admin/reservas";
	}
	
	@GetMapping("/editarReserva/{id}")
	public String mostrarFormularioEdicionReserva(@PathVariable("id") long cod_reserva, Model model) {

		Reserva rEditar = reservaServicio.findById(cod_reserva);

		if (rEditar != null) {
			model.addAttribute("reserva", rEditar);
			return "reservaAdmin";
		} else {
			return "redirect:/admin/reservas";
		}

	}

	@PostMapping("/editarReserva/submit")
	public String procesarFormularioEdicion(@ModelAttribute("reserva") Reserva r) {
		reservaServicio.edit(r);
		return "redirect:/admin/reservas";
	}
	
	@GetMapping("/borrarReserva/{id}")
	public String borrarR(@PathVariable("id") long id) {
		reservaServicio.delete(id);
		return "redirect:/admin/reservas";
	}

}