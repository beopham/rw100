package com.vti.Backend.Service;

import com.vti.Entity.Department;

import java.util.List;

public interface IDepartmentService {
   public List<Department> findAll();
   public boolean Insert(Department department);
   public boolean Update(Department department);
   public boolean Delete(int id);
   public Department selectByid(int id);
   public boolean checkId(int id);
   public boolean checkName(String name);
   public boolean checkExistNameAndIdNot(String name, int id);
   public  boolean importDepartmentFromCSV(String pathName);
}
