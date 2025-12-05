package com.pluralsight.ui;

import com.pluralsight.utilities.ConsoleUtil;

public class HomeScreen {
    private final VehicleSearch vehicleSearch;

    public HomeScreen(VehicleSearch vehicleSearch){
        this.vehicleSearch = vehicleSearch;
    }

    public void displayHomeScreen(){
        boolean isRunning = true;

        while (isRunning){
            displayMenu();

            int userChoice = ConsoleUtil.getIntInRange("Enter option here: ", 0, 3);

            switch (userChoice){
                case 1 -> {
                    vehicleSearch.display();
                    break;
                }
                case 0 -> {
                    isRunning = false;
                    break;
                }
                default -> System.out.println("enter a valid input option...");
            }
        }
        exitProgram();
    }

    private void displayMenu(){
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("Select Option Based on Menu Number\n\n");
        System.out.println("1) Search For Vehicles");
        System.out.println("2) Add/Remove Vehicles");
        System.out.println("3) Sales/Leasing Vehicles");
        System.out.println("0) Close Program");
        System.out.println("\n\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }

    private void exitProgram(){
        ConsoleUtil.exitProgram();
    }
}
