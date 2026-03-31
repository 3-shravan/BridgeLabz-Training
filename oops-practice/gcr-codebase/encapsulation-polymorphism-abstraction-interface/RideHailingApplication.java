import java.util.ArrayList;
import java.util.List;

/*
 * Interface defining GPS-related behavior
 */
interface GPS {
  String getCurrentLocation();

  void updateLocation(String newLocation);
}

/*
 * Abstract Vehicle class
 * Represents common ride-hailing vehicle properties
 */
abstract class Vehicle {

  // Encapsulation: private fields
  private final int vehicleId; // immutable
  private String driverName;
  protected double ratePerKm;

  // Secured location data
  private String currentLocation = "Unknown";

  public Vehicle(int vehicleId, String driverName, double ratePerKm) {
    this.vehicleId = vehicleId;
    setDriverName(driverName);
    setRatePerKm(ratePerKm);
  }

  // Abstract fare calculation
  public abstract double calculateFare(double distance);

  // Concrete method
  public void getVehicleDetails(double fare) {
    System.out.println("Vehicle ID     : " + vehicleId);
    System.out.println("Driver Name    : " + driverName);
    System.out.println("Rate per Km    : ₹" + ratePerKm);
    System.out.println("Current Fare   : ₹" + fare);
    System.out.println("--------------------------------");
  }

  // Encapsulation with validation
  public final void setDriverName(String driverName) {
    if (driverName == null || driverName.trim().isEmpty()) {
      throw new IllegalArgumentException("Driver name cannot be empty");
    }
    this.driverName = driverName;
  }

  protected final void setRatePerKm(double ratePerKm) {
    if (ratePerKm <= 0) {
      throw new IllegalArgumentException("Rate per km must be positive");
    }
    this.ratePerKm = ratePerKm;
  }

  // Protected access for GPS behavior
  protected String getLocation() {
    return currentLocation;
  }

  protected void setLocation(String location) {
    this.currentLocation = location;
  }
}

/*
 * Car implementation
 */
class Car extends Vehicle implements GPS {

  public Car(int id, String driver, double rate) {
    super(id, driver, rate);
  }

  @Override
  public double calculateFare(double distance) {
    return distance * ratePerKm; // standard fare
  }

  @Override
  public String getCurrentLocation() {
    return getLocation();
  }

  @Override
  public void updateLocation(String newLocation) {
    setLocation(newLocation);
  }
}

/*
 * Bike implementation
 */
class Bike extends Vehicle implements GPS {

  public Bike(int id, String driver, double rate) {
    super(id, driver, rate);
  }

  @Override
  public double calculateFare(double distance) {
    return distance * ratePerKm * 0.8; 
  }

  @Override
  public String getCurrentLocation() {
    return getLocation();
  }

  @Override
  public void updateLocation(String newLocation) {
    setLocation(newLocation);
  }
}

/*
 * Auto implementation
 */
class Auto extends Vehicle implements GPS {

  public Auto(int id, String driver, double rate) {
    super(id, driver, rate);
  }

  @Override
  public double calculateFare(double distance) {
    return (distance * ratePerKm) + 20; 
  }

  @Override
  public String getCurrentLocation() {
    return getLocation();
  }

  @Override
  public void updateLocation(String newLocation) {
    setLocation(newLocation);
  }
}

/*
 * Main class
 * Demonstrates polymorphism
 */
public class RideHailingApplication {

  public static void main(String[] args) {

    List<Vehicle> rides = new ArrayList<>();

    Vehicle v1 = new Car(1, "Shravan", 15);
    Vehicle v2 = new Bike(2, "Amit", 10);
    Vehicle v3 = new Auto(3, "Ravi", 12);

    rides.add(v1);
    rides.add(v2);
    rides.add(v3);

    processRides(rides, 10);
  }

  // Polymorphic fare calculation
  public static void processRides(List<Vehicle> vehicles, double distance) {

    for (Vehicle vehicle : vehicles) {

      double fare = vehicle.calculateFare(distance);

      if (vehicle instanceof GPS) {
        GPS gpsVehicle = (GPS) vehicle;
        gpsVehicle.updateLocation("MG Road");
        System.out.println("Current Location: " + gpsVehicle.getCurrentLocation());
      }

      vehicle.getVehicleDetails(fare);
    }
  }
}
