package com.twu.biblioteca;

import java.util.*;

public class Library {
    public final static HashMap<Book, Boolean> bookCatalogAndAvailability = new HashMap<Book, Boolean>();
    public final static HashMap<Movie, Boolean> movieCatalogAndAvailability = new HashMap<Movie, Boolean>();
    private final static ArrayList<User> userDirectory = new ArrayList<User>();


    public Library(ArrayList<Book> newBooks) {
        for (Book book : newBooks) {
            addNewBook(book);
        }
    }

    public Library(ArrayList<Book> newBooks, ArrayList<Movie> newMovies, ArrayList<User> users) {
        for (Book book : newBooks) {
            addNewBook(book);
        }

        for (Movie movie : newMovies) {
            addNewMovie(movie);
        }

        for (User user : users) {
            addNewUser(user);
        }
    }

    public void addNewUser(User user){
        this.userDirectory.add(user);
    }

    public void addNewBook(Book book) {
        this.bookCatalogAndAvailability.put(book, true);
    }

    public void addNewUnavailableBook(Book book) {
        this.bookCatalogAndAvailability.put(book, false);
    }

    public void addNewMovie(Movie movie) {
        this.movieCatalogAndAvailability.put(movie, true);
    }

    public static void checkoutBook(String bookRequested, User currentUser) {

        Book requestedBook = findBookByTitle(bookRequested);
        if (requestedBook != null) {
            if (itemTransaction(requestedBook, false, true, bookCatalogAndAvailability, currentUser)) {
                System.out.println("\nThank you, enjoy the book!\n");
                return;
            }
        }
        System.out.println("\nThat book is not available\n");
    }


    public static void returnBook(String bookRequested, User currentUser) {

        Book requestedBook = findBookByTitle(bookRequested);
        if (requestedBook != null) {
            if (itemTransaction(requestedBook, true, false, bookCatalogAndAvailability, currentUser)) {
                System.out.println("\nThank you for returning the book!\n");
                return;
            }
        } else System.out.println("\nThat is not a valid book return\n");
    }


    public static boolean itemTransaction(LibraryItem item, Boolean newAvailability, Boolean expectedOldAvailability, HashMap catalog, User currentUser) {
        if (item != null) {
            if (catalog.get(item) == expectedOldAvailability) {
                catalog.put(item, newAvailability);
                if (newAvailability) {
                    currentUser.removeReturnedItem(item);
                } else currentUser.addCheckedOutItem(item);

                return true;
            }
        }
        return false;
    }


    public static Book findBookByTitle(String requestedBookTitle) {

        for (Book book : bookCatalogAndAvailability.keySet()) {
            if (book.getTitle().equals(requestedBookTitle)) {
                return book;
            }
        }
        // book not found
        return null;
    }


    public static void checkoutMovie(String movieRequested, User currentUser) {

        Movie requestedMovie = findMovieByTitle(movieRequested);
        if (requestedMovie != null) {
            if (itemTransaction(requestedMovie, false, true, movieCatalogAndAvailability, currentUser)) {
                System.out.println("\nThank you, enjoy the movie!\n");
                return;
            }
        }
        System.out.println("\nThat movie is not available\n");
    }


    public static void returnMovie(String movieRequested, User currentUser) {

        Movie requestedMovie = findMovieByTitle(movieRequested);
        if (requestedMovie != null) {
            if (itemTransaction(requestedMovie, true, false, movieCatalogAndAvailability, currentUser)) {
                System.out.println("\nThank you for returning the movie!\n");
                return;
            }
        }
        System.out.println("\nThat is not a valid movie return\n");
    }


    public static Movie findMovieByTitle(String requestedMovieTitle) {

        for (Movie movie : movieCatalogAndAvailability.keySet()) {
            if (movie.getTitle().equals(requestedMovieTitle)) {
                return movie;
            }
        }
        // movie not found
        return null;
    }

    public static User login() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter your Library Id Number (xxx-xxxx): ");
        String userLibraryNumber = reader.nextLine();
        User currentUser = getUserByNumber(userLibraryNumber);

        if (currentUser == null) {
            System.out.println("User not found\n");
            return null;
        }
        System.out.println("Please enter your password: ");
        String password = reader.nextLine();
        if (confirmUserPassword(currentUser, password)){
            System.out.println("Login Successful\n");
            return currentUser;
        }
        System.out.println("Password incorrect\n");
        return null;
    }


    public static User getUserByNumber(String userLibraryNumber) {
        User currentUser = null;
        for (User user : userDirectory) {
            if (user.getLibraryNumber().equals(userLibraryNumber)) {
                currentUser = user;
                break;
            }
        }
        return currentUser;

    }

    public static boolean confirmUserPassword(User currentUser, String userPassword){

        if (currentUser.getPassword().equals(userPassword)) {
            return true;
        }
        return false;
    }

    public static User logout(){
        System.out.println("Logout Successful");
        return null;
    }
}



