public class DigitalWatchSimulation {
  public static void main(String[] args) {
    System.out.println("⏱️ Digital Watch Simulation (24-Hour) ⏱️");

    for (int hours = 0; hours < 24; hours++) {
      for (int minutes = 0; minutes < 60; minutes++) {
        String timeDisplay = String.format("%02d:%02d", hours, minutes);
        System.out.println(timeDisplay + " ");

        if (hours == 13 && minutes == 0) {
          System.out.println(" POWER CUT at 13:00! Watch stopped.");
          return;
        }

      }
      System.out.println();
    }
  }
}
