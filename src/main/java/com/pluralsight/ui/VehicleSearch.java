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
            int userChoice = ConsoleUtil.getIntInRange("Select an option: ",0 , 7);

            switch (userChoice){
                case 1 -> searchPrice();
                case 2 -> searchMakeModel();
                case 3 -> searchMileage();
                case 4 -> searchYear();
                case 5 -> searchColor();
                case 6 -> searchVehicleType();
                case 7 -> availableVehicles();
                case 0 -> System.out.println("should return back to main menu...");
                default -> System.out.println("Please enter a valid input.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("1. Search Vehicles by Price Range");
        System.out.println("2. Search Vehicles by Make/Model");
        System.out.println("3. Search Vehicles by Mileage");
        System.out.println("4. Search Vehicles by Year Range");
        System.out.println("5. Search Vehicles by Color");
        System.out.println("6. Search Vehicles by Type");
        System.out.println("7. Get Available Vehicles");
        System.out.println("0. Back to main menu");
        System.out.print("Input choice here: ");
    }

    private void searchPrice(){
        System.out.println("Loading Search by Price...");

        double minPrice = ConsoleUtil.getDoubleFromUser("Enter minimum price: $");
        double maxPrice = ConsoleUtil.getDoubleFromUser("Enter maximum price: $");

        List<Vehicle> priceRange = vehicleDao.getVehiclesByPriceRange(minPrice, maxPrice);

        if (priceRange.isEmpty()){
            System.out.printf("\nNo vehicles within the price range of $%.2f - $%.2f", minPrice, maxPrice);
        }
        else {
            System.out.println("\nFound " + priceRange.size() + " vehicles!");
            System.out.println("\nVehicles");
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
            System.out.println("\nVehicles:");
            for (Vehicle vehicle : makeModel) {
                System.out.println(vehicle);
            }
        }
    }

    private void searchMileage(){
        System.out.println("Loading Search By Mileage");

        int minMileage = ConsoleUtil.getIntFromUser("Enter minimum mileage: ");
        int maxMileage = ConsoleUtil.getIntFromUser("Enter maximum mileage: ");

        List<Vehicle> milesRange = vehicleDao.getVehicleByMileage(minMileage, maxMileage);

        if (milesRange.isEmpty()){
            System.out.printf("\nNo vehicles with mileage between %d and %d", minMileage, maxMileage);
        }
        else {
            System.out.println("\nFound " + milesRange.size() + " vehicles!");
            System.out.println("\nVehicles");
            for (Vehicle vehicle : milesRange) {
                System.out.println(vehicle);
            }
        }
    }

    private void searchYear(){
        System.out.println("Loading Search By Year");

        int minYear = ConsoleUtil.getIntFromUser("Enter minimum year: ");
        int maxYear = ConsoleUtil.getIntFromUser("Enter maximum year: ");

        List<Vehicle> yearRange = vehicleDao.getVehicleByYearRange(minYear, maxYear);

        if (yearRange.isEmpty()){
            System.out.printf("\nNo vehicles made between %d and %d available", minYear, maxYear);
        }
        else {
            System.out.println("\nFound " + yearRange.size() + " vehicles!");
            System.out.println("\nVehicles");
            for (Vehicle vehicle : yearRange) {
                System.out.println(vehicle);
            }
        }
    }

    private void searchColor(){
        System.out.println("Loading Search By Color");

        String color = ConsoleUtil.getNonEmptyString("Enter color: ");

        List<Vehicle> colorList = vehicleDao.getVehicleByColor(color);

        if (colorList.isEmpty()){
            System.out.printf("\nNo more %s vehicles available!", color);
        }
        else {
            System.out.println("\nFound " + colorList.size() + " vehicles!");
            System.out.println("\nVehicles");
            for (Vehicle vehicle : colorList) {
                System.out.println(vehicle);
            }
        }
    }

    private void searchVehicleType(){
        System.out.println("Loading Search By Class Type");

        String type = ConsoleUtil.getNonEmptyString("Enter vehicle class type: ");

        List<Vehicle> vehicleType = vehicleDao.getVehicleByType(type);

        if (vehicleType.isEmpty()){
            System.out.printf("\nNo more %ss available!", type);
        }
        else {
            System.out.println("\nFound " + vehicleType.size() + " vehicles!");
            System.out.println("\nVehicles");
            for (Vehicle vehicle : vehicleType) {
                System.out.println(vehicle);
            }
        }
    }

    private void availableVehicles(){
        System.out.println("Loading available vehicles...");

        List<Vehicle> available = vehicleDao.getAvailableVehicles();

        if (available.isEmpty()){
            System.out.println("\nThere are no more vehicles available!");
        }
        else {
            System.out.println("\nThere are " + available.size() + " vehicles available!");
            System.out.println("\n\nVehicles:");
            for (Vehicle vehicle : available){
                System.out.println(vehicle);
            }
        }
    }

}
