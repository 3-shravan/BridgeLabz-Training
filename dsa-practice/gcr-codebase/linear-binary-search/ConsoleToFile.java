import java.io.*;

public class ConsoleToFile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("D:\\BridgeLabz-Training\\dsa-practice\\gcr-codebase\\linear-binary-search\\input.txt"));

        String input;
        while (true) {
            input = br.readLine();

            if (input == null)
                break;

            input = input.trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            bw.write(input);
            bw.newLine();
        }

        bw.close();
        System.out.println("Program exited successfully.");

    }
}
