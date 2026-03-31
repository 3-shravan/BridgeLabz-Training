import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class CreatorStats {
  String creatorName;
  double weeklyLikes;
  public static List<CreatorStats> EngagementBoard;

  public void registerCreator(String name, double likes) {
    CreatorStats newCreator = new CreatorStats();
    newCreator.creatorName = name;
    newCreator.weeklyLikes = likes;
    EngagementBoard.add(newCreator);
  }

  public HashMap<String, Integer> getTopPostCount(List<CreatorStats> records, double likeThresold) {
    HashMap<String, Integer> topCreators = new HashMap<>();

    for (CreatorStats record : records) {
      if (record.weeklyLikes >= likeThresold) {
        topCreators.put(record.creatorName, topCreators.getOrDefault(record.creatorName, 0) + 1);
      }
    }

    return topCreators;
  }

  public double calculateAverageLikes() {
    double totalLikes = 0;
    for (CreatorStats record : EngagementBoard) {
      totalLikes += record.weeklyLikes;
    }
    return EngagementBoard.isEmpty() ? 0 : totalLikes / EngagementBoard.size();
  }
}

public class StreamBuzz {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CreatorStats.EngagementBoard = new ArrayList<>();
    CreatorStats stats = new CreatorStats();
    while (true) {
      System.out.println("1. Register Creator");
      System.out.println("2. Top Post Counts");
      System.out.println("3. Overall Average Weekly Likes");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
      case 1:
        System.out.print("Enter Creator Name: ");
        String creatorName = scanner.nextLine();
        for (int week = 1; week <= 4; week++) {
          System.out.print("Enter Weekly Likes for Week " + week + ": ");
          double weeklyLikes = scanner.nextDouble();
          stats.registerCreator(creatorName, weeklyLikes);
        }
        scanner.nextLine();
        System.out.println("Creator registered successfully");
        break;
      case 2:
        System.out.print("Enter like threshold: ");
        double likeThreshold = scanner.nextDouble();
        scanner.nextLine();
        HashMap<String, Integer> topCreators = stats.getTopPostCount(CreatorStats.EngagementBoard, likeThreshold);
        if (topCreators.isEmpty()) {
          System.out.println("No top-performing posts this week");
        } else {
          for (Map.Entry<String, Integer> entry : topCreators.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
          }
        }
        break;
      case 3:
        double average = stats.calculateAverageLikes();
        System.out.println("Overall average weekly likes: " + average);
        break;
      case 4:
        System.out.println("Logging off — Keep Creating with StreamBuzz!");
        scanner.close();
        return;
      default:
        System.out.println("Invalid choice");
        break;
      }
    }
  }
}