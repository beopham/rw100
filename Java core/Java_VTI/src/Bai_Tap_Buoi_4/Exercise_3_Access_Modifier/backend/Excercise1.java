package Bai_Tap_Buoi_4.Exercise_3_Access_Modifier.backend;

import Bai_Tap_Buoi_4.Exercise_3_Access_Modifier.entity.Department;

public class Excercise1 {
    public void question1()
    {
        Department department_1=new Department();
        department_1.setDepartmentID(1);
        department_1.setDepartmentName("Sale");
        department_1.show();
    }
    public void question2()
    {
        Department department_2 = new Department("CNTT");
        department_2.show();
    }
}
