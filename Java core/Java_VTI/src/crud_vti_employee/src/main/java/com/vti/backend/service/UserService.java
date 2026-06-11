package com.vti.backend.service;

import com.vti.entity.Employee;
import com.vti.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(int id);
    public void deleteById(int id) ;
    public User login(String email, String password);
    public void insertEmplyee(Employee employee);
}
