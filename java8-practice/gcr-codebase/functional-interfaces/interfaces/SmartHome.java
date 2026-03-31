package interfaces;

interface SmartDevice {
  void turnOn();

  void turnOff();
}

class Light implements SmartDevice {

  @Override
  public void turnOn() {
    System.out.println("Light turned ON");
  }

  @Override
  public void turnOff() {
    System.out.println("Light turned OFF");

  }
}

class AC implements SmartDevice {

  @Override
  public void turnOn() {
    System.out.println("AC turned ON");
  }

  @Override
  public void turnOff() {
    System.out.println("AC turned OFF");
  }
}

class TV implements SmartDevice {

  @Override
  public void turnOn() {
    System.out.println("TV turned ON");
  }

  @Override
  public void turnOff() {
    System.out.println("TV turned OFF");
  }
}

public class SmartHome {

  public static void main(String[] args) {

    SmartDevice light = new Light();
    SmartDevice ac = new AC();
    SmartDevice tv = new TV();

    light.turnOn();
    ac.turnOn();
    tv.turnOn();

    light.turnOff();
    ac.turnOff();
    tv.turnOff();
  }
}
