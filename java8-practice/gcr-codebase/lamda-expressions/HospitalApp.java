
import java.util.*;
import java.util.function.Predicate;

class Alert {
  String message;
  String type; // EMERGENCY, MEDICINE, APPOINTMENT

  Alert(String message, String type) {
    this.message = message;
    this.type = type;
  }

  @Override
  public String toString() {
    return "[" + type + "] " + message;
  }
}

class NotificationService {

  static void showAlerts(List<Alert> alerts, Predicate<Alert> filter) {
    for (Alert alert : alerts) {
      if (filter.test(alert)) {
        System.out.println(alert);
      }
    }
  }
}

public class HospitalApp {

  public static void main(String[] args) {

    List<Alert> alerts = List.of(
        new Alert("Heart rate critical", "EMERGENCY"),
        new Alert("Take medicine at 8 AM", "MEDICINE"),
        new Alert("Doctor appointment tomorrow", "APPOINTMENT"),
        new Alert("Welcome to the app", "GENERAL"));

    // only emergency alerts
    NotificationService.showAlerts(alerts,
        alert -> alert.type.equals("EMERGENCY"));

    // medicine + appointment alerts
    NotificationService.showAlerts(alerts,
        alert -> alert.type.equals("MEDICINE")
            || alert.type.equals("APPOINTMENT"));
  }
}
