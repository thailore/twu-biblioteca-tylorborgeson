package com.twu.biblioteca;

import java.util.*;

public class Library {
    public final static HashMap<Book, Boolean> bookCatalogAndAvailability = new HashMap<Book, Boolean>();

    public Library(){}


    public static void addNewBook(Book book){
        Library.bookCatalogAndAvailability.put(book, true);
    }

    public static void addNewUnavailableBook(Book book){
        Library.bookCatalogAndAvailability.put(book, false);
    }

    public static void checkoutBook(String bookRequested){

        Book requestedBook = findBookByTitle(bookRequested);
        if (requestedBook!=null){
            if (bookCatalogAndAvailability.get(requestedBook)) {
                bookCatalogAndAvailability.put(requestedBook, false);
                System.out.println("\nThank you, enjoy the book!\n");
                return;
            }
        } System.out.println("That book is not available");
    }

    public static void returnBook(String bookRequested){

        Book requestedBook = findBookByTitle(bookRequested);
        if (requestedBook!=null){
            if (!bookCatalogAndAvailability.get(requestedBook)) {
                bookCatalogAndAvailability.put(requestedBook, true);
                System.out.println("\nThank you for returning the book!\n");
                return;
            }
        } System.out.println("That is not a valid book return");
    }

    public static Book findBookByTitle(String requestedBookTitle){

        for (Book book : bookCatalogAndAvailability.keySet()){
            if (book.getTitle().equals(requestedBookTitle)){
                return book;
            }
        }
        //book not found*/
        return null;
    }

    public static void listBooks(){

        printTitleBar("AVAILABLE BOOKS", "Book Title", "Author", "Year");
    /*
        for (Book book : bookCatalog){
            if(book.isBookAvailable()) {
                System.out.println(String.format("%-20s %-20s %-4s", book.getTitle(), book.getAuthor(), book.getYear()));
            }
        }
        System.out.println();*/
    }


    public static void printTitleBar(String title, String label1, String label2, String label3){

        System.out.println("\n"+title);
        System.out.println(String.format("%-20s %-20s %-4s", label1, label2, label3+"\n"));

    }


}
