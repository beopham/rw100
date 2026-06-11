package com.vti.entity;

import com.vti.enums.Role;

public class Admin extends User{
   private int expInyear;

   public Admin()
   {

   }
    public Admin(int expInyear) {
        this.expInyear = expInyear;
    }

    public Admin(int userId, String fullName, String email, String password, int expInyear) {
        super(userId, fullName, email, password, Role.ADMIN);
        this.expInyear = expInyear;
    }

    public Admin(String fullName, String email, String password, int expInyear) {
        super(fullName, email, password, Role.ADMIN);
        this.expInyear = expInyear;
    }

    public int getExpInyear() {
        return expInyear;
    }

    public void setExpInyear(int expInyear) {
        this.expInyear = expInyear;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "expInyear=" + expInyear +
                '}';
    }

    @Override
    public void show() {
        System.out.println("Thông tin Admin");
        super.show();
        System.out.println("Số năm kinh nghiệm" +getExpInyear());
    }

}
