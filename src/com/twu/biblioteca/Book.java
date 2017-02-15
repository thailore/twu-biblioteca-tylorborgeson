package com.twu.biblioteca;


public class Book {
    private String bookTitle = "";
    private String bookAuthor = "";
    private int bookYear = 0;
    public boolean bookAvailable;

    public Book(String title, String author, int year){
        bookTitle = title;
        bookAuthor = author;
        bookYear = year;
        bookAvailable = true;
        Library.bookCatalog.add(this);
    }

    public Book(String title, String author, int year, boolean availability){
        bookTitle = title;
        bookAuthor = author;
        bookYear = year;
        bookAvailable = availability;
        Library.bookCatalog.add(this);
    }

    public String getBookTitle(){
        return this.bookTitle;
    }

    public String getBookAuthor(){
        return this.bookAuthor;
    }

    public int getBookYear(){
        return this.bookYear;
    }

    public boolean getBookIsAvailable(){
        return this.bookAvailable;
    }

}
