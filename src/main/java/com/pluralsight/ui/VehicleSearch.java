package com.pluralsight.ui;

import com.pluralsight.data.VehicleDao;
import com.pluralsight.models.Vehicle;
import com.pluralsight.utilities.ConsoleUtil;

import java.util.List;

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
//                case 3 -> searchMileage();
//                case 4 -> availableVehicles();
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
        System.out.println("Loading Search by Price...");

        int minPrice = ConsoleUtil.getIntFromUser("Enter minimum price: $");
        int maxPrice = ConsoleUtil.getIntFromUser("Enter maximum price: $");

        List<Vehicle> priceRange = vehicleDao.getVehiclesByPriceRange(minPrice, maxPrice);

        if (priceRange.isEmpty()){
            System.out.printf("\nNo vehicles within the price range of $d - $%d", minPrice, maxPrice);
        }
        else {
            System.out.println("\nFound " + priceRange.size() + " vehicles!");
            System.out.println("\n\nVehicles");
            for (Vehicle vehicle : priceRange) {
                System.out.println(vehicle);
            }
        }
    }

    private void searchMakeModel(){
        System.out.println("Loading Search By Make & Model...");

        String vehicleMake = ConsoleUtil.getNonEmptyString("Enter vehicle make: ");
        String vehicleModel = ConsoleUtil.getNonEmptyString("Enter vehicle model: ");

        List<Vehicle> makeModel = vehicleDao.getVehicleByMakeModel(vehicleMake, vehicleModel);

        if (makeModel.isEmpty()) {
            System.out.println("\nNo vehicles in the inventory of Make: " + vehicleMake + " OR Model : " + vehicleModel);
        }
        else {
            System.out.println("\nFound " + makeModel.size() + " vehicles that match!");
            System.out.println("\n\n");
            for (Vehicle vehicle : makeModel) {
                System.out.println(vehicle);
            }
        }
    }

    private void searchByMileage(){
        System.out.println("Loading Search By Mileage");

    }

}
