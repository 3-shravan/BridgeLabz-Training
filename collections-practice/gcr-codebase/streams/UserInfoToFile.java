import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInfoToFile {

    public static void main(String[] args) {

        String fileName = "collections-practice\\gcr-codebase\\streams\\user_info.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                FileWriter fw = new FileWriter(fileName)) {

            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(br.readLine());

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");

            System.out.println("\n Data saved successfully to " + fileName);

        } catch (NumberFormatException e) {
            System.out.println(" Invalid age. Please enter a number.");

        } catch (IOException e) {
            System.out.println(" Error while reading input or writing file.");
            e.printStackTrace();
        }
    }
}
