package com.shravan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.shravan.controller.EmployeeWageController;
import com.shravan.entity.EmployeeAttendance;
import com.shravan.entity.EmployeeWage;
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

    @Test
    public void shouldCalculateDailyWageForUc2() {
        EmployeeWageController controller = new EmployeeWageController(
                new EmployeeWageService(new EmployeeWageRepository()));

        EmployeeWage wage = controller.calculateDailyWage();

        assertNotNull(wage);
        assertEquals(160, wage.getAmount());
    }

    @Test
    public void shouldCalculatePartTimeWageForUc3() {
        EmployeeWageController controller = new EmployeeWageController(
                new EmployeeWageService(new EmployeeWageRepository()));

        EmployeeWage wage = controller.calculatePartTimeWage();

        assertNotNull(wage);
        assertEquals(160, wage.getAmount());
    }

    @Test
    public void shouldSupportWageValuesUsedInSwitchCaseForUc4() {
        EmployeeWageController controller = new EmployeeWageController(
                new EmployeeWageService(new EmployeeWageRepository()));

        int fullTimeWage = controller.calculateDailyWage().getAmount();
        int partTimeWage = controller.calculatePartTimeWage().getAmount();
        int absentWage = 0;

        assertTrue(fullTimeWage == 160);
        assertTrue(partTimeWage == 160);
        assertTrue(absentWage == 0);
    }

    @Test
    public void shouldCalculateMonthlyWageForUc5() {
        EmployeeWageController controller = new EmployeeWageController(
                new EmployeeWageService(new EmployeeWageRepository()));

        EmployeeWage wage = controller.calculateMonthlyWage();

        assertNotNull(wage);
        assertEquals(3200, wage.getAmount());
    }
}
