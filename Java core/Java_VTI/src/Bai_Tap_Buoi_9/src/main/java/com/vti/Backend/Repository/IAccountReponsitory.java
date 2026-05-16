package com.vti.Backend.Repository;

import com.vti.Entity.Account;
import com.vti.Entity.Department;

import java.util.List;

public interface IAccountReponsitory {
    public List<Account> findAll();
    public boolean Insert(Account account);
    public boolean Update(Account account);
    public boolean Delete(int id);
    public Account selectByid(int id);
}
