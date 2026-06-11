package com.vti.backend.controller;

import com.vti.backend.repository.UserRepository;
import com.vti.backend.repository.impl.UserRepositoryImpl;
import com.vti.backend.service.UserService;
import com.vti.backend.service.impl.UserServiceImpl;
import com.vti.entity.Employee;
import com.vti.entity.User;

import java.util.List;

public class UserController {
    private UserService userService=new UserServiceImpl();

    public List<User> findAll() {
        return userService.findAll();
    }
    public User findById(int id) {
        return userService.findById(id);
    }
    public void deleteById(int id) {
        userService.deleteById(id);
    }
    public User login(String email, String password) {
        return userService.login(email,password);
    }

    public void insertEmplyee(Employee employee) {
        userService.insertEmplyee(employee);
    }
}
