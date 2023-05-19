package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Menu;
import com.example.demo.service.MenuServicio;

@Controller
@RequestMapping("/admin/menu")
public class MenuController {
	
	@Autowired
	private MenuServicio menuServicio;
	
	@GetMapping("/nuevoMenu")
	public String mostrarFormulario(Model model) {
		model.addAttribute("menu", new Menu());
		return "form";
	}
	
	@PostMapping("/nuevoMenu/submit")
	public String procesarFormulario(@ModelAttribute("menu") Menu m) {
		menuServicio.add(m);
		return "redirect:/admin/menu/";// Podría ser también return "redirect:/list
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long cod_menu, Model model) {

		Menu mEditar = menuServicio.findById(cod_menu);

		if (mEditar != null) {
			model.addAttribute("menu", mEditar);
			return "form";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/admin/menu/";
		}

	}
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("menu") Menu m) {
		menuServicio.edit(m);
		return "redirect:/admin/menu/";// Volvemos a redirigir la listado a través del controller
		// para pintar la lista actualizada con la modificación hecha
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		menuServicio.delete(id);
		return "redirect:/admin/menu/";
	}
	
	@GetMapping("/menu")
	public String showForm(Model model) {

		Menu menu = new Menu();
		model.addAttribute("clienteForm", menu);

		return "redirect:/admin/menu/";

	}
	
	public String submit(@ModelAttribute("menuForm") Menu menu, Model model) {

		model.addAttribute("menu", menu);

		return "view";
	}
}
