package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Camareros;
import com.example.demo.repository.CamareroRepository;

@Service
public class CamareroServicio {
	
	private CamareroRepository camareroRepository;
	
	public CamareroServicio(CamareroRepository repo) {
		this.camareroRepository = repo;
	}
	
	public Camareros add(Camareros c) { return camareroRepository.save(c); }
	
	public Camareros edit(Camareros c) { return camareroRepository.save(c); }

	public void delete(Camareros c) { camareroRepository.delete(c); }
	
	public void delete(long id) { camareroRepository.deleteById(id); }
	
	public List<Camareros> findAll() { return camareroRepository.findAll(); }
	
	public Camareros findById(long id) {
		return camareroRepository.findById(id).orElse(null);
	}


}
