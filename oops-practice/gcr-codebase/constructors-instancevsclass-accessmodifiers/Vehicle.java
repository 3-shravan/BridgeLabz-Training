public class Vehicle {
  private String ownerName;
  private String vehicleType;

  private static double registrationFee = 100.0;

  Vehicle(String ownerName, String vehicleType) {
    this.ownerName = ownerName;
    this.vehicleType = vehicleType;
  }

  void displayVehicleDetails() {
    System.out.println("Owner Name: " + ownerName);
    System.out.println("Vehicle Type: " + vehicleType);
    System.out.println("Registration Fee: " + registrationFee);
  }

  static void updateRegistrationFee(double newFee) {
    registrationFee = newFee;
  }

  public static void main(String[] args) {
    Vehicle vehicle1 = new Vehicle("Alice", "Car");
    Vehicle vehicle2 = new Vehicle("Bob", "Motorcycle");

    vehicle1.displayVehicleDetails();
    vehicle2.displayVehicleDetails();

    Vehicle.updateRegistrationFee(150.0);

    System.out.println("After updating registration fee:");

    vehicle1.displayVehicleDetails();
    vehicle2.displayVehicleDetails();
  }
}
