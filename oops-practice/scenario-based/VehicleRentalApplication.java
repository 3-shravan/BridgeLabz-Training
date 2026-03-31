import java.util.ArrayList;
import java.util.List;

interface IRentable {
  double calculateRent(int days);
}

abstract class Vehicle implements IRentable {
  protected String make;
  protected String model;
  protected int year;
  protected int renterPerDay;

  Vehicle(String make, String model, int year, int renterPerDay) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.renterPerDay = renterPerDay;
  }

  abstract void displayInfo();

}

class Customer {
  String name;
  String driverLicenseNumber;

  Customer(String name, String driverLicenseNumber) {
    this.name = name;
    this.driverLicenseNumber = driverLicenseNumber;
  }
}

class Car extends Vehicle {
  private int seatCapacity;

  Car(String make, String model, int year, int seatCapacity, int renterPerDay) {
    super(make, model, year, renterPerDay);
    this.seatCapacity = seatCapacity;
  }

  @Override
  void displayInfo() {
    System.out.println("Car: " + make + " " + model + " (" + year + "), Seats: " + seatCapacity);
  }

  @Override
  public double calculateRent(int days) {
    double totalCost = renterPerDay * days;
    System.out.println("Total rental cost for " + days + " days: $" + totalCost);
    return totalCost;
  }
}

class Bike extends Vehicle {
  boolean hasCarrier;

  Bike(String make, String model, int year, boolean hasCarrier, int renterPerDay) {
    super(make, model, year, renterPerDay);
    this.hasCarrier = hasCarrier;
  }

  @Override
  void displayInfo() {
    System.out.println("Bike: " + make + " " + model + " (" + year + "), Carrier: " + (hasCarrier ? "Yes" : "No"));
  }

  @Override
  public double calculateRent(int days) {
    double totalCost = renterPerDay * days;
    System.out.println("Total rental cost for " + days + " days: $" + totalCost);
    return totalCost;
  }
}

class Truck extends Vehicle {
  int loadCapacity;

  Truck(String make, String model, int year, int loadCapacity, int renterPerDay) {
    super(make, model, year, renterPerDay);
    this.loadCapacity = loadCapacity;
  }

  @Override
  void displayInfo() {
    System.out.println("Truck: " + make + " " + model + " (" + year + "), Load Capacity: " + loadCapacity + " tons");
  }

  @Override
  public double calculateRent(int days) {
    double totalCost = renterPerDay * days;
    System.out.println("Total rental cost for " + days + " days: $" + totalCost);
    return totalCost;
  }
}

class RentalService {

  private List<Vehicle> vehicles = new ArrayList<>();

  void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
    System.out.println("Vehicle added: " + vehicle.make + " " + vehicle.model);
  }

  void viewAllVehicles() {
    if (vehicles.isEmpty()) {
      System.out.println("No vehicles available.");
      return;
    }
    for (Vehicle vehicle : vehicles) {
      vehicle.displayInfo();
    }
  }

  void updateRentalRate(String model, int newRate) {
    for (Vehicle v : vehicles) {
      if (v.model.equals(model)) {
        v.renterPerDay = newRate;
        System.out.println("Updated rental rate for " + v.make + " " + v.model + " to $" + newRate + " per day.");
        return;
      }
    }
  }

  void removeVehicle(String model) {
    vehicles.removeIf(vehicle -> vehicle.model.equals(model));
    System.out.println("Vehicle removed: " + model);
  }

  void calculateRentalCost(String model, int days) {
    for (Vehicle v : vehicles) {
      if (v.model.equals(model)) {
        v.calculateRent(days);
        return;
      }
    }
    System.out.println("Vehicle not found: " + model);
  }
}

public class VehicleRentalApplication {

  public static void main(String[] args) {
    RentalService rentalService = new RentalService();

    Vehicle car1 = new Car("Toyota", "Camry", 2020, 5, 50);
    Vehicle bike1 = new Bike("Yamaha", "FZ", 2019, true, 20);
    Vehicle truck1 = new Truck("Ford", "F-150", 2018, 3, 80);

    rentalService.addVehicle(car1);
    rentalService.addVehicle(bike1);
    rentalService.addVehicle(truck1);

    rentalService.viewAllVehicles();

    rentalService.calculateRentalCost("Camry", 3);
    rentalService.updateRentalRate("FZ", 25);
    rentalService.calculateRentalCost("FZ", 4);

    rentalService.removeVehicle("F-150");
    rentalService.viewAllVehicles();
  }

}
