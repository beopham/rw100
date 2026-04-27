package Bai_Tap_Buoi_3;

public class Department {
    public int departmentID;
    public String departmentName;

    public void show() {
        System.out.println("Department Information ");
        System.out.println("DepartmentID" + departmentID);
        System.out.println("DepartmentName" + departmentName);
        System.out.println("======================");
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
