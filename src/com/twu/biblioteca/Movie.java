package com.twu.biblioteca;

/**
 * Created by tborgeso on 17/02/2017.
 */
public class Movie extends LibraryItem{
    String director;
    int year;
    int rating;

    public Movie(String title, String director, int year, int rating){
        super(title);

        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getDirector(){
        return this.director;
    }

    public int getYear(){
        return this.year;
    }

    public int getRating(){
        return this.rating;
    }

}
