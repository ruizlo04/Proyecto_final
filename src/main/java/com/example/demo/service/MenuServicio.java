package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Menu;
import com.example.demo.repository.MenuRepository;

@Service
public class MenuServicio {
	
	private MenuRepository menuRepository;
	
	public MenuServicio(MenuRepository repo) {
		this.menuRepository = repo;
	}

	public Menu add(Menu m) { return menuRepository.save(m); }
	
	public Menu edit(Menu m) { return menuRepository.save(m); }
	
	public void delete(Menu m) { menuRepository.delete(m); }
	
	public void delete(long id) { menuRepository.deleteById(id); }
	
	public List<Menu> findAll() { return menuRepository.findAll(); }
	
	public Menu findById(long id) {
		return menuRepository.findById(id).orElse(null);
	}

}
