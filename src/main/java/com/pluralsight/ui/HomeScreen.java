package com.pluralsight.ui;

import java.util.Scanner;

public class HomeScreen {

    public void displayHomeScreen(){
        boolean isRunning = true;
        Scanner keyboard = new Scanner(System.in);

        while (isRunning){
            displayMenu();

            int userChoice = keyboard.nextInt();
            keyboard.nextLine();

            switch (userChoice){
                case 1 -> System.out.println("hehe");
                default -> System.out.println("enter a valid input option");
            }
        }
    }

    private void displayMenu(){
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("Select Option Based on Menu Number\n\n");
        System.out.println("1) Search For Vehicles");
        System.out.println("2) Add/Remove Vehicles");
        System.out.println("3) Sales/Leasing Vehicles");
        System.out.println("99) Close Program");
        System.out.println("\n\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.print("Enter option here: ");
    }
}
