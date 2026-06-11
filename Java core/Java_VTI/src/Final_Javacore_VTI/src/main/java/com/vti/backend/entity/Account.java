package com.vti.backend.entity;

public class Account {
    private int accountId;
    private String email;
    private String password;
    private String fullName;

    public Account()
    {

    }
    // Constructor không có accountId (dùng khi tạo mới trước khi lưu vào DB)
    public Account(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    // Constructor có accountId (dùng khi lấy từ DB)
    public Account(int accountId, String email, String password, String fullName) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // toString để in thông tin
    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}