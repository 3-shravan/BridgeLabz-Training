import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TemperatureMonitor {

  private static final double THRESOLD = 30.0;

  public static void main(String[] args) {
    List<Double> currTemps = Arrays.asList(39.0, 20.0, 30.0, 50.0);
    Predicate<Double> highTemp = temp -> temp < THRESOLD;

    currTemps.stream().filter(highTemp).forEach(System.out::println);

  }
}