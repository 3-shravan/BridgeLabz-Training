import java.io.FileWriter;
import java.io.IOException;

public class WriteCsv {
    public static void main(String[] args) {
        String filePath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\employees.csv";

        String[] lines = {
            "ID,Name,Department,Salary",
            "1,Asha,HR,45000",
            "2,Ravi,IT,52000",
            "3,Meera,Finance,48000",
            "4,Arun,Sales,43000",
            "5,Neha,Support,40000"
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
            System.out.println("CSV file created: " + filePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
