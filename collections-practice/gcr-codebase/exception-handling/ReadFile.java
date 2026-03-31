import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
  public static void main(String[] args) {
    String fileName = "collections-practice\\gcr-codebase\\exception-handling\\file.txt";
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
