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

        String query = "SELECT " +
                "vin, year, make, model, vehicle_type, color, odometer, price, sold " +
                "FROM vehicles " +
                "WHERE price BETWEEN ? AND ? " +
                "ORDER BY PRICE;";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, minPrice);
                statement.setDouble(2, maxPrice);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String vin = resultSet.getString("vin");
                        int year = resultSet.getInt("year");
                        String make = resultSet.getString("make");
                        String model = resultSet.getString("model");
                        String vehicleType = resultSet.getString("vehicle_type");
                        String color = resultSet.getString("color");
                        int odometer = resultSet.getInt("odometer");
                        double price = resultSet.getDouble("price");
                        int sold = resultSet.getInt("sold");

                        vehiclesByPrice.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold));
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
                "vin, year, make, model, vehicle_type, color, odometer, price, sold " +
                "FROM " +
                "vehicles " +
                "WHERE make LIKE ? OR model LIKE ? " +
                "ORDER BY make";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "%" + vMake + "%");
                statement.setString(2, "%" + vModel + "%");

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String vin = resultSet.getString("vin");
                        int year = resultSet.getInt("year");
                        String make = resultSet.getString("make");
                        String model = resultSet.getString("model");
                        String vehicleType = resultSet.getString("vehicle_type");
                        String color = resultSet.getString("color");
                        int odometer = resultSet.getInt("odometer");
                        double price = resultSet.getDouble("price");
                        int sold = resultSet.getInt("sold");

                        vehiclesByMakeModel.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles from Make and Model Search: " + e.getMessage());
        }
        return  vehiclesByMakeModel;
    }

    public List<Vehicle> getVehicleByMileage(int minMiles, int maxMiles){
        List<Vehicle> vehiclesByMileage = new ArrayList<>();

        String query = "SELECT " +
                "vin, year, make, model, vehicle_type, color, odometer, price, sold " +
                "FROM " +
                "vehicles " +
                "WHERE odometer BETWEEN ? AND ? " +
                "ORDER BY odometer;";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, minMiles);
                statement.setDouble(2, maxMiles);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String vin = resultSet.getString("vin");
                        int year = resultSet.getInt("year");
                        String make = resultSet.getString("make");
                        String model = resultSet.getString("model");
                        String vehicleType = resultSet.getString("vehicle_type");
                        String color = resultSet.getString("color");
                        int odometer = resultSet.getInt("odometer");
                        double price = resultSet.getDouble("price");
                        int sold = resultSet.getInt("sold");

                        vehiclesByMileage.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles within Mileage range: " + e.getMessage());
        }
        return vehiclesByMileage;
    }

    public List<Vehicle> getVehicleByYearRange(int minYear, int maxYear){
        List<Vehicle> vehiclesByYear = new ArrayList<>();

        String query = "SELECT " +
                "vin, year, make, model, vehicle_type, color, odometer, price, sold " +
                "FROM " +
                "vehicles " +
                "WHERE year BETWEEN ? AND ? " +
                "ORDER BY year DESC";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, minYear);
                statement.setDouble(2, maxYear);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String vin = resultSet.getString("vin");
                        int year = resultSet.getInt("year");
                        String make = resultSet.getString("make");
                        String model = resultSet.getString("model");
                        String vehicleType = resultSet.getString("vehicle_type");
                        String color = resultSet.getString("color");
                        int odometer = resultSet.getInt("odometer");
                        double price = resultSet.getDouble("price");
                        int sold = resultSet.getInt("sold");

                        vehiclesByYear.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles within Mileage range: " + e.getMessage());
        }
        return vehiclesByYear;
    }

    public List<Vehicle> getVehicleByColor(String vColor){
        List<Vehicle> vehiclesByColor = new ArrayList<>();

        String query = "SELECT " +
                "vin, year, make, model, vehicle_type, color, odometer, price, sold " +
                " FROM " +
                "vehicles " +
                " WHERE color LIKE ? ";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "%" + vColor + "%");

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String vin = resultSet.getString("vin");
                        int year = resultSet.getInt("year");
                        String make = resultSet.getString("make");
                        String model = resultSet.getString("model");
                        String vehicleType = resultSet.getString("vehicle_type");
                        String color = resultSet.getString("color");
                        int odometer = resultSet.getInt("odometer");
                        double price = resultSet.getDouble("price");
                        int sold = resultSet.getInt("sold");

                        vehiclesByColor.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles from Color Search: " + e.getMessage());
        }
        return  vehiclesByColor;
    }

    public List<Vehicle> getVehicleByType(String vType){
        List<Vehicle> vehiclesByType = new ArrayList<>();

        String query = "SELECT " +
                "vin, year, make, model, vehicle_type, color, odometer, price, sold " +
                " FROM " +
                "vehicles " +
                " WHERE vehicle_type LIKE ? ";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "%" + vType + "%");

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String vin = resultSet.getString("vin");
                        int year = resultSet.getInt("year");
                        String make = resultSet.getString("make");
                        String model = resultSet.getString("model");
                        String vehicleType = resultSet.getString("vehicle_type");
                        String color = resultSet.getString("color");
                        int odometer = resultSet.getInt("odometer");
                        double price = resultSet.getDouble("price");
                        int sold = resultSet.getInt("sold");

                        vehiclesByType.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles from Color Search: " + e.getMessage());
        }
        return  vehiclesByType;
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
                        String vin = resultSet.getString("vin");
                        int year = resultSet.getInt("year");
                        String make = resultSet.getString("make");
                        String model = resultSet.getString("model");
                        String vehicleType = resultSet.getString("vehicle_type");
                        String color = resultSet.getString("color");
                        int odometer = resultSet.getInt("odometer");
                        double price = resultSet.getDouble("price");
                        int sold = resultSet.getInt("sold");

                        availableVehicles.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Available Vehicles: " + e.getMessage());
        }
        return availableVehicles;
    }

}
