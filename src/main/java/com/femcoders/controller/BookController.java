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
    }

    public Book getBookById(int id){
        Book book = bookDAO.getBookById(id);
        return book;
    }

    public void updateBook(Book book){
        bookDAO.updateBook(book);
    }

    
}
