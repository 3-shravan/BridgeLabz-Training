public class VehicleAndTransportSystem {
  private int maxSpeed;
  private String fuelType;

  public VehicleAndTransportSystem(int maxSpeed, String fuelType) {
    this.maxSpeed = maxSpeed;
    this.fuelType = fuelType;
  }

  void displayInfo() {
    System.out.println("Max Speed: " + maxSpeed + " km/h");
    System.out.println("Fuel Type: " + fuelType);
  }

  public static void main(String[] args) {
    VehicleAndTransportSystem myCar = new Car(220, "Petrol", 4);
    VehicleAndTransportSystem myTruck = new Truck(180, "Diesel", 15);
    VehicleAndTransportSystem myMotorcycle = new Motorcycle(200, "Petrol", 6);
    myCar.displayInfo();
    System.out.println();
    myTruck.displayInfo();
    System.out.println();
    myMotorcycle.displayInfo();

  }
}

class Car extends VehicleAndTransportSystem {
  private int numberOfDoors;

  public Car(int maxSpeed, String fuelType, int numberOfDoors) {
    super(maxSpeed, fuelType);
    this.numberOfDoors = numberOfDoors;
  }

  @Override
  void displayInfo() {
    super.displayInfo();
    System.out.println("Number of Doors: " + numberOfDoors);
  }
}

class Truck extends VehicleAndTransportSystem {
  private int loadCapacity;

  public Truck(int maxSpeed, String fuelType, int loadCapacity) {
    super(maxSpeed, fuelType);
    this.loadCapacity = loadCapacity;
  }

  @Override
  void displayInfo() {
    super.displayInfo();
    System.out.println("Load Capacity: " + loadCapacity + " tons");
  }
}

class Motorcycle extends VehicleAndTransportSystem {
  private int gears;

  public Motorcycle(int maxSpeed, String fuelType, int gears) {
    super(maxSpeed, fuelType);
    this.gears = gears;
  }

  @Override
  void displayInfo() {
    super.displayInfo();
    System.out.println("Gears: " + gears);
  }
}