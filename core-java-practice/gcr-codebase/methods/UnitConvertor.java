
import java.util.Scanner;

public class UnitConvertor {
  private static final double KM_TO_MILES = 0.621371;
  private static final double MILES_TO_KM = 1.60934;
  private static final double METERS_TO_FEET = 3.28084;
  private static final double FEET_TO_METERS = 0.3048;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Unit Convertor Utility");
    System.out.println("1. Convert Kilometers to Miles");
    System.out.println("2. Convert Miles to Kilometers");
    System.out.println("3. Convert Meters to Feet");
    System.out.println("4. Convert Feet to Meters");
    System.out.print("Choose an option (1-4): ");
    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        System.out.print("Enter kilometers: ");
        double km = scanner.nextDouble();
        double miles = convertKmToMiles(km);
        System.out.println(km + " km = " + miles + " miles");
        break;

      case 2:
        System.out.print("Enter miles: ");
        double milesInput = scanner.nextDouble();
        double kilometers = convertMilesToKm(milesInput);
        System.out.println(milesInput + " miles = " + kilometers + " km");
        break;

      case 3:
        System.out.print("Enter meters: ");
        double meters = scanner.nextDouble();
        double feet = convertMetersToFeet(meters);
        System.out.println(meters + " meters = " + feet + " feet");
        break;

      case 4:
        System.out.print("Enter feet: ");
        double feetInput = scanner.nextDouble();
        double metersConverted = convertFeetToMeters(feetInput);
        System.out.println(feetInput + " feet = " + metersConverted + " meters");
        break;

      default:
        System.out.println("Invalid option!");
    }

    scanner.close();
  }

  public static double convertKmToMiles(double km) {
    return km * KM_TO_MILES;
  }

  public static double convertMilesToKm(double miles) {
    return miles * MILES_TO_KM;
  }

  public static double convertMetersToFeet(double meters) {
    return meters * METERS_TO_FEET;
  }

  public static double convertFeetToMeters(double feet) {
    return feet * FEET_TO_METERS;
  }
}
