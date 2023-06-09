package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioServicio;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServicio usuarioServicio;

	public UsuarioController(UsuarioServicio servicio) {
		super();
		this.usuarioServicio = servicio;
	}
	
	@GetMapping({ "/", "/list" })
	public String listarTodos(Model model) {
		model.addAttribute("lista", usuarioServicio.findAll());
		return "admin";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formulario";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("usuario") Usuario u) {
		System.out.println(u.getPassword());
		String passEncripted = new BCryptPasswordEncoder().encode(u.getPassword());
		System.out.println(passEncripted);
		u.setPassword(passEncripted);
		usuarioServicio.add(u);
		return "redirect:/index/";// Podría ser también return "redirect:/list
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		Usuario uEditar = usuarioServicio.findById(id);

		if (uEditar != null) {
			model.addAttribute("usuario", uEditar);
			return "formulario";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/admin/";
		}

	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario") Usuario u) {
		usuarioServicio.edit(u);
		return "redirect:/index/";// Volvemos a redirigir la listado a través del controller
		// para pintar la lista actualizada con la modificación hecha
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		usuarioServicio.delete(id);
		return "redirect:/admin/";
	}

	@GetMapping("/usuario")
	public String showForm(Model model) {

		Usuario usuario = new Usuario();
		model.addAttribute("usuarioForm", usuario);

		return "redirect:/index/";

	}
	
	@GetMapping("/hazteUsuario")
	public String hazteUser(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "hazteUsuario";
	}
	
	@PostMapping("/hazteUsuario/submit")
	public String procesarHacerteUser(@ModelAttribute("usuario") Usuario u) {
		usuarioServicio.add(u);
		return "redirect:/index/"; 
	}

	@PostMapping("/submit")
	public String submit(@ModelAttribute("usuarioForm") Usuario usuario, Model model) {
	    model.addAttribute("usuario", usuario);
	    return "view";
	}

}