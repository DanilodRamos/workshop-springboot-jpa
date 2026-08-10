package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.UserRepository;

//registrando com anotation
@Service
public class UserService {
	// operaçao pra buscar todos usuarios e id
	// injeçaõ de dependencia
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();

	}
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
