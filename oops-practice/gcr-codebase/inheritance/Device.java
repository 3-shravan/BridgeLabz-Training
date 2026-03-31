public class Device {
  String deviceId;
  String status; // ON / OFF

  Device(String deviceId, String status) {
    this.deviceId = deviceId;
    this.status = status;
  }

  void displayStatus() {
    System.out.println("Device ID: " + deviceId);
    System.out.println("Status: " + status);
  }

  public static void main(String[] args) {

    Thermostat thermostat = new Thermostat("T1001", "ON", 22.5);
    thermostat.displayStatus();
  }
}

class Thermostat extends Device {
  double temperatureSetting;

  Thermostat(String deviceId, String status, double temperatureSetting) {
    super(deviceId, status);
    this.temperatureSetting = temperatureSetting;
  }

  @Override
  void displayStatus() {
    super.displayStatus();
    System.out.println("Temperature Setting  : " + temperatureSetting + "°C");
  }
}
