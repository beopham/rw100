package com.vti.backend.entity;

import java.time.LocalDate;

public class Student {
    private int studentId;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private Major majorId;

    public Student()
    {

    }

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public Student(int studentId, String fullName, String email, LocalDate dateOfBirth, Major majorId) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.majorId = majorId;
    }

    public Student(String fullName, String email, LocalDate dateOfBirth, Major majorId) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.majorId = majorId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Major getMajorId() {
        return majorId;
    }

    public void setMajorId(Major majorId) {
        this.majorId = majorId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", majorId=" + majorId +
                '}';
    }
    public void showInfo() {
        System.out.println("--- THÔNG TIN SINH VIÊN ---");
        System.out.println("ID           : " + this.studentId);
        System.out.println("Họ tên       : " + this.fullName);
        System.out.println("Email        : " + this.email);
        System.out.println("Ngày sinh    : " + this.dateOfBirth);
        System.out.println("Chuyên ngành : " + this.majorId);
        System.out.println("---------------------------");
    }
}
