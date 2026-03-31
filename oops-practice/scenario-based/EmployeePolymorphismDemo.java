abstract class Employee {

    private final String name;
    private final double salary;
    protected final double bonus;

    protected Employee(String name, double salary, double bonus) {
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
    }

    public final double getBonus() {
        return bonus;
    }

    public final double getSalary() {
        return salary;
    }
}

class Manager extends Employee {

    public Manager(String name, double salary) {
        super(name, salary, salary * 0.10);
    }
}

class Developer extends Employee {

    public Developer(String name, double salary) {
        super(name, salary, salary > 50000 ? salary * 0.05 : 0.0);
    }
}

public class EmployeePolymorphismDemo {

    public static void main(String[] args) {

        Employee manager = new Manager("Alice", 80000);
        System.out.printf("%.2f%n", manager.getBonus());

        Employee dev1 = new Developer("Bob", 60000);
        Employee dev2 = new Developer("Eve", 40000);

        System.out.printf("%.2f%n", dev1.getBonus());
        System.out.printf("%.2f%n", dev2.getBonus());
    }
}
