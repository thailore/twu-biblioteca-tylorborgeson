package com.twu.biblioteca;

import java.util.HashMap;

public class DisplayInformation {

    public DisplayInformation(HashMap<Book, Boolean> bookCatalog,HashMap<Movie, Boolean> movieCatalog){
        if(bookCatalog == null) {
            displayMovieCatalog(movieCatalog);
        }else{
            displayBookCatalog(bookCatalog);
        }
    }



    public void displayMovieCatalog(HashMap<Movie, Boolean> movieCatalog){

        printTitleBar("AVAILABLE MOVIES", "Title", "Director", "Year", "Rating");

        for (Movie movie : movieCatalog.keySet()) {
            if (movieCatalog.get(movie)) {
                System.out.println(String.format("%-20s %-20s %-4s %-4s", movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getRating()));
            }
        }
        System.out.println();

    }


    public void displayBookCatalog(HashMap<Book, Boolean> bookCatalog) {

        printTitleBar("AVAILABLE BOOKS", "Title", "Author", "Year", "");

        for (Book book : bookCatalog.keySet()) {
            if (bookCatalog.get(book)) {
                System.out.println(String.format("%-20s %-20s %-4s", book.getTitle(), book.getAuthor(), book.getYear()));
            }
        }
        System.out.println();

    }

    public static void printTitleBar(String title, String label1, String label2, String label3, String label4){

        System.out.println("\n"+title);
        System.out.println(String.format("%-20s %-20s %-4s %-4s", label1, label2, label3, label4+"\n"));
    }

}
