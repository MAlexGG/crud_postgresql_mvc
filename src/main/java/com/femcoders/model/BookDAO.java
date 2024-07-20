package com.femcoders.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {

    private PreparedStatement stmn;
    private Connection connection = null;

    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books ORDER BY id";

        try {
            connection = DBManager.initConnection();

            stmn = connection.prepareStatement(sql);
            ResultSet result = stmn.executeQuery();

            while (result.next()) {
                Book book = new Book();
                book.setId(result.getInt("id"));
                book.setTitle(result.getString("title"));
                book.setAuthor(result.getString("author"));
                book.setIsbn(result.getLong("isbn"));
                books.add(book);
            }

        } catch (Exception e) {
            System.out.println("\033[0;31m" + "Conexión fallida" + "\033[0m");
            System.out.println(e.getMessage());
        } finally {
            DBManager.closeConnection();
        }
        return books;
    }

    public void addBook(Book book){
        try {
            connection = DBManager.initConnection();

            String sql = "INSERT INTO books (id, title, author, isbn) VALUES (?,?,?,?)";
            stmn = connection.prepareStatement(sql);
            stmn.setInt(1, book.getId());
            stmn.setString(2, book.getTitle());
            stmn.setString(3, book.getAuthor());
            stmn.setLong(4, book.getIsbn());

            stmn.executeUpdate();
            System.out.println("\033[0;32m" + "\n¡Libro creado con éxito!" + "\033[0m");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "Conexión fallida" + "\033[0m");
            System.out.println(e.getMessage());
        } finally {
            DBManager.closeConnection();
        }
    }
    
}
