package com.mardoqueu.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mardoqueu.bookstore.domain.Book;
import com.mardoqueu.bookstore.domain.Category;
import com.mardoqueu.bookstore.dtos.BookDTO;
import com.mardoqueu.bookstore.repositories.BookRepository;
import com.mardoqueu.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public Book findById(Integer id) {
		Optional<Book> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado! " + id + ", Tipo: " + Book.class.getName()));
	}
	
	public List<Book> findAll(){
		return repository.findAll();
	}

	public Book create(Book obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Book update(Integer id, BookDTO objDto) {
		Book obj = findById(id);		
		obj.setTitle(objDto.getTitle());
		obj.setName_author(objDto.getName_author());
		obj.setText(objDto.getText());
		return repository.save(obj);

	}


}
