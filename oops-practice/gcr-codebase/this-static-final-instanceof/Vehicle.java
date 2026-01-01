
public class Vehicle {

  static double registrationFee = 100.0;

  private String ownerName;
  private String vehicleType;
  private final String registrationNumber;

  public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
    this.ownerName = ownerName;
    this.vehicleType = vehicleType;
    this.registrationNumber = registrationNumber;
  }

  public static void updateRegistrationFee(double newFee) {
    registrationFee = newFee;
  }

  public void displayDetails(Object obj) {
    if (obj instanceof Vehicle) {
      Vehicle vehicle = (Vehicle) obj;
      System.out.println("Owner Name: " + vehicle.ownerName);
      System.out.println("Vehicle Type: " + vehicle.vehicleType);
      System.out.println("Registration Number: " + vehicle.registrationNumber);
      System.out.println("Registration Fee: " + registrationFee);
    } else {
      System.out.println("Invalid vehicle object.");
    }
  }

  public static void main(String[] args) {
    Vehicle vehicle1 = new Vehicle("Honest raj", "Sedan", "ABC123");
    Vehicle vehicle2 = new Vehicle("Price danish", "SUV", "XYZ789");

    // Update registration fee
    Vehicle.updateRegistrationFee(150.0);

    // Display details if the object is an instance of Vehicle

    vehicle1.displayDetails(vehicle1);

    vehicle2.displayDetails(vehicle2);
  }

}
