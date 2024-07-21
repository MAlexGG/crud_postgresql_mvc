package com.femcoders.view;

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
                    bookController.getBooks();
                    break;
                case 2:
                    addBook(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }



        } while (option != 0);

        scanner.close();
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
