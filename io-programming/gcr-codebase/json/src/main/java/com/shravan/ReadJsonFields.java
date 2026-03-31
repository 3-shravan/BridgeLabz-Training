package com.shravan;

import org.json.JSONObject;

public class ReadJsonFields {
    public static void main(String[] args) throws Exception {
        String jsonText = ResourceReader.readText("/sample.json");

        JSONObject obj = new JSONObject(jsonText);
        String name = obj.optString("name");
        String email = obj.optString("email");

        System.out.println("name: " + name);
        System.out.println("email: " + email);
    }
}
