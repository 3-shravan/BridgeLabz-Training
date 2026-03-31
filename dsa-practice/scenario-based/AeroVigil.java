import java.util.Scanner;

class InvalidFlightException extends Exception {
  public InvalidFlightException(String message) {
    super(message);
  }
}

class FlightUtil {

  public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
    String regex = "^FL-\\d{4}$";
    if (flightNumber.matches(regex)) {
      return true;
    } else {
      throw new InvalidFlightException("The flight number " + flightNumber + "id invalid.");
    }
  }

  public boolean validateFlightName(String flightName) throws InvalidFlightException {
    String[] FLIGHTS = { "SpiceJet", "Vistara", "IndiGo", "Air Arabia" };
    boolean found = false;
    for (String flight : FLIGHTS) {
      if (flight.equals(flightName)) {
        found = true;
        break;
      }
    }
    if (found) {
      return true;
    } else {
      throw new InvalidFlightException("The flight name " + flightName + " is invalid.");
    }
  }

  private int getMaxCapacity(String flightName) {
    return switch (flightName) {
      case "SpiceJet" -> 396;
      case "Vistara" -> 615;
      case "IndiGo" -> 230;
      case "Air Arabia" -> 130;
      default -> 0;
    };
  }

  public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
    int maxCapacity = getMaxCapacity(flightName);
    if (passengerCount <= 0 || passengerCount > maxCapacity) {
      throw new InvalidFlightException("PassengerCount" + passengerCount + " is  invalid for " + flightName);
    }
    return true;
  }

  private int getFuelTankCapacity(String flightName) {
    return switch (flightName) {
      case "SpiceJet" -> 200000;
      case "Vistara" -> 300000;
      case "IndiGo" -> 250000;
      case "Air Arabia" -> 150000;
      default -> 0;
    };
  }

  public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
    if (currentFuelLevel < 0 || currentFuelLevel > getFuelTankCapacity(flightName)) {
      throw new InvalidFlightException(" Invalid fuel level for " + flightName);
    }
    return getFuelTankCapacity(flightName) - currentFuelLevel;
  }
}

class UserInterface {

  public static void main(String[] args) {
    FlightUtil flightUtil = new FlightUtil();
    Scanner scanner = new Scanner(System.in);
    System.out
        .println("Enter flight details in the format <FlightNumber>:<FlightName>:<PassengerCount>:<CurrentFuelLevel>");
    String input = scanner.nextLine();
    try {
      String[] details = input.split(":");
      String flightNumber = details[0];
      String flightName = details[1];
      int passengerCount = Integer.parseInt(details[2]);
      double currentFuelLevel = Double.parseDouble(details[3]);

      if (flightUtil.validateFlightNumber(flightNumber) &&
          flightUtil.validateFlightName(flightName) &&
          flightUtil.validatePassengerCount(passengerCount, flightName)) {
        double fuelToFill = flightUtil.calculateFuelToFillTank(flightName, currentFuelLevel);
        System.out.println("Fuel needed to fill the tank: " + fuelToFill + " liters");
      }
    } catch (InvalidFlightException e) {
      System.out.println(e.getMessage());
    }
    scanner.close();
  }
}
