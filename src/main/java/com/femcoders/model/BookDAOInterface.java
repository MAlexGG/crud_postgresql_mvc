package com.femcoders.model;

import java.util.List;

public interface BookDAOInterface {
    List<Book> getBooks();
    void addBook(Book book);
    Book getBookById(int id);
    void updateBook(Book book);
    void deleteBook(int id);
}
