public class Student {
  public int rollNumber;
  protected String name;
  private double cgpa;

  public Student(int rollNumber, String name, double cgpa) {
    this.rollNumber = rollNumber;
    this.name = name;
    this.cgpa = cgpa;
  }

  public double getCgpa() {
    return cgpa;
  }

  public void setCgpa(double cgpa) {
    this.cgpa = cgpa;
  }

}

class PostGraduateStudent extends Student {

  PostGraduateStudent(int rollNumber, String name, double cgpa) {
    super(rollNumber, name, cgpa);
  }

  public void displayInfo() {
    System.out.println("Roll Number: " + rollNumber);
    System.out.println("Name: " + name);
    // System.out.println("CGPA: " + cgpa); 
    System.out.println("CGPA: " + getCgpa()); 
  }

  public static void main(String[] args) {
    PostGraduateStudent pgStudent = new PostGraduateStudent(101, "Alice", 3.8);
    pgStudent.displayInfo();
  }
}