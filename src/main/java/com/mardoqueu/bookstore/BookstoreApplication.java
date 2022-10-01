package com.mardoqueu.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mardoqueu.bookstore.domain.Book;
import com.mardoqueu.bookstore.domain.Category;
import com.mardoqueu.bookstore.repositories.BookRepository;
import com.mardoqueu.bookstore.repositories.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository bookRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática", "Livros de TI");
		
		Book b1 = new Book(null, "Clean code", "Robert Martin", "Lorem inpsum", cat1);
				
		cat1.getBooks().addAll(Arrays.asList(b1));
		
		this.categoryRepository.saveAll(Arrays.asList(cat1));
		this.bookRepository.saveAll(Arrays.asList(b1));
		
	}

}
