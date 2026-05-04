package Bai_Tap_Buoi_4.Exercise_2_Package.com.vti.backend;

import Bai_Tap_Buoi_4.Exercise_2_Package.com.vti.entity.Department;

public class Excercise1 {
    public void question1()
    {
        Department department_1=new Department();
        department_1.departmentID=1;
        department_1.departmentName="Sale";
        department_1.show();
    }
    public void question2()
    {
        Department department_2 = new Department("CNTT");
        department_2.show();
    }
}
