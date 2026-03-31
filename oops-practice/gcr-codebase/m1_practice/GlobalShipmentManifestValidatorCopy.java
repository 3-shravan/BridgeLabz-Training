import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;
import java.util.Set;

public class GlobalShipmentManifestValidatorCopy {

  private static final Set<String> VALID_MODES = Set.of("AIR", "SEA", "ROAD", "RAIL", "EXPRESS", "FREIGHT");
  private static final Set<String> VALID_STATUSES = Set.of("DELIVERED", "CANCELLED", "IN_TRANSIT");
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd")
      .withResolverStyle(ResolverStyle.STRICT);
  private static final BigDecimal MAX_WEIGHT = new BigDecimal("999999.99");

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = Integer.parseInt(sc.nextLine().trim());
    for (int i = 0; i < n; i++) {
      String record = sc.nextLine();
      System.out.println(isCompliantRecord(record) ? "COMPLIANT RECORD" : "NON-COMPLIANT RECORD");
    }

    sc.close();
  }

  private static boolean isCompliantRecord(String record) {
    String[] parts = record.split("\\|", -1);
    if (parts.length != 5) {
      return false;
    }

    return validateShipmentCode(parts[0])
        && validateShipmentDate(parts[1])
        && validateMode(parts[2])
        && validateWeight(parts[3])
        && validateStatus(parts[4]);
  }

  private static boolean validateShipmentCode(String code) {
    if (!code.matches("SHIP-[1-9]\\d{5}")) {
      return false;
    }

    String digits = code.substring(5);
    int run = 1;

    for (int i = 1; i < digits.length(); i++) {
      if (digits.charAt(i) == digits.charAt(i - 1)) {
        run++;
        if (run > 3) {
          return false;
        }
      } else {
        run = 1;
      }
    }

    return true;
  }

  private static boolean validateShipmentDate(String dateString) {
    try {
      LocalDate date = LocalDate.parse(dateString, DATE_FORMATTER);
      int year = date.getYear();
      return year >= 2000 && year <= 2099;
    } catch (Exception e) {
      return false;
    }
  }

  private static boolean validateMode(String mode) {
    return VALID_MODES.contains(mode);
  }

  private static boolean validateWeight(String weightString) {
    // Positive, up to 2 decimals, and no leading zeros except 0 or 0.xx
    if (!weightString.matches("(?:0(?:\\.\\d{1,2})?|[1-9]\\d{0,5}(?:\\.\\d{1,2})?)")) {
      return false;
    }

    try {
      BigDecimal weight = new BigDecimal(weightString);
      return weight.compareTo(BigDecimal.ZERO) > 0 && weight.compareTo(MAX_WEIGHT) <= 0;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static boolean validateStatus(String status) {
    return VALID_STATUSES.contains(status);
  }
}
