package Bai_Tap_Buoi_7.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Account {
    private int accountId;
    private String email;
    private String username;
    private String fullName;
    private Department department; // Liên kết đến đối tượng Department
    private Position position;     // Liên kết đến đối tượng Position
    private LocalDateTime createDate;

    // Constructor không tham số
    public Account(int id, String email, String userName, String fullName, Department department, Position position, LocalDate createDate) {
    }

    public Account(String email, String username, String fullName, Department department, Position position, LocalDateTime createDate) {
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }

    // Constructor có tham số
    public Account(int accountId, String email, String username, String fullName,
                   Department department, Position position, LocalDateTime createDate) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + (department != null ? department.getDepartmentName() : "null") +
                ", position=" + (position != null ? position.getPositionName() : "null") +
                ", createDate=" + createDate +
                '}';
    }

    public void showInfo() {
        System.out.println("ID Tài khoản   : " + this.accountId);
        System.out.println("Email         : " + this.email);
        System.out.println("Tên đăng nhập : " + this.username);
        System.out.println("Họ và Tên     : " + this.fullName);

        // 1. In thông tin Phòng ban (ID và Name)
        if (this.department != null) {
            System.out.println("Phòng ban (ID): " + this.department.getDepartmentId());
            System.out.println("Phòng ban (Tên): " + this.department.getDepartmentName());
        } else {
            System.out.println("Phòng ban     : Trống");
        }

        // 2. In thông tin Chức vụ (ID và Name)
        if (this.position != null) {
            System.out.println("Chức vụ (ID)  : " + this.position.getPositionId());
            System.out.println("Chức vụ (Tên) : " + this.position.getPositionName());
        } else {
            System.out.println("Chức vụ       : Trống");
        }

        System.out.println("Ngày tạo      : " + this.createDate);
        System.out.println("------------------------------------");
    }
}