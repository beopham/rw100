package com.vti.entity;

import com.vti.enums.Role;

public class User {

    private int userId;
    private String fullName;
    private String email;
    private String password;
    private Role role;

    public User()
    {

    }

    public User(int userId, String fullName, String email, String password, Role role) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String fullName, String email, String password, Role role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public User(int userId, String fullName, String email) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public void show() {
        System.out.println("ID: " + this.userId);
        System.out.println("Full Name: " + this.fullName);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password); // Mật khẩu 123 của bạn nè
        System.out.println("Role: " + this.getRole()); // Mật khẩu 123 của bạn nè
    }
    public void showShortInfo() {
        System.out.println("---------------------------------");
        System.out.println("ID       : " + this.userId);
        System.out.println("Full Name: " + this.fullName);
        System.out.println("Email    : " + this.email);
    }

}
