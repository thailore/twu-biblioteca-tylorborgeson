package com.twu.biblioteca;


public class Book extends LibraryItem{
    private String author;
    private int year;


    public Book(String bookTitle, String author, int year){
        super(bookTitle);
        this.author = author;
        this.year = year;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getYear(){
        return this.year;
    }


}
