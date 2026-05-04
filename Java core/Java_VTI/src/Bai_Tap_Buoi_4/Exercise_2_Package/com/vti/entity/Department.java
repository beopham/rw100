package Bai_Tap_Buoi_4.Exercise_2_Package.com.vti.entity;

public class Department {
//    Question 1:
//    Tạo constructor cho department:
//    không có parameters
//    Có 1 parameter là nameDepartment và default id của Department = 0
//    Khởi tạo 1 Object với mỗi constructor ở trên

    public int departmentID;
    public String departmentName;

    //    không có parameters
    public Department() {

    }
//    Có 1 parameter là nameDepartment và default id của Department = 0

    public Department(String departmentName) {
        this.departmentID = 0;
        this.departmentName = departmentName;
    }

    public void show() {
        System.out.println("Department Information ");
        System.out.println("DepartmentID " + departmentID);
        System.out.println("DepartmentName " + departmentName);
        System.out.println("======================");
    }
}
