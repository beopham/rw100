package Bai_Tap_Buoi_3;

import java.time.LocalDate;

public class Account {
    public String FullName;
    int AccountID;
    public String email;
    public String Username;
    Department department;
    Position position;
    public LocalDate localDate;
    Group[] groups;

    public void show() {
        System.out.println("Account Information ");
        System.out.println("AccountID: " + AccountID);
        System.out.println("Email"      + email);
        System.out.println("Username: " + Username);
        System.out.println("Department" + department.departmentID);
        System.out.println("Position" + position.PositionID);
        System.out.println("Create Date: " + localDate);
        System.out.println("======================");
    }

}
