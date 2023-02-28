package com.mardoqueu.bookstore.services;

import com.mardoqueu.bookstore.domain.Book;
import com.mardoqueu.bookstore.dtos.BookDTO;
import com.mardoqueu.bookstore.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {

    public static final Integer ID = 1;
    public static final String TITLE = "Clean code";
    public static final String AUTHOR = "Robert Martin";
    public static final String TEXT = "Lorem inpsum";
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository repository;


    private Book book;
    private BookDTO bookDTO;
    private Optional<Book> optionalBook;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startBook();
    }

    @Test
    void whenFindByIdThenReturnABookInstance() {
        // Arrange
        when(repository.findById(ID)).thenReturn(Optional.of(book));

        // Act
        Book response = bookService.findById(ID);

        // Assert
        assertNotNull(response);
        assertEquals(book, response);
        assertEquals(Book.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(TITLE, response.getTitle());
        assertEquals(AUTHOR, response.getName_author());
        assertEquals(TEXT, response.getText());

    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startBook(){
        book = new Book(ID, TITLE, AUTHOR, TEXT);
        bookDTO = new BookDTO(ID, TITLE, AUTHOR, TEXT);
        optionalBook = Optional.of(new Book(ID, TITLE, AUTHOR, TEXT));

        book.setId(ID);
        book.setTitle(TITLE);
        book.setName_author(AUTHOR);
        book.setText(TEXT);

    }
}