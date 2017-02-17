package com.twu.biblioteca;

import java.util.HashMap;

public class DisplayInformation {

    /*
    public DisplayInformation(HashMap<Movie, Boolean> movieCatalog){
        displayCatalog(catalog);

    }*/

    public DisplayInformation(HashMap<Book, Boolean> bookCatalog){
       displayBookCatalog(bookCatalog);
    }

    public void displayBookCatalog(HashMap<Book, Boolean> bookCatalog) {

        printTitleBar("AVAILABLE BOOKS", "Book Title", "Author", "Year");

        for (Book book : bookCatalog.keySet()) {
            if (bookCatalog.get(book)) {
                System.out.println(String.format("%-20s %-20s %-4s", book.getTitle(), book.getAuthor(), book.getYear()));
            }
        }
        System.out.println();

    }

    public void printTitleBar(String title, String label1, String label2, String label3){

        System.out.println("\n"+title);
        System.out.println(String.format("%-20s %-20s %-4s", label1, label2, label3+"\n"));
    }

}
