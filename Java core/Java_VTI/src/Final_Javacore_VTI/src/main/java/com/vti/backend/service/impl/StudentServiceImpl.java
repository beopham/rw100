package com.vti.backend.service.impl;

import com.vti.backend.entity.Student;
import com.vti.backend.repository.StudentRepository;
import com.vti.backend.repository.impl.StudentRepositoryImpl;
import com.vti.backend.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository=new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean inertStudent(Student student) {
        return studentRepository.inertStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public List<Student> findByMajor(String major_name) {
        return studentRepository.findByMajor(major_name);
    }

    @Override
    public boolean checkEmailExist(String email) {
        return studentRepository.checkEmailExist(email);
    }
}
