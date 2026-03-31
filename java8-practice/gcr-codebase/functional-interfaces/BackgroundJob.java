public class BackgroundJob {

  public static void main(String[] args) {

    Runnable job = () -> {
      System.out.println("Background job started");
      try {
        Thread.sleep(2000); // Simulate a long-running task
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Background job finished");
    };

    // Run asynchronously
    Thread thread = new Thread(job);
    thread.start();

    System.out.println("Main thread continues working...");
  }
}
