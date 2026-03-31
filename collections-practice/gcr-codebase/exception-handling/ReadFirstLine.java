import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFirstLine {

    public static void main(String[] args) {
        String fileName = "collections-practice\\gcr-codebase\\exception-handling\\file.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String firstLine = br.readLine();
            if (firstLine != null) {
                System.out.println(firstLine);
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
