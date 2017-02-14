package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestBibliotecaApp {


    @Test
    public void testCreateBook() {
        Book testBook = new Book("TestCreated", "FakeAuthor", 0, true);
        assertEquals(library.libraryList.contains(testBook), true);
    }

    @Test
    public void testSuccessfulCheckoutBook(){
        Book testBook = new Book("TestTitle1", "TestAuthor", 0, true);
        library.checkoutBook("TestTitle1");
        assertEquals (testBook.bookAvailable, false);
    }

    @Test
    public void testSuccessfulReturnBook(){
        Book testBook = new Book("TestTitle2", "TestAuthor", 0, false);
        library.returnBook("TestTitle2");
        assertEquals(testBook.bookAvailable, true);
    }

    @Test
    public void testFindBookSuccessful(){
        Book testBook = new Book("TestTitle3", "Author", 0, true);
        int bookLocation = library.findBookLocation("TestTitle3");
        assertNotEquals(bookLocation, -1);
    }

    @Test
    public void testFindBookUnsuccessful(){
        int bookLocation = library.findBookLocation("TestTitle100");
        assertEquals(bookLocation, -1);
    }
    /*
    @Test
    public void testUnsuccessfulCheckoutBook(){

        library.checkoutBook(testBook);

    }


    /*
     * TO TEST
     *
     * listBooks
     * checkUnavailableBooksNotListed
     *
     */


}
