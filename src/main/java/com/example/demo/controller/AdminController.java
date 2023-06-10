package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UsuarioServicio;
import com.example.demo.model.Usuario;
import com.example.demo.service.MenuServicio;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private MenuServicio menuServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;

	@GetMapping({ "/", "/list" })
	public String listarTodos(Model model) {
		model.addAttribute("menuList", menuServicio.findAll());	
		return "admin";
	}
	
	@GetMapping("/hazteUsuario")
	public String hazteUser(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "hazteUsuario";
	}
	
	@PostMapping("/hazteUsuario/submit")
	public String procesarHacerteUser(@ModelAttribute("usuario") Usuario u) {
		usuarioServicio.add(u);
		return "redirect:/admin/"; 
	}
	
	
}