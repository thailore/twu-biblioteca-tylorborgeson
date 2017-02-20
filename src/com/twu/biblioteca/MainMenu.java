package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    public static Library library1;
    public User loggedInUser = null;

    public static final ArrayList<String> allUserOptions = new ArrayList<String>(){{
        add ("List Available Books");
        add ("List Available Movies");
        add ("Login");
        add ("Checkout Book");
        add ("Return Book");
        add ("Checkout Movie");
        add ("Return Movie");
        add ("List My Items");
        add ("Logout");
        add ("Quit");
        add ("List My Info");
    }};

    public static final ArrayList<String> loggedInUserOptions = new ArrayList<String>(){{
        add ("List My Items");
        add ("List My Info ");
        add ("Checkout Book");
        add ("Return Book");
        add ("Checkout Movie");
        add ("Return Movie");
        add ("Logout");
    }};


    public MainMenu(Library library){
        library1 = library;
        this.welcomeMessage();
        this.show();
    }

    private void welcomeMessage(){
        System.out.println("Welcome to the Bangalore Public Library Console!\n");
    }

    private void show(){
        System.out.println("LIBRARY MAIN MENU");
        System.out.println("Available Actions: ");
        System.out.println("> List Available Books");
        System.out.println("> List Available Movies");

        if (loggedInUser==null) {
            System.out.println("> Login");
            System.out.println("> Quit");
            System.out.println("\nPlease Login for more options\n");
            route();
        } else {
            System.out.println("> Checkout Book");
            System.out.println("> Return Book");
            System.out.println("> Checkout Movie");
            System.out.println("> Return Movie");
            System.out.println("> List My Items");
            System.out.println("> List My Info");
            System.out.println("> Logout");
            System.out.println("> Quit");
            route();
        }
    }

    private void route(){
        String action = getMainMenuUserInput("What would you like to do? Type in action as shown  ");
        this.executeAction(action);
    }

    private String getMainMenuUserInput(String prompt){
        Scanner reader = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = reader.nextLine();
        boolean validInput = validMainMenuUserInput(userInput);
        if (validInput) {
            return userInput;
        }
        userInput = getMainMenuUserInput("\nPlease enter a valid action: ");
        return userInput;
    }

    private boolean validMainMenuUserInput(String userInput){
        if (!allUserOptions.contains(userInput)){
            return false;
        }
        if (loggedInUser == null && loggedInUserOptions.contains(userInput)){
            return false;
        }
        return true;
    }

    private void executeAction(String action){
        Scanner reader = new Scanner(System.in);
        switch(allUserOptions.indexOf(action)){
            case 0 : {
                new DisplayInformation(library1.bookCatalogAndAvailability, null, null, null);
                this.show();
            }
            case 1 : {
                new DisplayInformation(null, library1.movieCatalogAndAvailability, null, null);
                this.show();
            }
            case 2 : {
                loggedInUser = library1.login();
                this.show();
            }
            case 3 : {
                System.out.println("\nEnter the book title you want to checkout, careful of spelling: ");
                String bookName = reader.nextLine();
                library1.checkoutBook(bookName, loggedInUser);
                this.show();
            }
            case 4 : {
                System.out.println("\nEnter the book title you want to return, careful of spelling: ");
                String bookName = reader.nextLine();
                library1.returnBook(bookName, loggedInUser);
                this.show();
            }
            case 5 : {
                System.out.println("\nEnter the movie title you want to checkout, careful of spelling: ");
                String movieName = reader.nextLine();
                library1.checkoutMovie(movieName, loggedInUser);
                this.show();
            }
            case 6 : {
                System.out.println("\nEnter the movie title you want to return, careful of spelling: ");
                String movieName = reader.nextLine();
                library1.returnBook(movieName, loggedInUser);
                this.show();
            }case 7 : {
                new DisplayInformation(null,null, loggedInUser.checkedOutItems, null);
                this.show();
            }case 8 : {
                loggedInUser = library1.logout();
                this.show();
            }case 9 : {
                System.out.println("\nThank you, come back soon!");
                System.exit(0);
            }case 10 : {
                new DisplayInformation(null, null, null, loggedInUser);
            }
        }

    }

}
