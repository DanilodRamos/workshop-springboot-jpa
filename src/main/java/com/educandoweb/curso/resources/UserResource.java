package com.educandoweb.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.services.UserService;

//anotation
@RestController
@RequestMapping(value = "/users") // nome pro recurso
public class UserResource {
	// metodo pra ve se funcionca com end point
	// dependencia para o service
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {// metodo pra retornar os usuarios
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findByID(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj); // 2 end point pra recuperar dados no banco
	}

	// pra inserir
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
