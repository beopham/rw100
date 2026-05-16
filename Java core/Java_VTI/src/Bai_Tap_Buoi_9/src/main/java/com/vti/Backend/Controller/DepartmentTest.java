package com.vti.Backend.Controller;

import com.vti.Entity.Department;

import java.util.List;
import java.util.Scanner;

public class DepartmentTest {
    private DepartmentController departmentController=new DepartmentController();
    private Scanner sc=new Scanner(System.in);
    public void showAllDepartment()
    {
        List<Department> departmentList =departmentController.findAll();
        if(departmentList.isEmpty() || departmentList ==null)
        {
            System.out.println("K có danh sách phòng ban");
            return;
        }
        for (Department department : departmentList )
        {
            department.showInfo();
        }
    }
    public void insertDepartment()
    {
        System.out.println("Nhập vào tên phòng ban");
        String tenpb=sc.nextLine();
        Department department=new Department(tenpb);
        boolean them= departmentController.Insert(department);
        if(them==true)
        {
            System.out.println("thêm thành công");
        }
        else
        {
            System.out.println("thêm thất bại");
        }
    }
    public void deleteDepartment()
    {
        System.out.println("Nhập vào tên id phòng ban");
        int idpb=sc.nextInt();
        sc.nextLine();
        boolean them= departmentController.Delete(idpb);
        if(them==true)
        {
            System.out.println("xoá thành công");
        }
        else
        {
            System.out.println("xóa thất bại");
        }
    }
    public void updateDepartment()
    {
        System.out.println("Nhập vào tên id phòng ban");
        int idpb=sc.nextInt();
        sc.nextLine();
        Department department=departmentController.selectByid(idpb);
        if(department==null)
        {
            System.out.println("k có phòng ban chứa id");
            return;
        }
        System.out.println("Nhập vào tên phòng ban");
        String tenpb=sc.nextLine();
        department.setDepartmentName(tenpb);
        department.setDepartmentId(idpb);
        if(departmentController.Update(department))
        {
            System.out.println("cập nhập thành công");
        }
        else
        {
            System.out.println("k cập nhập thành công");
        }
    }
}
