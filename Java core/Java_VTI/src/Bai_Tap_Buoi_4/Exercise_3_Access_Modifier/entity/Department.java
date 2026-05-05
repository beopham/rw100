package Bai_Tap_Buoi_4.Exercise_3_Access_Modifier.entity;

public class Department {
    private int departmentID;
    private String departmentName;

    // --- Getter và Setter ---
    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // --- Constructors ---

    // 1. Không có parameters
    public Department() {
    }

    // 2. Có 1 parameter là departmentName, default id = 0
    public Department(String departmentName) {
        this.departmentID = 0;
        this.departmentName = departmentName;
    }

    // --- Method hiển thị thông tin ---
    public void show() {
        System.out.println("Department Information ");
        // Sử dụng this để truy cập biến private nội bộ
        System.out.println("DepartmentID: " + this.departmentID);
        System.out.println("DepartmentName: " + this.departmentName);
        System.out.println("======================");
    }
}