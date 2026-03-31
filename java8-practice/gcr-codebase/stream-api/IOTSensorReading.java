import java.util.Arrays;

public class IOTSensorReading {
  private static final int THRESOLD = 50;

  public static void main(String[] args) {
    Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
        .stream()
        .filter(reading -> reading > THRESOLD)
        .forEach(System.out::println);
  }
}
