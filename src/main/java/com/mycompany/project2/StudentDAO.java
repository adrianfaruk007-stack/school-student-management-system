package com.mycompany.project2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void addStudent(Student s) throws SQLException {
        String sql = "INSERT INTO students (admission_no, full_name, gender, date_of_birth, "
                + "class_name, guardian_name, guardian_phone, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getAdmissionNo());
            ps.setString(2, s.getFullName());
            ps.setString(3, s.getGender());
            ps.setDate(4, Date.valueOf(LocalDate.parse(s.getDob(), FORMAT)));
            ps.setString(5, s.getClassName());
            ps.setString(6, s.getGuardianName());
            ps.setString(7, s.getGuardianPhone());
            ps.setString(8, s.getAddress());
            ps.executeUpdate();
        }
    }

    public void updateStudent(String originalAdmissionNo, Student s) throws SQLException {
        String sql = "UPDATE students SET admission_no = ?, full_name = ?, gender = ?, "
                + "date_of_birth = ?, class_name = ?, guardian_name = ?, guardian_phone = ?, "
                + "address = ? WHERE admission_no = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getAdmissionNo());
            ps.setString(2, s.getFullName());
            ps.setString(3, s.getGender());
            ps.setDate(4, Date.valueOf(LocalDate.parse(s.getDob(), FORMAT)));
            ps.setString(5, s.getClassName());
            ps.setString(6, s.getGuardianName());
            ps.setString(7, s.getGuardianPhone());
            ps.setString(8, s.getAddress());
            ps.setString(9, originalAdmissionNo);
            ps.executeUpdate();
        }
    }

    public void deleteStudent(String admissionNo) throws SQLException {
        String sql = "DELETE FROM students WHERE admission_no = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, admissionNo);
            ps.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY full_name";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getString("admission_no"),
                        rs.getString("full_name"),
                        rs.getString("gender"),
                        rs.getDate("date_of_birth").toLocalDate().format(FORMAT),
                        rs.getString("class_name"),
                        rs.getString("guardian_name"),
                        rs.getString("guardian_phone"),
                        rs.getString("address")));
            }
        }
        return list;
    }
}