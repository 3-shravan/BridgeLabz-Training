package reviews.diamond_problem;

public class Student implements CourseInfo, SubjectsInfo {
	private String name;

	public Student(String name) {
		this.name = name;
	}

	@Override
	public void studentDetails() {
		System.out.println("Student Name: " + name);
	}

}
