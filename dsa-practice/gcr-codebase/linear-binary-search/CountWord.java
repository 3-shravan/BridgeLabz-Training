import java.io.*;

public class CountWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String target = "java";
        int count = 0;

        String line;
        while ((line = br.readLine()) != null) {
            for (String word : line.split("\\s+")) {
                if (word.equalsIgnoreCase(target)) count++;
            }
        }
        br.close();
        System.out.println("Count: " + count);
    }
}
