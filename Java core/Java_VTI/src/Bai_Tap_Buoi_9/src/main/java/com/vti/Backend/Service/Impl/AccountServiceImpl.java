package com.vti.Backend.Service.Impl;

import com.vti.Backend.Repository.IAccountReponsitory;
import com.vti.Backend.Repository.Impl.AccountReponsitoryImpl;
import com.vti.Backend.Service.IAccountService;
import com.vti.Entity.Account;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountReponsitory iAccountReponsitory = new AccountReponsitoryImpl();

    @Override
    public List<Account> findAll() {
        return iAccountReponsitory.findAll();
    }

    @Override
    public boolean Insert(Account account) {
        return iAccountReponsitory.Insert(account);
    }

    @Override
    public boolean Update(Account account) {
        return iAccountReponsitory.Update(account);
    }

    @Override
    public boolean Delete(int id) {
        return iAccountReponsitory.Delete(id);
    }

    @Override
    public Account selectByid(int id) {
        return iAccountReponsitory.selectByid(id);
    }

    @Override
    public boolean checkUsernameExist(String username) {
        return iAccountReponsitory.checkUsernameExist(username);
    }

    @Override
    public boolean checkEmailExist(String email) {
        return iAccountReponsitory.checkEmailExist(email);
    }

    @Override
    public boolean checkAccountIdExist(int id) {
        return iAccountReponsitory.checkAccountIdExist(id);
    }

    @Override
    public boolean importAccountFromCSV(String pathName) {
        return iAccountReponsitory.importAccountFromCSV(pathName);
    }
}
