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

	@GetMapping({ "/", "/list" })
	public String listarTodos(Model model) {
		model.addAttribute("lista", reservaServicio.findAll());
		return "reserva";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long cod_reserva, Model model) {
		model.addAttribute("menus", menuServicio.findAll());
		Reserva rEditar = reservaServicio.findById(cod_reserva);

		if (rEditar != null) {
			model.addAttribute("reserva", rEditar);
			return "nuevaReserva";
		} else {
			return "redirect:/index/";
		}

	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("reserva") Reserva r) {
		reservaServicio.edit(r);
		return "redirect:/index/";
	}

	/** 
	 * Este método se encarga de realizar una nueva reserva comprobando el usuario que esté realizando esa reserva
	 * @param model
	 * @return devuelve la página para realizar la reserva
	 */
	@GetMapping("/nuevaReserva")
	public String mostrarFormularioUser(Model model) {
		model.addAttribute("menus", menuServicio.findAll());
		model.addAttribute("reserva", new Reserva());

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();

		Usuario currentUser = usuarioServicio.findByUsername(currentUserName);
		List<Reserva> listaReservas = new ArrayList<>();
		listaReservas = reservaServicio.findByNombre(currentUser.getId());

		System.out.println(listaReservas.size());
		model.addAttribute("lista", listaReservas);
		return "nuevaReserva";
	}
	
	/**
	 * Este método sirve para enviar el formulario de reserva comprobando la autenticación del usuario
	 * que esté realizando la reserva.
	 * @param r Se le pasa una reserva para guardar.
	 * @param u Se le pasa un usuario para realizar la reserva.
	 * @return devulve la reserva realizada y te devuelve al índice.
	 */

	@PostMapping("/nuevaReserva/submit")
	public String procesarFormularioUser(@ModelAttribute("reserva") Reserva r, @ModelAttribute("usuario") Usuario u) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		Usuario currentUser = usuarioServicio.findByUsername(currentUserName);

		r.setUsuario(currentUser);
		reservaServicio.guardarReservaConUsuario(r);
		return "redirect:/index/";
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		reservaServicio.delete(id);
		return "redirect:/index/";
	}

//	@GetMapping("/cliente")
//	public String showForm(Model model) {
//
//		Usuario usuario = new Usuario();
//		model.addAttribute("usuarioForm", usuario);
//
//		return "redirect:/registro/";
//
//	}

	public String submit(@ModelAttribute("reservaForm") Reserva reserva, Model model) {

		model.addAttribute("reserva", reserva);

		return "view";
	}

}