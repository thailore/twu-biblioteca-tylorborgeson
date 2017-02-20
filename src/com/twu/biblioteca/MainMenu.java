package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    public static Library library1;

    public static final ArrayList<Integer> userOptions = new ArrayList<Integer>(){{
        add (1);
        add (2);
        add (3);
        add (4);
        add (5);
    }};


    public MainMenu(Library library){
        library1 = library;
        this.welcomeMessage();
        this.show();
    }

    private void welcomeMessage(){
        System.out.println("Welcome to the Bangalore Public Library Console!");
    }

    private void show(){
        System.out.println("LIBRARY MAIN MENU");
        System.out.println("Available Actions:");
        System.out.println("1: List Available Books");
        System.out.println("2: List Available Movies");
        System.out.println("3: Checkout book");
        System.out.println("4: Return book");
        System.out.println("5: Quit");
        route();

    }

    private void route(){
        int action = getMainMenuUserInput("What would you like to do? Please enter action number:  ");
        this.executeAction(action);
    }

    private int getMainMenuUserInput(String prompt){
        Scanner reader = new Scanner(System.in);
        System.out.println(prompt);
        int userInput = reader.nextInt();
        boolean validInput = validMainMenuUserInput(userInput);
        if (validInput) {
            return userInput;
        }
        userInput = getMainMenuUserInput("\nPlease enter a valid action number: ");
        return userInput;
    }


    private boolean validMainMenuUserInput(int userInput){
        if (!userOptions.contains(userInput)){
            return false;
        }
        return true;
    }

    private void executeAction(int action){
        Scanner reader = new Scanner(System.in);
        switch(action){
            case 1: {
                new DisplayInformation(library1.bookCatalogAndAvailability, null);
                this.show();
            }
            case 2: {
                new DisplayInformation(null, library1.movieCatalogAndAvailability);
                this.show();
            }
            case 3: {
                System.out.println("\nEnter the book title you want to checkout, careful of spelling: ");
                String bookName = reader.nextLine();
                library1.checkoutBook(bookName);
                this.show();
            }
            case 4: {
                System.out.println("\nEnter the book title you want to return, careful of spelling: ");
                String bookName = reader.nextLine();
                library1.returnBook(bookName);
                this.show();
            }
            case 5: {
                System.out.println("\nThank you, come back soon!");
                System.exit(0);
            }
        }

    }


}
