import java.util.Arrays;

public class EmailNotification {
  public static void main(String[] args) {
    Arrays.asList(
        "shravan@gmail.com",
        "satyarth@gmail.com",
        "neha@gmail.com")
        .forEach(email -> sendEmailNotification(email));
  }

  private static void sendEmailNotification(String emailAddress) {

    System.out.println("Sending email to " + emailAddress);
  }
}