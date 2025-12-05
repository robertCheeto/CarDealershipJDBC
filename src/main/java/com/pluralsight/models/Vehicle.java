package com.pluralsight.models;

public class Vehicle {

    private int year, odometer, sold;
    private String vin, make, model, vehicleType, color;
    private double price;

    public Vehicle(String vin, int year, String make, String model, String vehicleType, String color,
                   int odometer, double price, int sold) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
        this.sold = sold;
    }

    public int getYear() {
        return year;
    }

    public int getOdometer() {
        return odometer;
    }

    public int getSold() {
        return sold;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VIN: ").append(vin).append("\tYear: ").append(year).append("\tMake: ").append(make);
        sb.append("\tModel: ").append(model).append("\tVehicle Type: ").append(vehicleType).append("\tColor: ");
        sb.append(color).append("\tOdometer: ").append(odometer).append("\tPrice: $").append(price).append("Sold: ").append(sold);
        return sb.toString();
    }
}
