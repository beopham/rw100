package com.vti.backend.entity;

public class Lecturer {

    private int lecturer_id;
    private String full_name;
    private String email;
    private String department;

    public Lecturer()
    {

    }

    public Lecturer(int lecturer_id, String full_name, String email, String department) {
        this.lecturer_id = lecturer_id;
        this.full_name = full_name;
        this.email = email;
        this.department = department;
    }

    public Lecturer(String full_name, String email, String department) {
        this.full_name = full_name;
        this.email = email;
        this.department = department;
    }

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturer_id=" + lecturer_id +
                ", full_name='" + full_name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
