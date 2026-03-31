package com.shravan;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJsonJackson {
    public static void main(String[] args) throws Exception {
        String jsonText = ResourceReader.readText("/sample.json");

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readTree(jsonText);
            System.out.println("Valid JSON");
        } catch (Exception ex) {
            System.out.println("Invalid JSON: " + ex.getMessage());
        }
    }

}
