import java.util.PriorityQueue;

class InvalidBackupTaskException extends Exception {
  public InvalidBackupTaskException(String message) {
    super(message);
  }
}

class BackupTask implements Comparable<BackupTask> {
  private String folderPath;
  private int priority;

  public BackupTask(String folderPath, int priority) {
    this.folderPath = folderPath;
    this.priority = priority;
  }

  public String getFolderPath() {
    return folderPath;
  }

  public int getPriority() {
    return priority;
  }

  @Override
  public int compareTo(BackupTask other) {
    return Integer.compare(other.getPriority(), this.getPriority());
  }

}

class BackupService {
  PriorityQueue<BackupTask> queue = new PriorityQueue<>();

  public void addBackupTask(BackupTask task) throws InvalidBackupTaskException {
    if (task.getFolderPath() == null || task.getFolderPath().isEmpty() || !task.getFolderPath().startsWith("/")) {

      throw new InvalidBackupTaskException("Invalid backup path: " + task.getFolderPath());
    }
    queue.offer(task);
    System.out.println(" Scheduled: " + task);
  }

  public void executeBackupTasks() {
    while (!queue.isEmpty()) {
      BackupTask task = queue.poll();
      System.out.println(" Backing up: " + task);

    }
  }
}

public class BackupScheduler {
  public static void main(String[] args) {
    BackupService scheduler = new BackupService();

    try {
      scheduler.addBackupTask(new BackupTask("/data/db", 10));

      scheduler.addBackupTask(new BackupTask("/logs/app", 5));

      scheduler.addBackupTask(new BackupTask("/images", 7));
      scheduler.addBackupTask(new BackupTask("invalidPath", 3));

    } catch (InvalidBackupTaskException e) {
      System.out.println(e.getMessage());
    }

    scheduler.executeBackupTasks();
  }

}
