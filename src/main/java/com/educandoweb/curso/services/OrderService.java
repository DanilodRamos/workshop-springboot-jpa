package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.repositories.OrderRepository;

//registrando com anotation
@Service
public class OrderService {
	// operaçao pra buscar todos usuarios e id
	// injeçaõ de dependencia
	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();

	}
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
