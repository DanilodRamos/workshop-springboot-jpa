package com.educandoweb.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.User;

//anotation
@RestController
//nome pro recurso
@RequestMapping(value = "/users")
public class UserResource {
	//metodo pra ve se funcionca com end point
	@GetMapping
	public ResponseEntity<User> findAll(){//metodo pra retornar os usuarios
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
	return ResponseEntity.ok().body(u);
	}
}
