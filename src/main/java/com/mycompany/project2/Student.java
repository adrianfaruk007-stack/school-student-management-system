package com.mycompany.project2;

public class Student {

    private final String admissionNo;
    private final String fullName;
    private final String gender;
    private final String dob;          // kept as dd/MM/yyyy text, like the table
    private final String className;
    private final String guardianName;
    private final String guardianPhone;
    private final String address;

    public Student(String admissionNo, String fullName, String gender, String dob,
                   String className, String guardianName, String guardianPhone, String address) {
        this.admissionNo = admissionNo;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.className = className;
        this.guardianName = guardianName;
        this.guardianPhone = guardianPhone;
        this.address = address;
    }

    public String getAdmissionNo() { return admissionNo; }
    public String getFullName() { return fullName; }
    public String getGender() { return gender; }
    public String getDob() { return dob; }
    public String getClassName() { return className; }
    public String getGuardianName() { return guardianName; }
    public String getGuardianPhone() { return guardianPhone; }
    public String getAddress() { return address; }
}