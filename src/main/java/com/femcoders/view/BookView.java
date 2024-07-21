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
            System.out.println(book.getId());
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.getIsbn());
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
}
