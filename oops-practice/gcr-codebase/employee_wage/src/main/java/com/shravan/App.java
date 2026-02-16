package com.shravan;

import java.util.Random;

import com.shravan.controller.EmployeeWageController;
import com.shravan.entity.EmployeeAttendance;
import com.shravan.entity.EmployeeWage;
import com.shravan.repository.EmployeeWageRepository;
import com.shravan.service.EmployeeWageService;

public class App {

    private static final int EMPLOYEE_ABSENT = 0;
    private static final int EMPLOYEE_FULL_TIME = 1;
    private static final int EMPLOYEE_PART_TIME = 2;

    public static void main(String[] args) {

        EmployeeWageController controller = new EmployeeWageController(
                new EmployeeWageService(new EmployeeWageRepository()));

        System.out.println(controller.getWelcomeMessage());

        EmployeeAttendance attendance = controller.checkEmployeeAttendance();
        System.out.println("UC1 Result: " + attendance.getStatus());

        EmployeeWage dailyWage = controller.calculateDailyWage();
        System.out.println("UC2 Result: Daily Employee Wage = " + dailyWage.getAmount());

        EmployeeWage partTimeWage = controller.calculatePartTimeWage();
        System.out.println("UC3 Result: Part Time Employee Wage = " + partTimeWage.getAmount());

        int employeeType = new Random().nextInt(3);
        int uc4Wage;

        switch (employeeType) {
            case EMPLOYEE_FULL_TIME:
                uc4Wage = controller.calculateDailyWage().getAmount();
                break;
            case EMPLOYEE_PART_TIME:
                uc4Wage = controller.calculatePartTimeWage().getAmount();
                break;
            case EMPLOYEE_ABSENT:
            default:
                uc4Wage = 0;
                break;
        }

        System.out.println("UC4 Result: Employee Wage using Switch Case = " + uc4Wage);

        EmployeeWage monthlyWage = controller.calculateMonthlyWage();
        System.out.println("UC5 Result: Monthly Employee Wage = " + monthlyWage.getAmount());
    }
}
