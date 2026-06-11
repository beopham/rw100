package com.vti.backend.controller;

import com.vti.backend.entity.Student;
import com.vti.backend.service.StudentService;
import com.vti.backend.service.impl.StudentServiceImpl;

import java.util.List;

public class ControllerStudent {
    private StudentService studentService=new StudentServiceImpl();

    public List<Student> findAll() {
        return studentService.findAll();
    }

    public boolean inertStudent(Student student) {
        return studentService.inertStudent(student);
    }


    public boolean updateStudent(Student student) {
        return studentService.updateStudent(student);
    }


    public Student findById(int id) {
        return  studentService.findById(id);
    }


    public boolean deleteStudent(int id) {
        return  studentService.deleteStudent(id);
    }


    public List<Student> findByMajor(String major_name) {
        return  studentService.findByMajor(major_name);
    }


    public boolean checkEmailExist(String email) {
        return  studentService.checkEmailExist(email);
    }
}
