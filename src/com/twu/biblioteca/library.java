package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by tborgeso on 10/02/2017.
 */
public class library {
    public static ArrayList<Book> libraryList = new ArrayList<Book>();


    public static void checkoutBook(String bookRequested){
        int bookIndex = findBookLocation(bookRequested);
        if (bookIndex > -1) {
            Book book = libraryList.get(bookIndex);
            if (book.bookAvailable == true) {
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
            Book book = libraryList.get(bookIndex);
            book.bookAvailable = true;
            System.out.println("\nThank you for returning the book!\n");
        }else{
            System.out.println("\nThat is not a valid book return\n");
        }
    }

    public static int findBookLocation(String requestedBookTitle){

        for (Book book : libraryList){
            if (book.getBookTitle().equals(requestedBookTitle)){
                return libraryList.indexOf(book);
            }
        }
        //book not found
        return -1;
    }

    public static void listBooks(){
        System.out.println("\nAVAILABLE BOOKS");
        System.out.println(String.format("%-20s %-20s %-4s", "Book Title", "Author", "Year\n"));
        for (Book book : libraryList){
            if(book.getBookIsAvailable()) {
                System.out.println(String.format("%-20s %-20s %-4s", book.getBookTitle(), book.getBookAuthor(), book.getBookYear()));
            }
        }
        System.out.println();
    }

}
