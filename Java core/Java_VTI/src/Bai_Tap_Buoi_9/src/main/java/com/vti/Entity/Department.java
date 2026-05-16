package com.vti.Entity;

public class Department {
    private int departmentId;
    private String departmentName;


    public Department() {
    }

    public Department(int departmentId) {
        this.departmentId = departmentId;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    // Getter và Setter cho departmentId
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // Getter và Setter cho departmentName
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // Ghi đè phương thức toString để dễ dàng debug/in dữ liệu
    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
    // Phương thức hiển thị mỗi thông tin trên một dòng
    public void showInfo() {
        System.out.println("ID phòng ban: " + this.departmentId);
        System.out.println("Tên phòng ban: " + this.departmentName);
        System.out.println("---------------------------"); // Đường kẻ để dễ nhìn hơn
    }
}
