package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.repositories.CategoryRepository;

//registrando com anotation
@Service
public class CategoryService {
	// operaçao pra buscar todos usuarios e id
	// injeçaõ de dependencia
	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();

	}
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
