package com.shravan;

import org.json.JSONObject;

public class MergeJsonObjects {
    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Aarav");
        obj1.put("email", "aarav@example.com");
        obj1.put("city", "Pune");

        JSONObject obj2 = new JSONObject();
        obj2.put("email", "aarav.sharma@example.com"); // overrides obj1 email
        obj2.put("age", 22);

        JSONObject merged = merge(obj1, obj2);
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
