import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadingComparison {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\BridgeLabz-Training\\dsa-practice\\gcr-codebase\\runtime-analysis\\file.txt";
        long start = System.nanoTime();
        readUsingFileReader(filePath);
        long end = System.nanoTime();
        System.out.println("FileReader Time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        readUsingInputStreamReader(filePath);
        end = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    static void readUsingFileReader(String path) throws IOException {
        FileReader fr = new FileReader(path);
        while (fr.read() != -1) {
        }
        fr.close();
    }

    static void readUsingInputStreamReader(String path) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        while (br.readLine() != null) {
        }
        br.close();
    }
}
