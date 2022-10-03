package com.mardoqueu.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mardoqueu.bookstore.domain.Category;
import com.mardoqueu.bookstore.repositories.CategoryRepository;
import com.mardoqueu.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! " + id + ", Tipo: " + Category.class.getName()));
	}
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category create(Category obj) {
		obj.setId(null);
		return repository.save(obj);
	}
}
