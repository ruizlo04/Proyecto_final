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
@RequestMapping("/view")
public class MenuController {
	
	@Autowired
	private MenuServicio menuServicio;
	
	@GetMapping({ "/", "/listMenu" })
	public String listarTodos(Model model) {
		model.addAttribute("menuList", menuServicio.findAll());	
		return "view";
	}
	
	@GetMapping("/nuevoMenu")
	public String mostrarFormulario(Model model) {
		model.addAttribute("menu", new Menu());
		return "form";
	}
	
	@PostMapping("/nuevoMenu/submitMenu")
	public String procesarFormulario(@ModelAttribute("menu") Menu m) {
		menuServicio.add(m);
		return "redirect:/view/";// Podría ser también return "redirect:/list
	}
	
	@GetMapping("/editarMenu/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long cod_menu, Model model) {

		Menu mEditar = menuServicio.findById(cod_menu);

		if (mEditar != null) {
			model.addAttribute("menu", mEditar);
			return "form";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/view/";
		}

	}
	
	@PostMapping("/editarMenu/submitMenu")
	public String procesarFormularioEdicion(@ModelAttribute("menu") Menu m) {
		menuServicio.edit(m);
		return "redirect:/view/";// Volvemos a redirigir la listado a través del controller
		// para pintar la lista actualizada con la modificación hecha
	}
	
	@GetMapping("/borrarMenu/{id}")
	public String borrar(@PathVariable("id") long id) {
		menuServicio.delete(id);
		return "redirect:/view/";
	}
	
	@GetMapping("/menu")
	public String showForm(Model model) {

		Menu menu = new Menu();
		model.addAttribute("menuForm", menu);

		return "redirect:/view/";

	}
	
	public String submitMenu(@ModelAttribute("menuForm") Menu menu, Model model) {

		model.addAttribute("menu", menu);

		return "view";
	}
}
