@FunctionalInterface
interface LightAction {
  void activate();
}

class SmartLight {

  public void triggerLight(String trigger, LightAction action) {
    System.out.println("Trigger detected: " + trigger);
    action.activate();
  }
}

public class SmartHomeLighting {

  public static void main(String[] args) {

    SmartLight light = new SmartLight();

    // Motion detected
    light.triggerLight("Motion Sensor", () -> System.out.println("Lights ON at 100% brightness"));

    // Time-based trigger (night)
    light.triggerLight("Night Time", () -> System.out.println("Warm lights ON at 30% brightness"));

    // Voice command
    light.triggerLight("Voice Command", () -> System.out.println("Party mode activated RGB lights ON"));
  }
}
