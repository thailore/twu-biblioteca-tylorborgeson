package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<Book> newBooks = BibliotecaApp.initLibraryBooks();
        ArrayList<Movie> newMovies = BibliotecaApp.initLibraryMovies();
        ArrayList<User> users = BibliotecaApp.initUsers();

        Library bookLibrary = new Library(newBooks, newMovies, users);
        new MainMenu(bookLibrary);
    }

    private static ArrayList<Book> initLibraryBooks(){
        ArrayList<Book> libraryBooks = new ArrayList<Book>();
        libraryBooks.add(new Book("Mr. Mercedes", "Steven Spielberg", 2001));
        libraryBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        libraryBooks.add(new Book("Atlas Shrugged", "Ayn Rand", 1957));

        return libraryBooks;
    }

    private static ArrayList<Movie> initLibraryMovies(){
        ArrayList<Movie> libraryMovies = new ArrayList<Movie>();
        libraryMovies.add(new Movie("La La Land", "Damien Chazelle", 2016, 8));
        libraryMovies.add(new Movie("Moonlight", "Barry Jenkins", 2016, 9));
        libraryMovies.add(new Movie("Zootopia", "Bryon Howard", 2016, 7));

        return libraryMovies;
    }

    private static ArrayList<User> initUsers(){
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("111-2222", "qwerty", "First User", "firstuser@email.com", "1234567"));
        users.add(new User("222-3333", "abcde", "Second User", "seconduser@email.com", "1234566"));
        return users;
    }

}
