package com.twu.biblioteca;

import java.util.*;

public class Library {
    public final static HashMap<Book, Boolean> bookCatalogAndAvailability = new HashMap<Book, Boolean>();

    public Library(ArrayList<Book> newBooks){
        for (Book book : newBooks){
            addNewBook(book);
        }
    }

    public void addNewBook(Book book){
        this.bookCatalogAndAvailability.put(book, true);
    }

    public void addNewUnavailableBook(Book book){
        this.bookCatalogAndAvailability.put(book, false);
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


 }



