package default_methods;

interface Vehicle {

  void displaySpeed();

  default void displayBattery() {
    System.out.println("Battery info not available for this vehicle");
  }
}

class Car implements Vehicle {
  private int speed;

  Car(int speed) {
    this.speed = speed;
  }

  @Override
  public void displaySpeed() {
    System.out.println("Car speed: " + speed + " km/h");
  }
}

class ElectricVehicle implements Vehicle {
  private int speed;
  private int batteryPercent;

  ElectricVehicle(int speed, int batteryPercent) {
    this.speed = speed;
    this.batteryPercent = batteryPercent;
  }

  @Override
  public void displaySpeed() {
    System.out.println("EV speed: " + speed + " km/h");
  }

  @Override
  public void displayBattery() {
    System.out.println("Battery: " + batteryPercent + "%");
  }
}

public class SmartVehicleDashboard {

  public static void main(String[] args) {

    Vehicle car = new Car(60);
    Vehicle ev = new ElectricVehicle(80, 75);

    car.displaySpeed();
    car.displayBattery();

    ev.displaySpeed();
    ev.displayBattery();
  }
}
