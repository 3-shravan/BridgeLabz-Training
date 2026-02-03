package com.shravan;

import org.json.JSONObject;

public class MergeJsonFiles {
  public static void main(String[] args) throws Exception {
    String leftText = ResourceReader.readText("/file1.json");
    String rightText = ResourceReader.readText("/file2.json");

    JSONObject left = new JSONObject(leftText);
    JSONObject right = new JSONObject(rightText);

    JSONObject merged = merge(left, right);
    System.out.println(merged.toString(2));
  }

  private static JSONObject merge(JSONObject base, JSONObject override) {
    JSONObject result = new JSONObject(base.toString());
    for (String key : override.keySet()) {
      result.put(key, override.get(key));
    }
    return result;
  }
}
