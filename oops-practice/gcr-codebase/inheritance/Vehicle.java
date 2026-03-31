public class Vehicle {
  private int maxSpeed;
  private String model;

  Vehicle(int maxSpeed, String model) {
    this.maxSpeed = maxSpeed;
    this.model = model;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public String getModel() {
    return model;
  }

  void displayInfo() {
    System.out.println("Model: " + model);
    System.out.println("Max Speed: " + maxSpeed + " km/h");
  }

  public static void main(String[] args) {

    ElectricVehicle ev = new ElectricVehicle(120, "xx");
    PetrolVehicle pv = new PetrolVehicle(150, "yy");

    pv.displayInfo();
    pv.refuel();

    ev.displayInfo();
    ev.charge();
  }
}

interface Refuelable {
  void refuel();
}

class ElectricVehicle extends Vehicle {

  ElectricVehicle(int maxSpeed, String model) {
    super(maxSpeed, model);
  }

  void charge() {
    System.out.println("Charging electric vehicle.");
  }
}

class PetrolVehicle extends Vehicle implements Refuelable {

  PetrolVehicle(int maxSpeed, String model) {
    super(maxSpeed, model);
  }

  @Override
  public void refuel() {
    System.out.println("Refueling petrol vehicle.");
  }
}