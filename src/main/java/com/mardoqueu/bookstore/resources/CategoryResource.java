package com.mardoqueu.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mardoqueu.bookstore.domain.Category;
import com.mardoqueu.bookstore.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
