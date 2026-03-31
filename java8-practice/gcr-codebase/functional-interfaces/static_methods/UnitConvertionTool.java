package static_methods;

interface UnitConverter {
  static double kmToMiles(double km) {
    return km * 0.621371;
  }

  static double kgToPounds(double kg) {
    return kg * 2.20462;
  }
}

public class UnitConvertionTool {
  public static void main(String[] args) {
    double km = 10.0;
    double miles = UnitConverter.kmToMiles(km);
    System.out.println(km + " kilometers is equal to " + miles + " miles.");

    double kg = 5.0;
    double pounds = UnitConverter.kgToPounds(kg);
    System.out.println(kg + " kilograms is equal to " + pounds + " pounds.");
  }
}