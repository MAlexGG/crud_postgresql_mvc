package com.femcoders;

/* import java.util.List;

import com.femcoders.controller.BookController;
import com.femcoders.model.Book;
import com.femcoders.model.BookDAO; */

//import com.femcoders.model.DBManager;

/* import com.femcoders.model.Book;
import com.femcoders.model.BookDAO; */


public class App 
{
    public static void main( String[] args )
    {
        //PARA COMPROBAR CONEXIÓN BD
        /* 
        DBManager.initConnection();
        DBManager.closeConnection(); 
        */

        //PARA COMPROBAR addBook del DAO
        /* 
        BookDAO model = new BookDAO();

        Book book = new Book();
        book.setId(1);
        book.setTitle("title");
        book.setAuthor("author");
        book.setIsbn(9876543456545L);

        model.addBook(book); 
        */

        
        //PARA COMPROBAR getBooks del DAO
        /* 
        BookDAO model = new BookDAO();
        List<Book> books = model.getBooks();

        for (Book book : books) {
            System.out.print("\n" + book.getId() + " - " + book.getTitle() + " - " + book.getAuthor() + " - " + book.getIsbn());
        } 
        */

        //PARA COMPROBAR getBooks del controller
        /* 
        BookDAO bookDAO = new BookDAO();
        BookController bookController = new BookController(bookDAO);

        List<Book> books = bookController.getBooks();
        for (Book book : books) {
            System.out.println(book.getId());
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.getIsbn());
        }
        */
        


    }
}
