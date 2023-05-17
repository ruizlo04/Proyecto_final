package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ClienteServicio;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ClienteServicio clienteServicio;

	@GetMapping({ "/", "/list" })
	public String listarTodos(Model model) {
		model.addAttribute("lista", clienteServicio.findAll());
		return "admin";
	}
}
