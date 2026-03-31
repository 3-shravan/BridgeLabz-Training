import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandling {
  public static void main(String[] args) {

    String sourceFile = "collections-practice\\gcr-codebase\\streams\\source.txt";
    String destinationFile = "collections-practice\\gcr-codebase\\streams\\destination.txt";

    try (FileInputStream fis = new FileInputStream(sourceFile);
        FileOutputStream fos = new FileOutputStream(destinationFile)) {
      int data;
      while ((data = fis.read()) != -1) {
        fos.write(data);
      }

      System.out.println("File copied successfully!");

    } catch (FileNotFoundException e) {
      System.out.println("Source file not found: " + sourceFile);

    } catch (IOException e) {
      System.out.println("Error while reading/writing the file");
      e.printStackTrace();
    }

  }
}
