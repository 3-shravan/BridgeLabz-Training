class PrintJob implements Runnable {

  private final String jobName;
  private final int pages;
  private final int priority;

  public PrintJob(String jobName, int pages, int priority) {
    this.jobName = jobName;
    this.pages = pages;
    this.priority = priority;
  }

  @Override
  public void run() {

    String priorityLabel = getPriorityLabel(priority);

    for (int page = 1; page <= pages; page++) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }

      System.out.println("[" + priorityLabel + "] Printing " +
          jobName + " - Page " + page + " of " + pages);
    }
  }

  private String getPriorityLabel(int priority) {
    if (priority >= 7)
      return "High Priority";
    if (priority >= 5)
      return "Medium Priority";
    return "Low Priority";
  }
}

public class PrintShopScheduler {

  public static void main(String[] args) throws InterruptedException {

    System.out.println("Starting print jobs...");

    long startTime = System.currentTimeMillis();

    Thread t1 = new Thread(new PrintJob("Job1", 10, 5), "Job1");
    Thread t2 = new Thread(new PrintJob("Job2", 5, 8), "Job2");
    Thread t3 = new Thread(new PrintJob("Job3", 15, 3), "Job3");
    Thread t4 = new Thread(new PrintJob("Job4", 8, 6), "Job4");
    Thread t5 = new Thread(new PrintJob("Job5", 12, 7), "Job5");

    // Set thread priorities
    t1.setPriority(5);
    t2.setPriority(8);
    t3.setPriority(3);
    t4.setPriority(6);
    t5.setPriority(7);

    // Start all jobs
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();

    // Wait for all jobs to finish
    t1.join();
    t2.join();
    t3.join();
    t4.join();
    t5.join();

    long endTime = System.currentTimeMillis();

    System.out.println("All jobs completed in " + (endTime - startTime) + "ms");
  }
}
