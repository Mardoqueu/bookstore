package com.mardoqueu.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mardoqueu.bookstore.domain.Book;
import com.mardoqueu.bookstore.domain.Category;
import com.mardoqueu.bookstore.repositories.BookRepository;
import com.mardoqueu.bookstore.repositories.CategoryRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository bookRepository;
	

	public void databaseInstance() {
		Category cat1 = new Category(null, "Informática", "Livros de TI");
		Category cat2 = new Category(null, "Autoajuda", "Motivacional");
		Category cat3 = new Category(null, "Ficção Científica", "Ficção Científica");
		Category cat4 = new Category(null, "Biografias", "Livros de Biografias");

		
		
		Book b1 = new Book(null, "Clean code", "Robert Martin", "Lorem inpsum", cat1);
		Book b2 = new Book(null, "O poder do hábito", "Charles Duhigg", "Lorem inpsum", cat2);
		Book b3 = new Book(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem inpsum", cat1);
		Book b4 = new Book(null, "The Time Machine", "H.G. Wells", "Lorem inpsum", cat2);
		Book b5 = new Book(null, "The war of the worls", "H.G. Wells", "Lorem inpsum", cat2);
		Book b6 = new Book(null, "I, Robot", "Isaac Asimov", "Lorem inpsum", cat2);
		
		
		cat1.getBooks().addAll(Arrays.asList(b1, b2));
		cat2.getBooks().addAll(Arrays.asList(b3, b4, b5, b6));
		
		this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		this.bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6));
	}
}
