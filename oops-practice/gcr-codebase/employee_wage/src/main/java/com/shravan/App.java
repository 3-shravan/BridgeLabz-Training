package com.shravan;

import com.shravan.controller.EmployeeWageController;
import com.shravan.repository.EmployeeWageRepository;
import com.shravan.service.EmployeeWageService;

public class App {

    public static void main(String[] args) {

        EmployeeWageController controller = new EmployeeWageController(
                new EmployeeWageService(new EmployeeWageRepository()));

        System.out.println(controller.getWelcomeText());

        System.out.println("Attendance Status: " + controller.getAttendanceStatus());
        System.out.println("Full Time Daily Wage: " + controller.getFullTimeDailyWage());
        System.out.println("Part Time Daily Wage: " + controller.getPartTimeDailyWage());
        System.out.println("Attendance-Based Daily Wage: " + controller.getAttendanceBasedDailyWage());
        System.out.println("Estimated Monthly Wage: " + controller.getEstimatedMonthlyWage());
        System.out.println("Monthly Wage (with max days/hours limits): " + controller.getMonthlyWageWithLimits());
        System.out.println("Static Configuration Wage: " + controller.getStaticConfigurationWage());
    }
}
