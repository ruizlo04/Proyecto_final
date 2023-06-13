package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UsuarioServicio;
import com.example.demo.model.Usuario;
import com.example.demo.service.MenuServicio;
import com.example.demo.service.ReservaServicio;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private MenuServicio menuServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private ReservaServicio reservaServicio;

	@GetMapping("/menus")
	public String Menus(Model model) {
	    model.addAttribute("menuList", menuServicio.findAll());    
	    return "admin";
	}

	@GetMapping("/usuarios")
	public String Usuarios(Model model) {
	    model.addAttribute("usuarioList", usuarioServicio.findAll());    
	    return "admin";
	}

	@GetMapping("/reservas")
	public String Reservas(Model model) {
	    model.addAttribute("reservaList", reservaServicio.findAll());    
	    return "admin";
	}
	

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		Usuario uEditar = usuarioServicio.findById(id);

		if (uEditar != null) {
			model.addAttribute("usuario", uEditar);
			return "hazteUsuario";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/admin/";
		}

	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario") Usuario u) {
		usuarioServicio.edit(u);
		return "redirect:/admin/";// Volvemos a redirigir la listado a través del controller
		// para pintar la lista actualizada con la modificación hecha
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		usuarioServicio.delete(id);
		return "redirect:/admin/";
	}
}