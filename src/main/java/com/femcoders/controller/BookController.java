package com.femcoders.controller;

import java.util.List;

import com.femcoders.model.Book;
import com.femcoders.model.BookDAO;

public class BookController {

    private BookDAO bookDAO;

    public BookController(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    public List<Book> getBooks(){
        List<Book> books = bookDAO.getBooks();
        return books;
    } 

    public void addBook(Book book){
        bookDAO.addBook(book);
        System.out.println("\033[0;32m" + "\n¡Libro " + book.getTitle() + " creado con éxito!" + "\033[0m");
    }

    
}
