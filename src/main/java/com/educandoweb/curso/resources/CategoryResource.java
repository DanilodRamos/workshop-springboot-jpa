package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.services.CategoryService;

//anotation
@RestController
//nome pro recurso
@RequestMapping(value = "/categories")
public class CategoryResource {
	//metodo pra ve se funcionca com end point
	//dependencia para o service
	@Autowired
	private CategoryService service;
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {//metodo pra retornar os usuarios
		List<Category> list = service.findAll();
	return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findByID(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
