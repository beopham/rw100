package com.vti.Backend.Controller;

import com.vti.Backend.Service.IAccountService;
import com.vti.Backend.Service.Impl.AccountServiceImpl;
import com.vti.Entity.Account;

import java.util.List;

public class AccountController {
    private IAccountService iAccountService=new AccountServiceImpl();

    public List<Account> findAll() {
        return iAccountService.findAll();
    }

    public boolean Insert(Account account) {
        return iAccountService.Insert(account);
    }
    public boolean Update(Account account) {
        return iAccountService.Update(account);
    }

    public boolean Delete(int id) {
        return iAccountService.Delete(id);
    }

    public Account selectByid(int id) {
        return iAccountService.selectByid(id);
    }
}
