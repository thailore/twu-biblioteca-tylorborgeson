package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestBibliotecaApp {
    public ArrayList<Book> testBookCatalog = new ArrayList<Book>();
    Library testLibrary = new Library(testBookCatalog);
    String formattedBookInfo = String.format("%-20s %-20s %4s %-4s", "Title", "Author", "Year", "\n");
    String formattedMovieInfo = String.format("%-20s %-20s %4s %-4s", "Title", "Director", "Year", "Rating\n");

    @Test
    public void testCreateBook() {
        Book testBook = new Book("TestCreated", "FakeAuthor", 0);
        testLibrary.addNewBook(testBook);
        assertEquals(testLibrary.bookCatalogAndAvailability.containsKey(testBook), true);
        testLibrary.bookCatalogAndAvailability.remove(testBook);
    }

    @Test
    public void testBookAvailable(){
        Book testBook = new Book("TestCreated", "FakeAuthor", 0);
        testLibrary.addNewBook(testBook);
        assertEquals(testLibrary.bookCatalogAndAvailability.get(testBook), true);
        testLibrary.bookCatalogAndAvailability.remove(testBook);
    }

    @Test
    public void testSuccessfulCheckoutBook() {
        Book testBook = new Book("TestTitle1", "TestAuthor", 0);
        testLibrary.addNewBook(testBook);
        testLibrary.checkoutBook("TestTitle1");
        assertEquals(testLibrary.bookCatalogAndAvailability.get(testBook), false);
        testLibrary.bookCatalogAndAvailability.remove(testBook);
    }

    @Test
    public void testSuccessfulReturnBook() {

        Book testBook = new Book("TestTitle2", "TestAuthor", 0);
        testLibrary.addNewBook(testBook);
        testLibrary.returnBook("TestTitle2");
        assertEquals(testLibrary.bookCatalogAndAvailability.get(testBook), true);
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
        new DisplayInformation(testLibrary.bookCatalogAndAvailability, null);
        String expectedOutput = "\nAVAILABLE BOOKS\n" + formattedBookInfo + "\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testOnlyListAvailableBooks() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book testBook = new Book("TestBook", "TestAuthor", 0);
        testLibrary.addNewUnavailableBook(testBook);
        new DisplayInformation(testLibrary.bookCatalogAndAvailability, null);
        String expectedOutput = "\nAVAILABLE BOOKS\n" + formattedBookInfo + "\n\n";
        assertEquals(expectedOutput, outContent.toString());
        testLibrary.bookCatalogAndAvailability.remove(testBook);
    }


    @Test
    public void testUnsuccessfulCheckoutBook() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testLibrary.checkoutBook("A Fake Book");
        String expectedOutput = "\nThat book is not available\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void testUnsuccessfulReturnBook() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testLibrary.returnBook("Another Fake Book");
        String expectedOutput = "\nThat is not a valid book return\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testCreateMovie(){
        Movie testMovie = new Movie("TestCreated", "FakeAuthor", 0, 0);
        testLibrary.addNewMovie(testMovie);
        assertEquals(testLibrary.movieCatalogAndAvailability.containsKey(testMovie), true);
        testLibrary.movieCatalogAndAvailability.remove(testMovie);
    }

    @Test
    public void testListMovies(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        new DisplayInformation( null, testLibrary.movieCatalogAndAvailability);
        String expectedOutput = "\nAVAILABLE MOVIES\n" + formattedMovieInfo + "\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testSuccessfulCheckoutMovie() {
        Movie testMovie = new Movie("TestTitle1", "TestDirector", 0, 0);
        testLibrary.addNewMovie(testMovie);
        testLibrary.checkoutMovie("TestTitle1");
        assertEquals(testLibrary.movieCatalogAndAvailability.get(testMovie), false);
        testLibrary.movieCatalogAndAvailability.remove(testMovie);
    }


}

