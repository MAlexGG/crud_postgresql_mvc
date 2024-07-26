package com.femcoders.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.femcoders.config.DBManager;


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

            String sql = "INSERT INTO books (title, author, isbn) VALUES (?,?,?)";
            stmn = connection.prepareStatement(sql);
            stmn.setString(1, book.getTitle());
            stmn.setString(2, book.getAuthor());
            stmn.setLong(3, book.getIsbn());
            stmn.executeUpdate();
            System.out.println("\033[0;32m" + "\n¡Libro " + book.getTitle() + " creado con éxito!" + "\033[0m");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "No se ha creado el libro " + book.getTitle() + "\033[0m");
            System.out.println(e.getMessage());
        } finally {
            DBManager.closeConnection();
        }
    }

    public Book getBookById(int id){
        try {
            connection = DBManager.initConnection();

            String sql = "SELECT id, title, author, isbn FROM books WHERE id = ?";
            stmn = connection.prepareStatement(sql);
            stmn.setInt(1, id);
            ResultSet result = stmn.executeQuery();
            
            if (result.next()) {
                Book book = new Book();
                book.setId(result.getInt("id"));
                book.setTitle(result.getString("title"));
                book.setAuthor(result.getString("author"));
                book.setIsbn(result.getLong("isbn"));
                return book;
            }
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "No se ha encontrado el libro con id " + id + "\033[0m");
            System.out.println(e.getMessage());
        } finally {
            DBManager.closeConnection();
        }
        return null;
    }

    public void updateBook(Book book){
        try {
            connection = DBManager.initConnection();

            String sql = "UPDATE books SET title = ?, author = ?, isbn = ? WHERE id = ?";
            stmn = connection.prepareStatement(sql);
            stmn.setString(1, book.getTitle());
            stmn.setString(2, book.getAuthor());
            stmn.setLong(3, book.getIsbn());
            stmn.setInt(4, book.getId());
            stmn.executeUpdate();
            System.out.println("\033[0;32m" + "\n¡Libro " + book.getTitle() + " actualizado con éxito!" + "\033[0m");
            
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "No se ha actualizado el libro con id " + book.getId() + "\033[0m");
            System.out.println(e.getMessage());
        } finally {
            DBManager.closeConnection();
        }
    }

    public void deleteBook(int id){
        try {
            connection = DBManager.initConnection();

            String sql = "DELETE FROM books WHERE id = ?";
            stmn = connection.prepareStatement(sql);
            stmn.setInt(1, id);
            stmn.executeUpdate();
            System.out.println("\033[0;32m" + "\n¡Libro con id " + id + " se ha eliminado con éxito!" + "\033[0m");

        } catch (Exception e) {
            System.out.println("\033[0;31m" + "No se ha eliminado el libro con id " + id + "\033[0m");
            System.out.println(e.getMessage());
        } finally {
            DBManager.closeConnection();
        }
    }
    
}
