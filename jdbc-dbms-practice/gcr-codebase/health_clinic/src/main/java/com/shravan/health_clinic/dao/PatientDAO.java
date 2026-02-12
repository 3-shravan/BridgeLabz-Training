package com.shravan.health_clinic.dao;

import com.shravan.health_clinic.config.DBConnection;
import com.shravan.health_clinic.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

  // Register Patient
  public void save(Patient patient) throws SQLException {

    String sql = "INSERT INTO patients(name, dob, phone, email, address, blood_group) "
        + "VALUES (?, ?, ?, ?, ?, ?) "
        + "ON DUPLICATE KEY UPDATE "
        + "name=VALUES(name), dob=VALUES(dob), phone=VALUES(phone), "
        + "email=VALUES(email), address=VALUES(address), blood_group=VALUES(blood_group)";

    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

      ps.setString(1, patient.getName());
      ps.setDate(2, Date.valueOf(patient.getDob()));
      ps.setString(3, patient.getPhone());
      ps.setString(4, patient.getEmail());
      ps.setString(5, patient.getAddress());
      ps.setString(6, patient.getBloodGroup());

      ps.executeUpdate();
    }
  }

  // Search by Name (LIKE)
  public List<Patient> searchByName(String name) throws SQLException {

    List<Patient> list = new ArrayList<>();

    String sql = "SELECT * FROM patients WHERE name LIKE ?";

    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

      ps.setString(1, "%" + name + "%");

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        Patient p = new Patient();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        list.add(p);
      }
    }

    return list;
  }

  // Update Patient
  public void update(Patient patient) throws SQLException {
    String sql = "UPDATE patients SET name=?, phone=? WHERE id=?";

    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

      ps.setString(1, patient.getName());
      ps.setString(2, patient.getPhone());
      ps.setInt(3, patient.getId());

      ps.executeUpdate();
    }
  }
}