import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCountTop5 {

    public static void main(String[] args) {

        String fileName = "collections-practice\\gcr-codebase\\streams\\application.log";
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // READ FILE
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // SORT BY FREQUENCY
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        // PRINT TOP 5
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            System.out.println(list.get(i).getKey() + " : " + list.get(i).getValue());
        }
    }
}
