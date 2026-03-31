import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptDecryptCsv {
  public static void main(String[] args) {
    String output = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\employees_secure.csv";

    writeEncryptedCsv(output);
    readDecryptedCsv(output);
  }

  private static void writeEncryptedCsv(String filePath) {
    String[] rows = { "ID,Name,Department,Salary,Email", "1,Asha,HR,45000,asha@example.com",
        "2,Ravi,IT,52000,ravi@example.com", "3,Meera,Finance,48000,meera@example.com" };

    try (FileWriter writer = new FileWriter(filePath)) {
      for (int i = 0; i < rows.length; i++) {
        if (i == 0) {
          writer.write(rows[i] + "\n");
          continue;
        }

        String[] parts = rows[i].split(",");
        parts[3] = encrypt(parts[3]);
        parts[4] = encrypt(parts[4]);
        writer.write(String.join(",", parts) + "\n");
      }
      System.out.println("Encrypted CSV created: " + filePath);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void readDecryptedCsv(String filePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      boolean isHeader = true;

      while ((line = reader.readLine()) != null) {
        if (isHeader) {
          System.out.println(line);
          isHeader = false;
          continue;
        }

        String[] parts = line.split(",");
        parts[3] = decrypt(parts[3]);
        parts[4] = decrypt(parts[4]);
        System.out.println(String.join(",", parts));
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static String encrypt(String text) {
    return Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
  }

  private static String decrypt(String text) {
    return new String(Base64.getDecoder().decode(text), StandardCharsets.UTF_8);
  }
}
