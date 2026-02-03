package com.shravan;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class DatabaseJsonReport {
  public static void main(String[] args) {
    List<UserRecord> records = fetchRecords();

    JSONArray report = new JSONArray();
    for (UserRecord r : records) {
      JSONObject row = new JSONObject().put("id", r.getId()).put("name", r.getName()).put("email", r.getEmail())
          .put("age", r.getAge());
      report.put(row);
    }

    System.out.println(report.toString(2));
  }

  private static List<UserRecord> fetchRecords() {
    List<UserRecord> records = new ArrayList<>();
    records.add(new UserRecord(1, "Shravan Yadav", "shravan.yadav@example.com", 22));
    records.add(new UserRecord(2, "Meera", "meera@example.com", 28));
    records.add(new UserRecord(3, "Kabir", "kabir@example.com", 31));
    return records;
  }

  static class UserRecord {
    private final int id;
    private final String name;
    private final String email;
    private final int age;

    UserRecord(int id, String name, String email, int age) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.age = age;
    }

    int getId() {
      return id;
    }

    String getName() {
      return name;
    }

    String getEmail() {
      return email;
    }

    int getAge() {
      return age;
    }
  }
}
