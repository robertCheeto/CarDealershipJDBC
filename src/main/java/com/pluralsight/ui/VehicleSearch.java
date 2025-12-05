package com.pluralsight.ui;

import com.pluralsight.data.VehicleDao;
import com.pluralsight.utilities.ConsoleUtil;

public class VehicleSearch {
    private final VehicleDao vehicleDao;

    public VehicleSearch(VehicleDao vehicleDao){
        this.vehicleDao = vehicleDao;
    }

    public void display(){
        boolean isRunning = true;
        while (isRunning) {
            displayMenu();
            int userChoice = ConsoleUtil.getIntInRange("Select an option: ",0 , 4);

            switch (userChoice){
                case 1 -> searchPrice();
                case 2 -> searchMakeModel();
                case 3 -> searchMileage();
                case 4 -> availableVehicles();
                case 0 -> System.out.println("should return back to main menu...");
                default -> System.out.println("Please enter a valid input.");
            }

        }
    }

    private void displayMenu() {
        System.out.println("1. Search Vehicles by Price Range");
        System.out.println("2. Search Vehicles by Make/Model");
        System.out.println("3. Search Vehicles by Mileage");
        System.out.println("4. Get Available Vehicles");
        System.out.println("0. Back to main menu");
        System.out.print("Input choice here: ");
    }

    private void searchPrice(){


    }


}
