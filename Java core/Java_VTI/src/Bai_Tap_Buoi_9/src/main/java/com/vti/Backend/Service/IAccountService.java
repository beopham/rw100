package com.vti.Backend.Service;

import com.vti.Entity.Account;
import com.vti.Entity.Department;

import java.util.List;

public interface IAccountService {
    public List<Account> findAll();
    public boolean Insert(Account account);
    public boolean Update(Account account);
    public boolean Delete(int id);
    public Account selectByid(int id);
    public boolean checkUsernameExist(String username);
    public boolean checkEmailExist(String email);
    public boolean checkAccountIdExist(int id);
    public boolean importAccountFromCSV(String pathName);
}
