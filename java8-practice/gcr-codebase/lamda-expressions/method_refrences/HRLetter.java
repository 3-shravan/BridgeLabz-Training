package method_refrences;

import java.util.List;

public class HRLetter {

    public static void main(String[] args) {

        List<String> employeeNames = List.of(
                "Shravan",
                "Amit",
                "Neha",
                "Ravi");
        employeeNames.stream().map(e -> e.toUpperCase()).forEach(System.out::println);
    }
}