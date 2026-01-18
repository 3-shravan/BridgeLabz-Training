import java.io.*;

public class InputStreamToChar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("D:\\BridgeLabz-Training\\dsa-practice\\gcr-codebase\\linear-binary-search\\input.txt"), "UTF-8"));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
