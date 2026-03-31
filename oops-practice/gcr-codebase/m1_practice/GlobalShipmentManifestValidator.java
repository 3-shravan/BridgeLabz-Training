import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class GlobalShipmentManifestValidator {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++) {

      String input = sc.nextLine();
      String[] splittedInput = input.split("\\|", -1);

      if (splittedInput.length != 5) {
        System.out.println("NON-COMPLIANT RECORD");
        continue;
      }

      boolean validated = true;

      if (!validateShipmentCode(splittedInput[0]))
        validated = false;
      if (!validateShipmentDate(splittedInput[1]))
        validated = false;
      if (!validateMode(splittedInput[2]))
        validated = false;
      if (!validateWeight(splittedInput[3]))
        validated = false;
      if (!validateStatus(splittedInput[4]))
        validated = false;

      if (validated)
        System.out.println("COMPLIANT RECORD");
      else
        System.out.println("NON-COMPLIANT RECORD");

    }
    sc.close();
  }

  private static boolean validateStatus(String status) {
    return status.matches("DELIVERED|CANCELLED|IN_TRANSIT");
  }

  private static boolean validateWeight(String weightString) {
    try {
      double weight = Double.parseDouble(weightString);
      if (weight <= 0)
        return false;
      if (weight > 999999.99)
        return false;

      // Check decimal places (max 2)
      if (weightString.contains(".")) {
        String[] parts = weightString.split("\\.");
        if (parts[1].length() > 2)
          return false;
      }

      // No leading zeros unless 0 or 0.xx
      if (weightString.charAt(0) == '0' && weightString.length() > 1)
        return false;

      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static boolean validateMode(String mode) {
    return mode.matches("AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT");
  }

  private static boolean validateShipmentDate(String dateString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd")
        .withResolverStyle(ResolverStyle.STRICT);
    try {
      LocalDate date = LocalDate.parse(dateString, formatter);
      if (date.getYear() < 2000 || date.getYear() > 2099)
        return false;
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private static boolean validateShipmentCode(String code) {
    if (!code.matches("SHIP-[1-9]\\d{5}"))
      return false;

    String codeValue = code.substring(5);

    for (int i = 0; i < codeValue.length() - 3; i++) {
      if (codeValue.charAt(i) == codeValue.charAt(i + 1)
          && codeValue.charAt(i) == codeValue.charAt(i + 2)
          && codeValue.charAt(i) == codeValue.charAt(i + 3))
        return false;
    }
    return true;

  }

}
