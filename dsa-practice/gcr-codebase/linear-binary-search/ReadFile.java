import java.io.*;

public class ReadFile {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("D:\\BridgeLabz-Training\\dsa-practice\\gcr-codebase\\linear-binary-search\\input.txt"));
    String line;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
    br.close();
  }
}
