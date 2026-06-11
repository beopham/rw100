package com.vti.backend.service.impl;

import com.vti.backend.repository.UserRepository;
import com.vti.backend.repository.impl.UserRepositoryImpl;
import com.vti.backend.service.UserService;
import com.vti.entity.Employee;
import com.vti.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository=new UserRepositoryImpl();
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
         userRepository.deleteById(id);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.login(email,password);
    }

    @Override
    public void insertEmplyee(Employee employee) {
            userRepository.insertEmplyee(employee);
    }
}
