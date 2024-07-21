package com.femcoders.view;

import java.util.List;
import java.util.Scanner;

import com.femcoders.controller.BookController;
import com.femcoders.model.Book;

public class BookView {

    private BookController bookController;

    public BookView(BookController bookController){
        this.bookController = bookController;
    }

    public void showMenu(){
        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            System.out.println("\n-- Menú de Libros --");
            System.out.println("\t1. Obtener libros");
            System.out.println("\t2. Agregar libros");
            System.out.println("\t3. Editar un libro");
            System.out.println("\t4. Obtener un libro por id");
            System.out.println("\t5. Eliminar un libro");
            System.out.println("\t0. Salir");
            System.out.print("Ingrese una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    getBooks();
                    break;
                case 2:
                    addBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    getBookById(scanner);
                    break;
                case 5:
                    deleteBook(scanner);
                    break;
                case 0:
                    System.out.println("\033[0;32m" + "Saliendo del programa" + "\033[0m");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\033[0;31m" + "Opción no válida. Intente de nuevo." + "\033[0m");
                    break;
            }

        } while (option != 0);

        scanner.close();
    }

    private void getBooks(){
        List<Book> books = bookController.getBooks();
        for (Book book : books) {
            System.out.println("\033[0;35m" + book.getId());
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.getIsbn() + "\033[0m");
            System.out.println("-------- o --------");
        }
    }

    private void addBook(Scanner scanner){
        System.out.println("\n-- Agregar Libro --");
        System.out.print("\tIngrese el título del libro: ");
        String title = scanner.nextLine();
        System.out.print("\tIngrese el autor del libro: ");
        String author = scanner.nextLine();
        System.out.print("\tIngrese el ISBN del libro: ");
        Long isbn = scanner.nextLong();

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setIsbn(isbn);

        bookController.addBook(newBook);
    }

    private void updateBook(Scanner scanner){
        System.out.println("\n-- Actualizar Libro --");
        System.out.print("\nIngrese el id del libro a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book bookFound = bookController.getBookById(id);

        if(bookFound != null){
            System.out.print("Ingrese el nuevo título del libro: ");
            String title = scanner.nextLine();
            System.out.print("Ingrese el nuevo autor del libro: ");
            String author = scanner.nextLine();
            System.out.print("Ingrese el nuevo ISBN del libro: ");
            Long isbn = scanner.nextLong();
            scanner.nextLine();

            Book updatedBook = new Book();
            updatedBook.setId(id);
            updatedBook.setTitle(title);
            updatedBook.setAuthor(author);
            updatedBook.setIsbn(isbn);

            bookController.updateBook(updatedBook);

        } else {
            System.out.println("\033[0;31m" + "Libro con id " + id + " no encontrado." + "\033[0m");
        }
    }

    public void getBookById(Scanner scanner){
        System.out.println("\n-- Ver Libro por id --");
        System.out.print("\nIngrese el id del libro a ver: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book bookFound = bookController.getBookById(id);

        if(bookFound != null){
            System.out.println("\033[0;35m" + "\nId: " + bookFound.getId());
            System.out.println("Título: " + bookFound.getTitle());
            System.out.println("Autor: " + bookFound.getAuthor());
            System.out.println("Isbn: " + bookFound.getIsbn() + "\033[0m");
            System.out.println("-------- o --------");
        } else {
            System.out.println("\033[0;31m" + "Libro con id " + id + " no encontrado." + "\033[0m");
        }   
    }

    public void deleteBook(Scanner scanner){
        System.out.println("\n-- Eliminar Libro por id --");
        System.out.print("\nIngrese el id del libro a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book bookFound = bookController.getBookById(id);
        
        if(bookFound != null){
            bookController.deleteBook(id);
        } else {
            System.out.println("\033[0;31m" + "Libro con id " + id + " no encontrado." + "\033[0m");
        }
    }
}
