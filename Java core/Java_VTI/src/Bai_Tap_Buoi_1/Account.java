package Bai_Tap_Buoi_1;

import java.time.LocalDate;

public class Account {
    int AccountID;
    String email;
    String Username;
    Department department;
    Position position;
    LocalDate localDate;
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
