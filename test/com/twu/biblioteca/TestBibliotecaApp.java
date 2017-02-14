package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestBibliotecaApp {

    String formattedBookInfo = String.format("%-20s %-20s %-4s", "Book Title", "Author", "Year\n");

    @Test
    public void testCreateBook() {

        Book testBook = new Book("TestCreated", "FakeAuthor", 0, true);
        assertEquals(library.libraryList.contains(testBook), true);
        library.libraryList.remove(testBook);
    }

    @Test
    public void testSuccessfulCheckoutBook() {

        Book testBook = new Book("TestTitle1", "TestAuthor", 0, true);
        library.checkoutBook("TestTitle1");
        assertEquals(testBook.bookAvailable, false);
        library.libraryList.remove(testBook);
    }

    @Test
    public void testSuccessfulReturnBook() {

        Book testBook = new Book("TestTitle2", "TestAuthor", 0, false);
        library.returnBook("TestTitle2");
        assertEquals(testBook.bookAvailable, true);
        library.libraryList.remove(testBook);
    }

    @Test
    public void testFindBookSuccessful() {

        Book testBook = new Book("TestTitle3", "Author", 0, true);
        int bookLocation = library.findBookLocation("TestTitle3");
        assertNotEquals(bookLocation, -1);
        library.libraryList.remove(testBook);
    }

    @Test
    public void testFindBookUnsuccessful() {

        int bookLocation = library.findBookLocation("TestTitle100");
        assertEquals(bookLocation, -1);
    }

    @Test
    public void testUnsuccessfulCheckoutBook() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        library.checkoutBook("A Fake Book");
        String expectedOutput = "That book is not available\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testUnsuccessfulReturnBook() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        library.returnBook("Another Fake Book");
        String expectedOutput = "\nThat is not a valid book return\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testListBooks() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        library.listBooks();
        String expectedOutput = "\nAVAILABLE BOOKS\n" + formattedBookInfo + "\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testListOnlyAvailableBooks() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book testBook = new Book("TestBook", "TestAuthor", 0, false);
        library.listBooks();
        String expectedOutput = "\nAVAILABLE BOOKS\n" + formattedBookInfo + "\n\n";
        assertEquals(expectedOutput, outContent.toString());
        library.libraryList.remove(testBook);
    }
}

