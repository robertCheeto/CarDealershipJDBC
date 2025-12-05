package com.pluralsight.data;

import com.pluralsight.models.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private final DataManager dataManager;

    public VehicleDao(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public List<Vehicle> getVehiclesByPriceRange(double minPrice, double maxPrice){
        List<Vehicle> vehiclesByPrice = new ArrayList<>();

        String query = "SELECT" +
                "VIN, make, model, mileage, price, sold " +
                "FROM vehicles " +
                "WHERE price BETWEEN ? AND ?" +
                "ORDER BY PRICE;";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, minPrice);
                statement.setDouble(2, maxPrice);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int VIN = resultSet.getInt("VIN");
                        String make = resultSet.getString("make");
                        String model = resultSet.getString("model");
                        int mileage = resultSet.getInt("mileage");
                        double price = resultSet.getDouble("price");
                        String sold = resultSet.getString("sold");

                        vehiclesByPrice.add(new Vehicle(VIN, make, model, mileage, price, sold));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles within price range: " + e.getMessage());
        }
        return vehiclesByPrice;
    }

    public List<Vehicle> getVehicleByMakeModel (String vMake, String vModel){
        List<Vehicle> vehiclesByMakeModel = new ArrayList<>();

        String query = "SELECT " +
                "vin, make, model, mileage, price, sold" +
                "FROM " +
                " vehicles " +
                "WHERE make LIKE ? AND model LIKE ? " +
                "ORDER BY make";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "%" + vMake + "%");
                statement.setString(2, "%" + vModel + "%");

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int VIN = resultSet.getInt("VIN");
                        String make = resultSet.getString("make");
                        String model = resultSet.getString("model");
                        int mileage = resultSet.getInt("mileage");
                        double price = resultSet.getDouble("price");
                        String sold = resultSet.getString("sold");

                        vehiclesByMakeModel.add(new Vehicle(VIN, make, model, mileage, price, sold));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles within price range: " + e.getMessage());
        }
        return  vehiclesByMakeModel;
    }

    public List<Vehicle> getVehicleByMileage(double minMiles, double maxMiles){
        List<Vehicle> vehiclesByMileage = new ArrayList<>();

        String query = "SELECT " +
                "vin, make, model, mileage, price, sold " +
                "FROM " +
                "vehicles " +
                "WHERE mileage BETWEEN ? AND ? " +
                "ORDER BY mileage;";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, minMiles);
                statement.setDouble(2, maxMiles);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int VIN = resultSet.getInt("VIN");
                        String make = resultSet.getString("make");
                        String model = resultSet.getString("model");
                        int mileage = resultSet.getInt("mileage");
                        double price = resultSet.getDouble("price");
                        String sold = resultSet.getString("sold");

                        vehiclesByMileage.add(new Vehicle(VIN, make, model, mileage, price, sold));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles within price range: " + e.getMessage());
        }
        return vehiclesByMileage;
    }

    public List<Vehicle> getAvailableVehicles(){
        List<Vehicle> availableVehicles = new ArrayList<>();

        String query = "SELECT " +
                "vin, make, model, mileage, price, sold " +
                "FROM " +
                "vehicles " +
                "WHERE sold = \"n\"";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int VIN = resultSet.getInt("VIN");
                        String make = resultSet.getString("make");
                        String model = resultSet.getString("model");
                        int mileage = resultSet.getInt("mileage");
                        double price = resultSet.getDouble("price");
                        String sold = resultSet.getString("sold");

                        availableVehicles.add(new Vehicle(VIN, make, model, mileage, price, sold));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles within price range: " + e.getMessage());
        }
        return availableVehicles;
    }

}
