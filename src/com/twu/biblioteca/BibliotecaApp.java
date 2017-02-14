package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        initLibraryBooks();
        new mainMenu();
    }

    private static void initLibraryBooks(){
        new Book("Mr. Mercedes", "Steven Spielberg", 2001, true);
        new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, true);
        new Book("Atlas Shrugged", "Ayn Rand", 1957, true);
        new Book("Moby Dick", "Herman Melville", 1851, true);
        new Book("Sharp Objects", "Gillian Flynn", 2005, true);
    }
}
