/**
 * Sandeep's Fitness Challenge Tracker
 * Tracks push-up counts for a week
 * Uses for-each loop to calculate total and average
 * Uses continue to skip rest days
 */

public class SandeepsFitnessChallengeTracker {

  public static void main(String[] args) {

    int[] pushUpCounts = { 50, 45, 0, 60, 55, 0, 70 };

    String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

    int total = 0;
    int workoutDays = 0;

    System.out.println("Sandeep's Fitness Challenge Tracker n");

    System.out.println("Daily Push-ups:");
    for (int i = 0; i < pushUpCounts.length; i++) {
      if (pushUpCounts[i] == 0) {
        System.out.println(days[i] + ": Rest day");
        continue;
      }
      System.out.println(days[i] + ": " + pushUpCounts[i] + " push-ups");
      total += pushUpCounts[i];
      workoutDays++;
    }

    System.out.println("Total push-ups in the week: " + total);
    System.out.println("Number of workout days: " + workoutDays);

    if (workoutDays > 0) {
      double average = (double) total / workoutDays;
      System.out.println("Average push-ups per workout day: " + String.format("%.2f", average));
    }

    int maxPushUps = 0;
    String bestDay = "";
    for (int i = 0; i < pushUpCounts.length; i++) {
      if (pushUpCounts[i] > maxPushUps) {
        maxPushUps = pushUpCounts[i];
        bestDay = days[i];
      }
    }

    if (maxPushUps > 0) {
      System.out.println("Best performance: " + bestDay + " with " + maxPushUps + " push-ups");
    }
  }
}
