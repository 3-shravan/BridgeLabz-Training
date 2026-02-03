package com.shravan;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class PrintJsonKeysValues {
    public static void main(String[] args) throws Exception {
        String jsonText = ResourceReader.readText("/sample.json").trim();
        if (jsonText.startsWith("[")) {
            JSONArray array = new JSONArray(jsonText);
            for (int i = 0; i < array.length(); i++) {
                printObject(array.getJSONObject(i));
            }
        } else {
            printObject(new JSONObject(jsonText));
        }
    }

    private static void printObject(JSONObject obj) {
        Iterator<String> keys = obj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = obj.get(key);
            System.out.println(key + ": " + value);
        }
    }
}
