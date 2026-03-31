import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedVsUnbufferedCopy {

  private static final int BUFFER_SIZE = 4096; // 4 KB

  public static void main(String[] args) {

    String source = "collections-practice\\gcr-codebase\\streams\\largeFile.dat";
    String unbufferedDest = "collections-practice\\gcr-codebase\\streams\\unbuffered.dat";
    String bufferedDest = "collections-practice\\gcr-codebase\\streams\\buffered.dat";

    // Unbuffered Copy
    long unbufferedTime = copyUsingUnbufferedStreams(source, unbufferedDest);

    // Buffered Copy
    long bufferedTime = copyUsingBufferedStreams(source, bufferedDest);

    System.out.println("\nPerformance Comparison:");
    System.out.println("Unbuffered Time : " + unbufferedTime + " ms");
    System.out.println("Buffered Time   : " + bufferedTime + " ms");

  }

  private static long copyUsingUnbufferedStreams(String source, String dest) {
    long startTime = System.nanoTime();
    try (FileInputStream fis = new FileInputStream(source); FileOutputStream fos = new FileOutputStream(dest)) {
      byte[] buffer = new byte[BUFFER_SIZE];
      int bytesRead;

      while ((bytesRead = fis.read(buffer)) != -1) {
        fos.write(buffer, 0, bytesRead);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    long endTime = System.nanoTime();
    return (endTime - startTime) / 1_000_000;

  }

  private static long copyUsingBufferedStreams(String source, String dest) {
    long startTime = System.nanoTime();

    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
      byte[] buffer = new byte[BUFFER_SIZE];
      int bytesRead;

      while ((bytesRead = bis.read(buffer)) != -1) {
        bos.write(buffer, 0, bytesRead);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    long endTime = System.nanoTime();
    return (endTime - startTime) / 1_000_000;
  }
}
