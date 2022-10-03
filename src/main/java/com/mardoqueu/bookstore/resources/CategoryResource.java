package com.mardoqueu.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mardoqueu.bookstore.domain.Category;
import com.mardoqueu.bookstore.dtos.CategoryDTO;
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
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<Category> list = service.findAll();
		List<CategoryDTO> listDto = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());		
		
		return ResponseEntity.ok().body(listDto);		
	}
	
	@PostMapping
	public ResponseEntity<Category> create(@RequestBody Category obj)
	{
		obj = service.create(obj);	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}	
	
}
