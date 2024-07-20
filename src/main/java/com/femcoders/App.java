package com.femcoders;

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

        //PARA COMPROBAR addBook
        /* 
        BookDAO model = new BookDAO();

        Book book = new Book();
        book.setId(1);
        book.setTitle("title");
        book.setAuthor("author");
        book.setIsbn(9876543456545L);

        model.addBook(book); 
        */

        
        //PARA COMPROBAR getBooks
        /* 
        BookDAO model = new BookDAO();
        List<Book> books = model.getBooks();

        for (Book book : books) {
            System.out.print("\n" + book.getId() + " - " + book.getTitle() + " - " + book.getAuthor() + " - " + book.getIsbn());
        } 
        */


    }
}
