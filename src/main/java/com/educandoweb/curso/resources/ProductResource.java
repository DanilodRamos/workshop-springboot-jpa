package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.services.ProductService;

//anotation
@RestController
//nome pro recurso
@RequestMapping(value = "/products")
public class ProductResource {
	//metodo pra ve se funcionca com end point
	//dependencia para o service
	@Autowired
	private ProductService service;
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {//metodo pra retornar os usuarios
		List<Product> list = service.findAll();
	return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findByID(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
