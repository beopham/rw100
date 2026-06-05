package com.vti.entity;

import com.vti.enums.Role;

public class Candidate {
    // 1. Sửa thành chữ thường đầu câu theo chuẩn lowerCamelCase
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private Role role; // Thuộc tính d


    public Candidate()
    {

    }

    public Candidate(int id, String firstName, String lastName, String phone, String email, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Candidate(String firstName, String lastName, String phone, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void showInfo() {
        System.out.println("ID: " + this.id);
        System.out.println("First Name: " + this.firstName);
        System.out.println("Last Name: " + this.lastName);
        System.out.println("Phone: " + this.phone);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Role: " + this.role);
        System.out.println("--------------------------");
    }

}