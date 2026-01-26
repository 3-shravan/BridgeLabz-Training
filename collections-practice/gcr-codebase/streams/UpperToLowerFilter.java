import java.io.*;

public class UpperToLowerFilter {

    public static void main(String[] args) {

        String sourceFile = "collections-practice\\gcr-codebase\\streams\\source.txt";
        String destinationFile = "collections-practice\\gcr-codebase\\streams\\destination.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));

                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(destinationFile), "UTF-8"))) {

            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("Conversion completed successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
