package Bai_Tap_Buoi_4.Exercise_3_Access_Modifier.entity;

import java.time.LocalDate;

public class Account {
    private int accountID;
    private String email;
    private String username;
    private Department department;
    private Position position;
    private LocalDate localDate;
    private String firstName;
    private String lastName;
    private String fullName;

    // --- GETTER & SETTER (Giữ nguyên của bạn) ---
    public int getAccountID() { return accountID; }
    public void setAccountID(int accountID) { this.accountID = accountID; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }

    public LocalDate getLocalDate() { return localDate; }
    public void setLocalDate(LocalDate localDate) { this.localDate = localDate; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    // --- CONSTRUCTORS (Đã FIX lỗi tên biến) ---
    public Account() {
    }

    public Account(int accountID, String email, String username, String firstName, String lastName) {
        this.accountID = accountID; // Dùng this. vì tên tham số trùng tên biến private
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    public Account(int accountID, String email, String username, Position position, String firstName, String lastName) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.position = position;
        this.localDate = LocalDate.now();
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    public Account(int accountID, String email, String username, Position position, LocalDate localDate, String firstName, String lastName) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.position = position;
        this.localDate = localDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    // --- SHOW METHODS (Đã FIX lỗi tên biến) ---
    public void show_1() {
        System.out.println("Account Information ");
        System.out.println("AccountID: " + this.accountID); // Gọi đúng biến đã khai báo
        System.out.println("Email: " + this.email);
        System.out.println("Username: " + this.username);
        System.out.println("Full Name: " + this.fullName);
        System.out.println("======================");
    }

    public void show_2() {
        System.out.println("--- Chi tiết tài khoản (Full Details) ---");
        System.out.println("ID          : " + this.accountID);
        System.out.println("Email       : " + this.email);
        System.out.println("Username    : " + this.username);
        System.out.println("Full Name   : " + this.fullName);

        if (this.position != null) {
            // Lưu ý: class Position cũng phải để các biến là public hoặc dùng getter
            System.out.println("Chức vụ     : " + this.position.getPositionName());
        } else {
            System.out.println("Chức vụ     : Chưa xác định");
        }

        System.out.println("Ngày tạo    : " + this.localDate);
        System.out.println("-----------------------------------------");
    }
}