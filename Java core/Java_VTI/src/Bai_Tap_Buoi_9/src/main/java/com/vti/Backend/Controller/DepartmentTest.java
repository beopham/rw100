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
        String tenpb ="";
        while (true)
        {
            System.out.println("Nhập vào tên phòng ban");
            tenpb=sc.nextLine();
            if(tenpb==null || tenpb.trim().isEmpty())
            {
                System.out.println("K đc để tên trống phòng ban");
                continue;
            }
            tenpb = tenpb.trim();
            if (departmentController.checkName(tenpb))
            {
                System.out.println("Tên phòng ban tồn tại rồi");
                continue;
            }
            break;
        }

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
        int idpb;
        while (true)
        {
            System.out.println("Nhập vào tên id phòng ban");
            idpb=sc.nextInt();
            sc.nextLine();
            if(idpb<0)
            {
                System.out.println("Bạn nên nhập id lớn hơn 0");
                continue;
            }
            if(!departmentController.checkId(idpb))
            {
                System.out.println("ID k tồn tại");
                continue;
            }

            // ID hợp lệ và tồn tại rồi -> Thoát khỏi vòng lặp while ngay lập tức để xuống dòng xóa
            break;
        }
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
        int idpb;
        String tenpb;
        while (true)
        {
            System.out.println("Nhập vào tên id phòng ban");
            idpb=sc.nextInt();
            sc.nextLine();
            if(idpb<0)
            {
                System.out.println("Bạn nên nhập id lớn hơn 0");
                continue;
            }
            if(!departmentController.checkId(idpb))
            {
                System.out.println("ID k tồn tại");
                continue;
            }
            // ID hợp lệ và tồn tại rồi -> Thoát khỏi vòng lặp while ngay lập tức để xuống dòng xóa
            break;
        }
        while (true)
        {
            System.out.println("Nhập vào tên phòng ban");
            tenpb=sc.nextLine();
            if(tenpb==null || tenpb.trim().isEmpty())
            {
                System.out.println("K đc để tên trống phòng ban");
                continue;
            }
            tenpb = tenpb.trim();
            if(departmentController.checkExistNameAndIdNot(tenpb,idpb))
            {
                System.out.println("Tên phòng ban này đã tồn tại ở một phòng ban khác rồi! Vui lòng nhập tên khác.");
                continue;
            }
            break;
        }
        Department department=departmentController.selectByid(idpb);
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
