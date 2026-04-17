package Pham_Van_Nam_VTI_BUOI_1;

import java.time.LocalDate;

public class Account {
    int AccountID;
    String Username;
    Department department;
    Position position;
    LocalDate localDate;
    public void show() {
        System.out.println("Account Information ");
        System.out.println("AccountID: " + AccountID);
        System.out.println("Username: "  + Username);
        System.out.println("Department"  + department.DepartmentID);
        System.out.println("Position"    + position.PositionID);
        System.out.println("Create Date: " + localDate);
        System.out.println("======================");
    }

}
