package com.shravan;

import org.json.JSONObject;

public class Car {
    private final String brand;
    private final String model;
    private final int year;
    private final double price;

    public Car(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public static void main(String[] args) {
        Car car = new Car("Tesla", "Model 3", 2024, 49999.99);
        JSONObject carJson = new JSONObject(car);

        System.out.println(carJson.toString(2));
    }
}