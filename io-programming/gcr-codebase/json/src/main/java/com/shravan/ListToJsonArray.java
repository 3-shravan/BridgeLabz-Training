package com.shravan;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListToJsonArray {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", "Model 3"));
        cars.add(new Car("Toyota", "Camry"));
        cars.add(new Car("Honda", "Civic"));

        JSONArray array = new JSONArray();
        for (Car car : cars) {
            array.put(new JSONObject().put("brand", car.getBrand()).put("model", car.getModel()));
        }

        System.out.println(array.toString(2));
    }

    static class Car {
        private final String brand;
        private final String model;

        Car(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

    }
}
