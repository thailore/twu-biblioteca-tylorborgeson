package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        initLibraryBooks();
        new MainMenu();
    }

    private static void initLibraryBooks(){
        Library.addNewBook(new Book("Mr. Mercedes", "Steven Spielberg", 2001));
        Library.addNewBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        Library.addNewBook(new Book("Atlas Shrugged", "Ayn Rand", 1957));
        Library.addNewBook(new Book("Moby Dick", "Herman Melville", 1851));
        Library.addNewBook(new Book("Sharp Objects", "Gillian Flynn", 2005));
    }

}
