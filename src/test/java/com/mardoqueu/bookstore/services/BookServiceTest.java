package com.mardoqueu.bookstore.services;

import com.mardoqueu.bookstore.domain.Book;
import com.mardoqueu.bookstore.dtos.BookDTO;
import com.mardoqueu.bookstore.repositories.BookRepository;
import com.mardoqueu.bookstore.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {

    public static final Integer ID = 1;
    public static final String TITLE = "Clean code";
    public static final String AUTHOR = "Robert Martin";
    public static final String TEXT = "Lorem inpsum";
    public static final int INDEX = 0;
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
    void whenFindByIdThenReturnObjectNotFoundException(){
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado!"));

        try{
            bookService.findById(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto não encontrado!", ex.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnAListOfBooks() {
        when(repository.findAll()).thenReturn(List.of(book));

        List<Book> response = bookService.findAll();

        assertNotNull(response);
        assertEquals(ID, response.size());
        assertEquals(Book.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(TITLE, response.get(INDEX).getTitle());
        assertEquals(AUTHOR, response.get(INDEX).getName_author());
        assertEquals(TEXT, response.get(INDEX).getText());
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