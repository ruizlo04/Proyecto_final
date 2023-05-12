package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteServicio;

@Controller
public class ClienteController {

	@Autowired
	private ClienteServicio clienteServicio;

	public ClienteController(ClienteServicio servicio) {
		this.clienteServicio = servicio;
	}

	@GetMapping({ "/", "/list" })
	public String listarTodos(Model model) {
		model.addAttribute("lista", clienteServicio.findAll());
		return "index";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "formulario";
	}

	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("cliente") Cliente c) {
		clienteServicio.add(c);
		return "redirect:/";// Podría ser también return "redirect:/list
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long cod_cliente, Model model) {

		Cliente cEditar = clienteServicio.findById(cod_cliente);

		if (cEditar != null) {
			model.addAttribute("cliente", cEditar);
			return "formulario";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/";
		}

	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("cliente") Cliente c) {
		clienteServicio.edit(c);
		return "redirect:/";// Volvemos a redirigir la listado a través del controller
		// para pintar la lista actualizada con la modificación hecha
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		clienteServicio.delete(id);
		return "redirect:/";
	}

	@GetMapping("/cliente")
	public String showForm(Model model) {

		Cliente cliente = new Cliente();
		model.addAttribute("clienteForm", cliente);

		return "redirect:/";

	}

	public String submit(@ModelAttribute("clienteForm") Cliente cliente, Model model) {

		model.addAttribute("cliente", cliente);

		return "view";
	}
}