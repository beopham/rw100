package com.vti.entity;

import com.vti.enums.Role;

public class Employee extends User{
    private String proSkill;

    public Employee() {

    }
    public Employee(String proSkill) {
        this.proSkill = proSkill;
    }

    public Employee(int userId, String fullName, String email, String password, String proSkill) {
        super(userId, fullName, email, password, Role.EMPLOYEE);
        this.proSkill = proSkill;
    }

    public Employee(String fullName, String email, String password, String proSkill) {
        super(fullName, email, password, Role.EMPLOYEE);
        this.proSkill = proSkill;
    }

    public Employee(String fullName, String email, String proSkill) {
        super(fullName, email);
        this.proSkill = proSkill;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public void show() {
        System.out.println("Thông tin về Employee");
        super.show();
        System.out.println("Kĩ năng của nhân viên " +this.proSkill);
    }
}
