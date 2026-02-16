package com.shravan;

import com.shravan.controller.EmployeeWageController;
import com.shravan.entity.EmployeeAttendance;
import com.shravan.repository.EmployeeWageRepository;
import com.shravan.service.EmployeeWageService;

public class App {
    public static void main(String[] args) {

        EmployeeWageController controller = new EmployeeWageController(
                new EmployeeWageService(new EmployeeWageRepository()));

        System.out.println(controller.getWelcomeMessage());

        EmployeeAttendance attendance = controller.checkEmployeeAttendance();
        System.out.println("UC1 Result: " + attendance.getStatus());
    }
}
