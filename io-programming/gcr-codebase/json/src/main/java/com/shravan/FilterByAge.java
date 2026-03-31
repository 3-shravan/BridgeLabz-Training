package com.shravan;

import org.json.JSONArray;
import org.json.JSONObject;

public class FilterByAge {
    public static void main(String[] args) {
        String json = """
                [
                  {"name":"Aarav","age":22},
                  {"name":"Meera","age":28},
                  {"name":"Kabir","age":31},
                  {"name":"Isha","age":24}
                ]
                """;

        JSONArray input = new JSONArray(json);
        JSONArray filtered = new JSONArray();

        for (int i = 0; i < input.length(); i++) {
            JSONObject obj = input.getJSONObject(i);
            if (obj.optInt("age", 0) > 25) {
                filtered.put(obj);
            }
        }

        System.out.println(filtered.toString(2));
    }
}
