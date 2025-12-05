package com.pluralsight.models;

public class Vehicle {

    private int vin, mileage;
    private String make, model, sold;
    private double price;

    public Vehicle(int vin, String make, String model, int mileage, double price, String sold) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.price = price;
        this.sold = sold;
    }

    public int getVin() {
        return vin;
    }

    public int getMileage() {
        return mileage;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String getSold() {
        return sold;
    }

    @Override
    public String toString() {
        return "\t VIN: " + vin +
                "\n\t Mileage: " + mileage +
                "\n\t Make: " + make +
                "\n\t Model: " + model +
                "\n\t Price: " + price +
                "\n\t Sold: " + sold;
    }
}
