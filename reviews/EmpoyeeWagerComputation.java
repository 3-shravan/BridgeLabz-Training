public class EmpoyeeWagerComputation {
  
}
public class EmployeeWagerProblem {

  public static void main(String[] args) {
    System.out.println("Welcom to Emplyee Wage Computation");

    boolean isPresent = isEmployeeAbsentPresent();
    System.out.println(isPresent);

  }

  private static boolean isEmployeeAbsentPresent() {
    int attendance = (int) (Math.random() * 2);
    return attendance == 1;
  }

}
