public class TemperatureAnalyzer {

  public static void analyzeTemperatures(float[][] weeklyTemps) {
    float totalTemp = 0;
    int count = 0;
    float highestTemp = Float.MIN_VALUE;
    float lowestTemp = Float.MAX_VALUE;

    for (int day = 0; day < weeklyTemps.length; day++) {
      for (int hour = 0; hour < weeklyTemps[day].length; hour++) {
        float temp = weeklyTemps[day][hour];
        totalTemp += temp;
        count++;

        if (temp > highestTemp) {
          highestTemp = temp;
        }
        if (temp < lowestTemp) {
          lowestTemp = temp;
        }
      }
    }

    float averageTemp = totalTemp / count;
    System.out.printf("Average Temperature: %.2f°C%n", averageTemp);
    System.out.printf("Highest Temperature: %.2f°C%n", highestTemp);
    System.out.printf("Lowest Temperature: %.2f°C%n", lowestTemp);
  }

  public static void main(String[] args) {
    float[][] weeklyTemps = new float[7][24];
    // Sample initialization
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 24; j++) {
        weeklyTemps[i][j] = (float) (Math.random() * 15 + 15); // 15°C–30°C
      }
    }
    analyzeTemperatures(weeklyTemps);
  }
}
