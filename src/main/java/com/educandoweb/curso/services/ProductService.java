package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.repositories.ProductRepository;

//registrando com anotation
@Service
public class ProductService {
	// operaçao pra buscar todos usuarios e id
	// injeçaõ de dependencia
	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();

	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
