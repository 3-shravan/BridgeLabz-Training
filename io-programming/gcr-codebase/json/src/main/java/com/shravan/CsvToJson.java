package com.shravan;

import org.json.JSONArray;
import org.json.JSONObject;

public class CsvToJson {
  public static void main(String[] args) throws Exception {
    String csv = """
        name,email,age
        Shravan Yadav,shravan.yadav@example.com,22
        Meera,meera@example.com,28
        """;

    JSONArray json = convert(csv);
    System.out.println(json.toString(2));
  }

  private static JSONArray convert(String csv) {
    String[] lines = csv.strip().split("\\R");
    if (lines.length == 0) {
      return new JSONArray();
    }

    String[] headers = lines[0].split(",");
    JSONArray array = new JSONArray();

    for (int i = 1; i < lines.length; i++) {
      if (lines[i].isBlank()) {
        continue;
      }
      String[] values = lines[i].split(",", -1);
      JSONObject obj = new JSONObject();
      for (int j = 0; j < headers.length && j < values.length; j++) {
        obj.put(headers[j].trim(), values[j].trim());
      }
      array.put(obj);
    }

    return array;
  }
}
