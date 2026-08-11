package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.services.OrderService;

//anotation
@RestController
//nome pro recurso
@RequestMapping(value = "/Orders")
public class OrderResource {
	//metodo pra ve se funcionca com end point
	//dependencia para o service
	@Autowired
	private OrderService service;
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {//metodo pra retornar os usuarios
		List<Order> list = service.findAll();
	return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findByID(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
