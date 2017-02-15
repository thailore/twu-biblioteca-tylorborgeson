package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    public final static ArrayList<Book> bookCatalog = new ArrayList<Book>();


    public static void checkoutBook(String bookRequested){

        int bookIndex = findBookLocation(bookRequested);
        if (bookIndex > -1) {
            Book book = bookCatalog.get(bookIndex);
            if (book.bookAvailable) {
                book.bookAvailable = false;
                System.out.println("\nThank you, enjoy the book!\n");
                return;
            }
        }
        System.out.println("That book is not available");
    }

    public static void returnBook(String bookRequested){

        int bookIndex = findBookLocation(bookRequested);
        if (bookIndex > -1) {
            Book book = bookCatalog.get(bookIndex);
            book.bookAvailable = true;
            System.out.println("\nThank you for returning the book!\n");
        }else{
            System.out.println("\nThat is not a valid book return\n");
        }
    }

    public static int findBookLocation(String requestedBookTitle){

        for (Book book : bookCatalog){
            if (book.getBookTitle().equals(requestedBookTitle)){
                return bookCatalog.indexOf(book);
            }
        }
        //book not found
        return -1;
    }

    public static void listBooks(){

        printTitleBar("AVAILABLE BOOKS", "Book Title", "Author", "Year");

        for (Book book : bookCatalog){
            if(book.getBookIsAvailable()) {
                System.out.println(String.format("%-20s %-20s %-4s", book.getBookTitle(), book.getBookAuthor(), book.getBookYear()));
            }
        }
        System.out.println();
    }


    public static void printTitleBar(String title, String label1, String label2, String label3){

        System.out.println("\n"+title);
        System.out.println(String.format("%-20s %-20s %-4s", label1, label2, label3+"\n"));

    }
}
