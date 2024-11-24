package com.femcoders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import com.femcoders.model.Book;
import com.femcoders.model.BookDAO;
import com.femcoders.model.BookDAOInterface;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookDAOTest {

    BookDAOInterface bookDAO;

    @BeforeAll
    void setup(){
        bookDAO = new BookDAO();
    }

    @Test
    @Order(1)
    void testCreateBookShouldReturnBook(){
        //Arrange
        Book book = new Book(); 
        book.setTitle("El universo en una cascara de nuez");
        book.setAuthor("Stephen Hawking");
        book.setIsbn(9788498929379L);
        //Act
        bookDAO.addBook(book);

        //Assert
        assertEquals("Stephen Hawking", bookDAO.getBookById(book.getId()).getAuthor());;
    }
}
