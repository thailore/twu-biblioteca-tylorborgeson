package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<Book> newBooks = BibliotecaApp.initLibraryBooks();
        Library bookLibrary = new Library(newBooks);
        new MainMenu(bookLibrary);
    }

    private static ArrayList<Book> initLibraryBooks(){
        ArrayList<Book> libraryBooks = new ArrayList<Book>();
        libraryBooks.add(new Book("Mr. Mercedes", "Steven Spielberg", 2001));
        libraryBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        libraryBooks.add(new Book("Atlas Shrugged", "Ayn Rand", 1957));

        return libraryBooks;
    }

}
