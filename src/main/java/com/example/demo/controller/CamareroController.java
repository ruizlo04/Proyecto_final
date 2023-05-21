package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Camareros;
import com.example.demo.service.CamareroServicio;

@Controller
@RequestMapping("/camarero")
public class CamareroController {
	
	@Autowired
	private CamareroServicio camareroServicio;
	
	@GetMapping({ "/", "/listCamareros" })
	public String listarTodos(Model model) {
		model.addAttribute("listCamareros", camareroServicio.findAll());	
		return "camarero";
	}
	
	@GetMapping("/nuevoCamarero")
	public String mostrarFormulario(Model model) {
		model.addAttribute("camarero", new Camareros());
		return "camareroForm";
	}
	
	@PostMapping("/nuevoCamarero/submit")
	public String procesarFormulario(@ModelAttribute("camarero") Camareros c) {
		camareroServicio.add(c);
		return "redirect:/admin/camarero/";// Podría ser también return "redirect:/list
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long cod_camarero, Model model) {

		Camareros cEditar = camareroServicio.findById(cod_camarero);

		if (cEditar != null) {
			model.addAttribute("camarero",cEditar);
			return "camarero";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/admin/camarero/";
		}

	}
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("camarero") Camareros c) {
		camareroServicio.edit(c);
		return "redirect:/admin/camarero/";// Volvemos a redirigir la listado a través del controller
		// para pintar la lista actualizada con la modificación hecha
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		camareroServicio.delete(id);
		return "redirect:/admin/camarero/";
	}
	
	@GetMapping("/camarero")
	public String showForm(Model model) {

		Camareros camarero = new Camareros();
		model.addAttribute("camareroForm", camarero);

		return "redirect:/admin/camarero/";

	}
	
	public String submit(@ModelAttribute("camareroForm") Camareros camarero, Model model) {

		model.addAttribute("camarero", camarero);

		return "camarero";
	}

}
