import java.util.Arrays;
import java.util.stream.Collectors;

class Student {
  private String name;
  private int grade;

  public Student(String name, int grade) {
    this.name = name;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public int getGrade() {
    return grade;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", grade=" + grade +
        '}';
  }
}

public class CollectStudentsByGrade {

  public static void main(String[] args) {
    Arrays.asList(
        new Student("Alice", 90),
        new Student("Bob", 85),
        new Student("Charlie", 90),
        new Student("David", 85)).stream()
        .collect(Collectors.groupingBy(Student::getGrade, Collectors.mapping(Student::getName, Collectors.toList())))
        .forEach((grade, names) -> System.out.println("Grade: " + grade + ", Students: " + names));
  }
}