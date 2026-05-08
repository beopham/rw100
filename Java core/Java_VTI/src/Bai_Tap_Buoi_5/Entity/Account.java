package Bai_Tap_Buoi_5.Entity;

import java.time.LocalDate;

public class Account {
    private int accountId;
    private String email;
    private String username;
    private String fullName;
    private Department department; // Đối tượng Department
    private Position position;     // Đối tượng Position
    private LocalDate createDate;

    public Account() {
    }

    public Account(int accountId, String email, String username, String fullName,
                   Department department, Position position, LocalDate createDate) {
        this.accountId = accountId;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }

    // Getter và Setter
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void showInfo() {
        System.out.println("Account ID: " + this.accountId);
        System.out.println("Email: " + this.email);
        System.out.println("Username: " + this.username);
        System.out.println("Full Name: " + this.fullName);
        if (department == null) {
            System.out.println("Chưa vào phòng ban nào");
        } else {
            System.out.println("Department ID: "   + this.getDepartment().getDepartmentId());
            System.out.println("Department Name: " + this.getDepartment().getDepartmentName());
        }
        if (position == null) {
            System.out.println("Chưa vào vị trí nào");
        } else {
            System.out.println("Position ID: "   + this.getPosition().getPositionId());
            System.out.println("Position Name: " + this.getPosition().getPositionName());
        }

        System.out.println("Create Date: " + this.createDate);
    }
}