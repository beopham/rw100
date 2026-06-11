package com.vti.backend.service;

import com.vti.backend.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public boolean inertStudent(Student student);
    public boolean updateStudent(Student student);
    public Student findById(int id);
    public boolean deleteStudent(int id);
    public List<Student> findByMajor(String major_name);
    public boolean checkEmailExist(String email);
}
