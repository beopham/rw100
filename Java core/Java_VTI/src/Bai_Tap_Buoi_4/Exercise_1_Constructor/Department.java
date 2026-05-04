package Bai_Tap_Buoi_4.Exercise_1_Constructor;

public class Department {
//    Question 1:
//    Tạo constructor cho department:
//    không có parameters
//    Có 1 parameter là nameDepartment và default id của Department = 0
//    Khởi tạo 1 Object với mỗi constructor ở trên

    int departmentID;
    String departmentName;
//    không có parameters
    public Department()
    {

    }
//    Có 1 parameter là nameDepartment và default id của Department = 0

    public Department(String departmentName) {
        this.departmentID = 0;
        this.departmentName = departmentName;
    }

    public void show()
    {
        System.out.println("Department Information ");
        System.out.println("DepartmentID " +departmentID);
        System.out.println("DepartmentName " +departmentName);
        System.out.println("======================");
    }

    public static void main(String[] args) {
//        không có parameters
        Department department_1=new Department();
        department_1.departmentID=1;
        department_1.departmentName="Sale";
        department_1.show();
//        Có 1 parameter là nameDepartment và default id của Department = 0
        Department department_2=new Department("CNTT");
        department_2.show();
    }
}
