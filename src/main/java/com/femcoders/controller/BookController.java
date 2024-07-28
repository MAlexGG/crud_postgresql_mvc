package com.femcoders.controller;

import java.util.List;

import com.femcoders.model.Book;
import com.femcoders.model.BookDAOInterface;

public class BookController {

    private BookDAOInterface bookDAOInterface;

    public BookController(BookDAOInterface bookDAOInterface){
        this.bookDAOInterface = bookDAOInterface;
    }

    public List<Book> getBooks(){
        List<Book> books = bookDAOInterface.getBooks();
        return books;
    } 

    public void addBook(Book book){
        bookDAOInterface.addBook(book);
    }

    public Book getBookById(int id){
        Book book = bookDAOInterface.getBookById(id);
        return book;
    }

    public void updateBook(Book book){
        bookDAOInterface.updateBook(book);
    }

    public void deleteBook(int id){
        bookDAOInterface.deleteBook(id);
    }
    
}
