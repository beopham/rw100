package com.vti.Backend.Controller;

import com.vti.Backend.Service.IDepartmentService;
import com.vti.Backend.Service.Impl.DepartmentServiceImpl;
import com.vti.Entity.Department;
import com.vti.Enums.PositionName;

import java.util.List;

public class DepartmentController {
    private IDepartmentService iDepartmentService=new DepartmentServiceImpl();

    public List<Department> findAll() {
        List<Department> departmentList=iDepartmentService.findAll();
        return departmentList;
    }

    public boolean Insert(Department department) {
        boolean them= iDepartmentService.Insert(department);
        return them;
    }

    public boolean Update(Department department) {
        boolean sua= iDepartmentService.Update(department);
        return sua;
    }

    public boolean Delete(int id)
    {
        boolean them= iDepartmentService.Delete(id);
        return them;
    }

    public Department selectByid(int id)
    {
        Department department=iDepartmentService.selectByid(id);
        return department;
    }
    public boolean checkId(int id) {
        return iDepartmentService.checkId(id);
    }
    public boolean checkName(String name) {
        return iDepartmentService.checkName(name);
    }
    public boolean checkExistNameAndIdNot(String name, int id) {
        return iDepartmentService.checkExistNameAndIdNot(name,id);
    }
    public boolean importDepartmentFromCSV(String pathName) {
        return iDepartmentService.importDepartmentFromCSV(pathName);
    }

}
