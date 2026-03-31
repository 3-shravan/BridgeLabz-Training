class Student {
  private String name;

  public Student(String name) {
    this.name = name;
  }

  public void show() {
    System.out.println("Student name: " + name);
  }
}

public class DynamicObjectCreation {
  public static void main(String[] args) {
    try {
      Class<?> studentClass = Class.forName("Student");
      Object studentObject = studentClass.getDeclaredConstructor(String.class).newInstance("Shravan");
      Student student = (Student) studentObject;
      student.show();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
