package com.shravan.health_clinic.service;

import com.shravan.health_clinic.dao.PatientDAO;
import com.shravan.health_clinic.model.Patient;

import java.sql.SQLException;

public class PatientService {

    private PatientDAO patientDAO = new PatientDAO();

    public void registerPatient(Patient patient) throws SQLException {

        if (patient.getPhone() == null || patient.getPhone().isEmpty()) {
            throw new IllegalArgumentException("Phone number required");
        }

        patientDAO.save(patient);
    }

    public void updatePatient(Patient patient) throws SQLException {
        if (patient.getId() <= 0) {
            throw new IllegalArgumentException("Patient ID required for update");
        }

        patientDAO.update(patient);
    }

    public java.util.List<Patient> searchByName(String name) throws SQLException {
        return patientDAO.searchByName(name);
    }

}
