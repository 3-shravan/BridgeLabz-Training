import java.util.Random;

class FileDownloadUtil {
  static void download(String fileName) {
    Random random = new Random();

    for (int progress = 0; progress <= 100; progress += 10) {
      try {
        Thread.sleep(200 + random.nextInt(500));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }

      System.out.println("[" + Thread.currentThread().getName() +
          "] Downloading " + fileName + ": " + progress + "%");
    }
  }
}

class FileDownloaderThreads extends Thread {
  private final String fileName;

  FileDownloaderThreads(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void run() {
    FileDownloadUtil.download(fileName);
  }
}

public class DownloadManager {

  public static void main(String[] args) throws InterruptedException {
    FileDownloaderThreads t1 = new FileDownloaderThreads("Document.pdf");
    FileDownloaderThreads t2 = new FileDownloaderThreads("Image.jpg");
    FileDownloaderThreads t3 = new FileDownloaderThreads("Video.mp4");

    t1.start();
    t2.start();
    t3.start();

    t1.join();
    t2.join();
    t3.join();

    System.out.println("All downloads complete!");

  }
}
