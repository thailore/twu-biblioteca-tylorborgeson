package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        initLibraryBooks();
        mainMenu mainMenu = new mainMenu();
    }

    public static void initLibraryBooks(){
        Book book1 = new Book("Mr. Mercedes", "Steven Spielberg", 2001, true);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, true);
        Book book3 = new Book("Atlas Shrugged", "Ayn Rand", 1957, true);
        Book book4 = new Book("Moby Dick", "Herman Melville", 1851, true);
        Book book5 = new Book("Sharp Objects", "Gillian Flynn", 2005, true);
    }
}
