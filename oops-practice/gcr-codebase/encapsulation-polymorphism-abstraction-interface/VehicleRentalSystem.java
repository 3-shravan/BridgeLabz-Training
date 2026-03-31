import java.util.ArrayList;
import java.util.List;

interface Insurable {
  double calculateInsurance();

  String getInsuranceDetails();
}

abstract class Vehicle {
  private final String vehicleNumber;
  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  protected double rentalRate;

  public double getRentalRate() {
    return rentalRate;
  }

  public void setRentalRate(double rentalRate) {
    this.rentalRate = rentalRate;
  }

  private String insurancePolicyNumber;

  public String getInsurancePolicyNumber() {
    return insurancePolicyNumber;
  }

  public void setInsurancePolicyNumber(String insurancePolicyNumber) {
    this.insurancePolicyNumber = insurancePolicyNumber;
  }

  public Vehicle(String vehicleNumber, String type, double rentalRate) {
    this.vehicleNumber = vehicleNumber;
    setType(type);
    setRentalRate(rentalRate);
  }

  abstract double calculateRentalCost(int days);

  // Concrete method
  public void displayDetails(double rentalCost, double insuranceCost) {
    System.out.println("Vehicle Number : " + vehicleNumber);
    System.out.println("Vehicle Type   : " + type);
    System.out.println("Rental Cost    : ₹" + rentalCost);
    System.out.println("Insurance Cost : ₹" + insuranceCost);
  }
}

class Car extends Vehicle implements Insurable {
  public Car(String vehicleNumber, double rentalRate, String policyNumber) {
    super(vehicleNumber, "Car", rentalRate);
    setInsurancePolicyNumber(policyNumber);
  }

  @Override
  double calculateRentalCost(int days) {
    return getRentalRate() * days;
  }

  @Override
  public double calculateInsurance() {
    return rentalRate * 0.05;
  }

  @Override
  public String getInsuranceDetails() {
    return "Car Insurance (5%) | Policy: " + getInsurancePolicyNumber();
  }
}

class Bike extends Vehicle implements Insurable {
  public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
    super(vehicleNumber, "Bike", rentalRate);
    setInsurancePolicyNumber(policyNumber);
  }

  @Override
  double calculateRentalCost(int days) {
    return getRentalRate() * days;
  }

  @Override
  public double calculateInsurance() {
    return rentalRate * 0.03;
  }

  @Override
  public String getInsuranceDetails() {
    return "Bike Insurance (3%) | Policy: " + getInsurancePolicyNumber();
  }
}

class Truck extends Vehicle implements Insurable {
  public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
    super(vehicleNumber, "Truck", rentalRate);
    setInsurancePolicyNumber(policyNumber);
  }

  @Override
  double calculateRentalCost(int days) {
    return getRentalRate() * days;
  }

  @Override
  public double calculateInsurance() {
    return rentalRate * 0.07;
  }

  @Override
  public String getInsuranceDetails() {
    return "Truck Insurance (7%) | Policy: " + getInsurancePolicyNumber();
  }
}

public class VehicleRentalSystem {

  public static void main(String[] args) {
    List<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Car("CAR123", 1500, "CAR001"));
    vehicles.add(new Bike("BIKE456", 500, "BIKE002"));
    vehicles.add(new Truck("TRUCK789", 3000, "TRUCK003"));

    processRentals(vehicles, 5);
  }

  private static void processRentals(List<Vehicle> vehicles, int days) {
    for (Vehicle vehicle : vehicles) {
      double rentalCost = vehicle.calculateRentalCost(days);
      double insuranceCost = 0;
      if (vehicle instanceof Insurable) {
        Insurable insurableVehicle = (Insurable) vehicle;
        insuranceCost = insurableVehicle.calculateInsurance();
        System.out.println(insurableVehicle.getInsuranceDetails());
      }
      vehicle.displayDetails(rentalCost, insuranceCost);
    }
  }

}
