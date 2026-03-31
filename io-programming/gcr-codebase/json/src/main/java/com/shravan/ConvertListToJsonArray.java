package com.shravan;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConvertListToJsonArray {
  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    students.add(new Student("Aarav", 22));
    students.add(new Student("Meera", 28));
    students.add(new Student("Kabir", 31));

    JSONArray array = new JSONArray();
    for (Student s : students) {
      JSONObject obj = new JSONObject().put("name", s.getName()).put("age", s.getAge());
      array.put(obj);
    }

    System.out.println(array.toString(2));
  }

  static class Student {
    private final String name;
    private final int age;

    Student(String name, int age) {
      this.name = name;
      this.age = age;
    }

    String getName() {
      return name;
    }

    int getAge() {
      return age;
    }
  }
}
