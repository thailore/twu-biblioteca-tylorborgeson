package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class DisplayInformation {

    public DisplayInformation(HashMap<Book, Boolean> bookCatalog, HashMap<Movie, Boolean> movieCatalog, ArrayList<LibraryItem> userItems, User user) {
        if (bookCatalog != null){
            displayBookCatalog(bookCatalog);
        }
        if (movieCatalog != null) {
            displayMovieCatalog(movieCatalog);
        }
        if (userItems != null) {
            displayUserCheckedOutItems(userItems);
        }
        if (user != null){
            displayUserInfo(user);
        }
    }


    public void displayMovieCatalog(HashMap<Movie, Boolean> movieCatalog){

        printTitleBar("MOVIES", "Title", "Director", "Year", "Rating");

        for (Movie movie : movieCatalog.keySet()) {
            if (movieCatalog.get(movie)) {
                System.out.println(String.format("%-20s %-20s %-4s %-4s", movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getRating()));
            }
        }
        System.out.println();

    }

    public void displayBookCatalog(HashMap<Book, Boolean> bookCatalog) {

        printTitleBar("BOOKS", "Title", "Author", "Year", "");

        for (Book book : bookCatalog.keySet()) {
            if (bookCatalog.get(book)) {
                System.out.println(String.format("%-20s %-20s %-4s", book.getTitle(), book.getAuthor(), book.getYear()));
            }
        }
        System.out.println();

    }

    public void displayUserCheckedOutItems(ArrayList<LibraryItem> userItems){
        printTitleBar("Your Items", "Title" , "Item Type", "", "");
        for (LibraryItem item : userItems){
            System.out.println(String.format("%-20s %5s", item.getTitle(), item.getClass().getSimpleName()));
        }System.out.println();
    }

    public void displayUserInfo(User user){
        printTitleBar("", "Name", "Email Address", "Phone Number", "");
        System.out.println(String.format("%-20s %-20s %-10s", user.getName(), user.getEmailAddress(), user.getPhoneNumber()));
    }


    public static void printTitleBar(String title, String label1, String label2, String label3, String label4){

        System.out.println("\n"+title);
        System.out.println(String.format("%-20s %-20s %-10s %-10s", label1, label2, label3, label4+"\n"));
    }

}
