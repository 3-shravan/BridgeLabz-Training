package com.shravan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.shravan.controller.EmployeeWageController;
import com.shravan.repository.EmployeeWageRepository;
import com.shravan.service.EmployeeWageService;
import org.junit.Test;

public class AppTest {

    private EmployeeWageController createController() {
        return new EmployeeWageController(new EmployeeWageService(new EmployeeWageRepository()));
    }

    @Test
    public void shouldComputeWageDetails() {
        EmployeeWageController controller = createController();

        String welcomeText = controller.getWelcomeText();
        String attendanceStatus = controller.getAttendanceStatus();
        int fullTimeDailyWage = controller.getFullTimeDailyWage();
        int partTimeDailyWage = controller.getPartTimeDailyWage();
        int attendanceBasedDailyWage = controller.getAttendanceBasedDailyWage();
        int estimatedMonthlyWage = controller.getEstimatedMonthlyWage();
        int monthlyWageWithLimits = controller.getMonthlyWageWithLimits();
        int staticConfigurationWage = controller.getStaticConfigurationWage();

        assertEquals("Welcome to Employee Wage Computation Program", welcomeText);
        assertTrue(attendanceStatus.equals("Employee is Present") || attendanceStatus.equals("Employee is Absent"));
        assertEquals(160, fullTimeDailyWage);
        assertEquals(160, partTimeDailyWage);
        assertTrue(attendanceBasedDailyWage == 0 || attendanceBasedDailyWage == 160);
        assertEquals(3200, estimatedMonthlyWage);
        assertTrue(monthlyWageWithLimits >= 0 && monthlyWageWithLimits <= 2000);
        assertTrue(staticConfigurationWage >= 0 && staticConfigurationWage <= 2000);
        assertTrue(staticConfigurationWage % 20 == 0);
    }
}
