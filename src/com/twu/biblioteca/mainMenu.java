package com.twu.biblioteca;

import java.util.Scanner;

public class mainMenu {
    public mainMenu(){
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
        System.out.println("2: Checkout book");
        System.out.println("3: Return book");
        System.out.println("4: Quit");
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
        validateMainMenuUserInput(userInput);
        return userInput;
    }


    private void validateMainMenuUserInput(int userInput){
        if (userInput < 1 || userInput > 4){
            userInput = getMainMenuUserInput("\nPlease enter a valid action number: ");
        }
    }

    private void executeAction(int action){
        Scanner reader = new Scanner(System.in);
        switch(action){
            case 1: {
                library.listBooks();
                this.show();
            }
            case 2: {
                System.out.println("\nEnter the book title you want to checkout, careful of spelling: ");
                String bookName = reader.nextLine();
                library.checkoutBook(bookName);
                this.show();
            }
            case 3: {
                System.out.println("\nEnter the book title you want to return, careful of spelling: ");
                String bookName = reader.nextLine();
                library.returnBook(bookName);
                this.show();
            }
            case 4: {
                System.out.println("\nThank you, come back soon!");
                System.exit(0);
            }
        }

    }


}
