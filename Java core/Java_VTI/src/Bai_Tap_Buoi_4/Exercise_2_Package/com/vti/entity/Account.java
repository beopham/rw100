package Bai_Tap_Buoi_4.Exercise_2_Package.com.vti.entity;

import java.time.LocalDate;

public class Account {
    int AccountID;
    String Email;
    String Username;
    Department department;
    Position position;
    LocalDate localDate;
    String FirstName;
    String LastName;
    String fullName;

    public Account() {
    }

    public Account(int accountID, String email, String username, String firstName, String lastName) {
        AccountID = accountID;
        Email = email;
        Username = username;
        FirstName = firstName;
        LastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    public Account(int accountID, String email, String username, Position position, String firstName, String lastName) {
        AccountID = accountID;
        Email = email;
        Username = username;
        this.position = position;
        this.localDate = LocalDate.now();
        FirstName = firstName;
        LastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    public Account(int accountID, String email, String username, Position position, LocalDate localDate, String firstName, String lastName) {
        AccountID = accountID;
        Email = email;
        Username = username;
        this.position = position;
        this.localDate = localDate;
        FirstName = firstName;
        LastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    public void show_1() {
        System.out.println("Account Information ");
        System.out.println("AccountID: " + AccountID);
        System.out.println("Email: " + Email);
        System.out.println("Username: " + Username);
        System.out.println("Full Name: " + fullName);
        System.out.println("======================");
    }

    public void show_2() {
        System.out.println("--- Chi tiết tài khoản (Full Details) ---");
        System.out.println("ID          : " + AccountID);
        System.out.println("Email       : " + Email);
        System.out.println("Username    : " + Username);
        System.out.println("Full Name   : " + this.fullName);

        if (this.position != null) {
            System.out.println("Chức vụ     : " + this.position.positionName);
        } else {
            System.out.println("Chức vụ     : Chưa xác định");
        }

        System.out.println("Ngày tạo    : " + this.localDate);
        System.out.println("-----------------------------------------");
    }
}