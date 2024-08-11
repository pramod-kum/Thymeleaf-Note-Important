package com.bmt.school.models;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "student_registration")
public class StudentRegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String fatherName;
    private String motherName;
    private String address;
    private String studentClass; // Renamed to avoid conflict with Java's 'class' keyword
    private String phoneNumber;
    private String email;
    private String dob; // Date of Birth
    private String gender;
    private String emergencyContact;

    public StudentRegistrationEntity() {
    }

    public StudentRegistrationEntity(Long id, String studentName, String fatherName, String motherName, String address, String studentClass, String phoneNumber, String email, String dob, String gender, String emergencyContact) {
        this.id = id;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.address = address;
        this.studentClass = studentClass;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.emergencyContact = emergencyContact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
