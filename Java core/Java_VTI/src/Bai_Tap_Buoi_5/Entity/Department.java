package Bai_Tap_Buoi_5.Entity;

public class Department {
    private int departmentId;
    private String departmentName;

    // Constructor không tham số
    public Department() {
    }

    // Constructor đầy đủ tham số
    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    // Getter và Setter
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    // Hàm showInfo() mỗi thuộc tính trên 1 dòng
    public void showInfo() {
        System.out.println("Department ID: " + this.departmentId);
        System.out.println("Department Name: " + this.departmentName);
    }
}