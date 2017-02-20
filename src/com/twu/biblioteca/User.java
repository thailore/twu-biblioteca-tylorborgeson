package com.twu.biblioteca;

/**
 * Created by tborgeso on 17/02/2017.
 */
public class User {
    public String libraryNumber;
    private String password;
    public String name;
    public String emailAddress;
    public String phoneNumber;

    public User (String libraryNumber, String password, String name, String email, String phoneNumber){
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.emailAddress = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

