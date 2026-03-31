package com.shravan;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class IplCensorAnalyzer {
  public static void main(String[] args) throws Exception {
    JSONArray censoredJson = censorJson(ResourceReader.readText("/ipl.json"));
    String censoredCsv = censorCsv(ResourceReader.readText("/ipl.csv"));

    Path outDir = Path.of("io-programming","gcr-codebase","json","src", "main", "resources", "output");
    Files.createDirectories(outDir);

    Files.writeString(outDir.resolve("ipl_censored.json"), censoredJson.toString(2), StandardCharsets.UTF_8);
    Files.writeString(outDir.resolve("ipl_censored.csv"), censoredCsv, StandardCharsets.UTF_8);

    System.out
        .println("Wrote src/main/resources/output/ipl_censored.json and src/main/resources/output/ipl_censored.csv");
  }

  private static JSONArray censorJson(String jsonText) {
    JSONArray input = new JSONArray(jsonText);
    JSONArray output = new JSONArray();

    for (int i = 0; i < input.length(); i++) {
      JSONObject match = input.getJSONObject(i);
      JSONObject sanitized = new JSONObject(match.toString());

      String team1 = match.optString("team1");
      String team2 = match.optString("team2");

      String maskedTeam1 = maskTeam(team1);
      String maskedTeam2 = maskTeam(team2);

      sanitized.put("team1", maskedTeam1);
      sanitized.put("team2", maskedTeam2);

      String winner = match.optString("winner");
      if (!winner.isBlank()) {
        sanitized.put("winner", maskTeam(winner));
      }

      if (match.has("score")) {
        JSONObject score = match.getJSONObject("score");
        JSONObject maskedScore = new JSONObject();
        for (String key : score.keySet()) {
          maskedScore.put(maskTeam(key), score.get(key));
        }
        sanitized.put("score", maskedScore);
      }

      if (match.has("player_of_match")) {
        sanitized.put("player_of_match", "REDACTED");
      }

      output.put(sanitized);
    }

    return output;
  }

  private static String censorCsv(String csvText) {
    String[] lines = csvText.strip().split("\\R");
    if (lines.length == 0) {
      return "";
    }

    String[] headers = lines[0].split(",");
    StringBuilder out = new StringBuilder();
    out.append(lines[0]).append(System.lineSeparator());

    for (int i = 1; i < lines.length; i++) {
      if (lines[i].isBlank()) {
        continue;
      }
      String[] values = lines[i].split(",", -1);
      Map<String, String> row = new LinkedHashMap<>();
      for (int j = 0; j < headers.length && j < values.length; j++) {
        row.put(headers[j].trim(), values[j].trim());
      }

      row.computeIfPresent("team1", (k, v) -> maskTeam(v));
      row.computeIfPresent("team2", (k, v) -> maskTeam(v));
      row.computeIfPresent("winner", (k, v) -> maskTeam(v));
      row.computeIfPresent("player_of_match", (k, v) -> "REDACTED");

      out.append(String.join(",", row.values())).append(System.lineSeparator());
    }

    return out.toString();
  }

  private static String maskTeam(String name) {
    if (name == null || name.isBlank()) {
      return name;
    }
    String[] parts = name.trim().split("\\s+");
    if (parts.length == 1) {
      return "***";
    }
    parts[parts.length - 1] = "***";
    return String.join(" ", parts);
  }
}
