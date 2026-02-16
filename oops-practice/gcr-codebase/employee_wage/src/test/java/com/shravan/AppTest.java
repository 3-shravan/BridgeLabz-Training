package com.shravan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.shravan.controller.EmployeeWageController;
import com.shravan.entity.EmployeeAttendance;
import com.shravan.repository.EmployeeWageRepository;
import com.shravan.service.EmployeeWageService;
import org.junit.Test;

public class AppTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        EmployeeWageController controller = new EmployeeWageController(
                new EmployeeWageService(new EmployeeWageRepository()));

        assertEquals("Welcome to Employee Wage Computation Program", controller.getWelcomeMessage());
    }

    @Test
    public void shouldCheckAttendanceForUc1() {
        EmployeeWageController controller = new EmployeeWageController(
                new EmployeeWageService(new EmployeeWageRepository()));

        EmployeeAttendance attendance = controller.checkEmployeeAttendance();

        assertNotNull(attendance);
        assertTrue(attendance.getStatus().equals("Employee is Present")
                || attendance.getStatus().equals("Employee is Absent"));
    }
}
