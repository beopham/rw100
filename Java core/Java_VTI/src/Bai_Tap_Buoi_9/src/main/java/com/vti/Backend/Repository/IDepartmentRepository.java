package com.vti.Backend.Repository;

import com.vti.Entity.Department;

import java.util.List;

public interface IDepartmentRepository {
    public List<Department> findAll();
    public boolean Insert(Department department);
    public boolean Update(Department department);
    public boolean Delete(int id);
    public Department selectByid(int id);
}
