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

	@GetMapping({ "/", "/list" })
	public String Menus(Model model) {
		model.addAttribute("menuList", menuServicio.findAll());	
		return "admin";
	}
	
	@GetMapping({ "/", "/listUsu" })
	public String Usuarios(Model model) {
		model.addAttribute("usuarioList", usuarioServicio.findAll());	
		return "admin";
	}
	
	@GetMapping({ "/", "/listRes" })
	public String Reservas(Model model) {
		model.addAttribute("reservaList", reservaServicio.findAll());	
		return "admin";
	}
	
	
}