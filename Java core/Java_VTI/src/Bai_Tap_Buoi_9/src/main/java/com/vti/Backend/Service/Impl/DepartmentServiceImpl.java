package com.vti.Backend.Service.Impl;

import com.vti.Backend.Repository.IDepartmentRepository;
import com.vti.Backend.Repository.Impl.DepartmentRepositoryImpl;
import com.vti.Backend.Service.IDepartmentService;
import com.vti.Entity.Department;

import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    private IDepartmentRepository departmentRepository=new DepartmentRepositoryImpl();
    @Override
    public List<Department> findAll() {
        List<Department> departmentList=departmentRepository.findAll();
        return departmentList;
    }

    @Override
    public boolean Insert(Department department) {
        boolean them= departmentRepository.Insert(department);
        return them;
    }

    @Override
    public boolean Update(Department department) {
        boolean sua= departmentRepository.Update(department);
        return sua;
    }

    @Override
    public boolean Delete(int id)
    {
        boolean them= departmentRepository.Delete(id);
        return them;
    }

    @Override
    public Department selectByid(int id)
    {
        Department department=departmentRepository.selectByid(id);
        return department;
    }

    @Override
    public boolean checkId(int id) {
        return departmentRepository.checkId(id);
    }

    @Override
    public boolean checkName(String name) {
        return departmentRepository.checkName(name);
    }

    @Override
    public boolean checkExistNameAndIdNot(String name, int id) {
        return departmentRepository.checkExistNameAndIdNot(name,id);
    }

    @Override
    public boolean importDepartmentFromCSV(String pathName) {
        return departmentRepository.importDepartmentFromCSV(pathName);
    }

}
