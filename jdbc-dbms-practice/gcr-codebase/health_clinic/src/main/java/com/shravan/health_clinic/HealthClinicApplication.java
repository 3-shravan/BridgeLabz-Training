package com.shravan.health_clinic;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.shravan.health_clinic.init.DatabaseInitializer;
import com.shravan.health_clinic.model.Patient;
import com.shravan.health_clinic.service.PatientService;

public class HealthClinicApplication {
    public static void main(String[] args) throws SQLException {

        DatabaseInitializer.initialize();

        PatientService service = new PatientService();

        Patient p = new Patient(
                "Shravan",
                LocalDate.of(2002, 5, 20),
                "99999999994",
                "shravan@gmail.com",
                "Delhi",
                "O+");

        try {
            service.registerPatient(p);
            System.out.println("Patient Registered Successfully!");

            List<Patient> results = service.searchByName("Shravan");
            results.forEach(patient -> {
                System.out.println("Patient ID: " + patient.getId());
                System.out.println("Patient Name: " + patient.getName());
            });

            if (!results.isEmpty()) {
                Patient toUpdate = new Patient();
                toUpdate.setId(results.get(0).getId());
                toUpdate.setName("Shravan Kumar");
                toUpdate.setPhone("8888888888");

                service.updatePatient(toUpdate);
                System.out.println("Patient Updated Successfully!");
            } else {
                System.out.println("No patient found to update.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
