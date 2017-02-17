package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestBibliotecaApp {
    public ArrayList<Book> testBookCatalog = new ArrayList<Book>();
    Library testLibrary = new Library(testBookCatalog);
    String formattedBookInfo = String.format("%-20s %-20s %-4s", "Book Title", "Author", "Year\n");

    @Test
    public void testCreateBook() {

        Book testBook = new Book("TestCreated", "FakeAuthor", 0);
        testLibrary.addNewBook(testBook);
        assertEquals(Library.bookCatalogAndAvailability.containsKey(testBook), true);
        testLibrary.bookCatalogAndAvailability.remove(testBook);
    }

    @Test
    public void testBookAvailable(){

        Book testBook = new Book("TestCreated", "FakeAuthor", 0);
        testLibrary.addNewBook(testBook);
        assertEquals(Library.bookCatalogAndAvailability.get(testBook), true);
        testLibrary.bookCatalogAndAvailability.remove(testBook);
    }

    @Test
    public void testSuccessfulCheckoutBook() {
        Book testBook = new Book("TestTitle1", "TestAuthor", 0);
        testLibrary.addNewBook(testBook);
        testLibrary.checkoutBook("TestTitle1");
        assertEquals(Library.bookCatalogAndAvailability.get(testBook), false);
        testLibrary.bookCatalogAndAvailability.remove(testBook);
    }

    @Test
    public void testSuccessfulReturnBook() {

        Book testBook = new Book("TestTitle2", "TestAuthor", 0);
        testLibrary.addNewBook(testBook);
        testLibrary.returnBook("TestTitle2");
        assertEquals(Library.bookCatalogAndAvailability.get(testBook), true);
        testLibrary.bookCatalogAndAvailability.remove(testBook);
    }

    @Test
    public void testFindBookSuccessful() {

        Book testBook = new Book("TestTitle3", "Author", 0);
        testLibrary.addNewBook(testBook);
        Book bookLocation = testLibrary.findBookByTitle("TestTitle3");
        assertEquals(bookLocation, testBook);
        testLibrary.bookCatalogAndAvailability.remove(testBook);
    }

    @Test
    public void testFindBookUnsuccessful() {

        Book bookLocation = Library.findBookByTitle("TestTitle100");
        assertEquals(bookLocation, null);
    }

    @Test
    public void testListBooks() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        new DisplayInformation(testLibrary.bookCatalogAndAvailability);
        String expectedOutput = "\nAVAILABLE BOOKS\n" + formattedBookInfo + "\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testOnlyListAvailableBooks() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book testBook = new Book("TestBook", "TestAuthor", 0);
        testLibrary.addNewUnavailableBook(testBook);
        new DisplayInformation(testLibrary.bookCatalogAndAvailability);
        String expectedOutput = "\nAVAILABLE BOOKS\n" + formattedBookInfo + "\n\n";
        assertEquals(expectedOutput, outContent.toString());
        testLibrary.bookCatalogAndAvailability.remove(testBook);
    }


    @Test
    public void testUnsuccessfulCheckoutBook() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testLibrary.checkoutBook("A Fake Book");
        String expectedOutput = "That book is not available\n";
        assertEquals(expectedOutput, outContent.toString());
    }



    @Test
    public void testUnsuccessfulReturnBook() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testLibrary.returnBook("Another Fake Book");
        String expectedOutput = "That is not a valid book return\n";
        assertEquals(expectedOutput, outContent.toString());
    }


}

