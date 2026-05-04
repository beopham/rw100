package Bai_Tap_Buoi_4.Exercise_1_Constructor;

import java.time.LocalDate;

public class Account {
    public int AccountID;
    public String Email;
    public String Username;
    public Department department;
    public Position position;
    public LocalDate localDate;
    public String FirstName;
    public String LastName;
    public String fullName;

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

    public static void main(String[] args) {
        Position pos = new Position();
        pos.PositionID = 1;
        pos.positionName = PositionName.DEV;

        Account acc1 = new Account();
        acc1.AccountID = 1;
        acc1.Email = "nam.vku@gmail.com";
        acc1.Username = "nam_vku";
        acc1.FirstName = "Phạm";
        acc1.LastName = "Nam";
        acc1.fullName = acc1.FirstName + " " + acc1.LastName; // Tự ghép logic fullName
        acc1.position = pos; // Gán đối tượng Position đã tạo ở trên
        acc1.localDate = LocalDate.now(); // Gán ngày hiện tại
        Account acc2 = new Account(1, "nam.pv@gmail.com", "nam_vku", "Phạm", "Nam");

        Account acc3 = new Account(2, "vti.academy@gmail.com", "vti_student", pos, "Nguyễn", "An");

        Account acc4 = new Account(3, "test.user@yahoo.com", "tester_01", pos, LocalDate.of(2025, 12, 25), "Lê", "Bình");

        acc1.show_1();
        acc2.show_2();
        acc3.show_2();
        acc4.show_2();
    }
}