package com.vti.entity;

import com.vti.enums.Role;

public class ExperienceCandidate extends Candidate {
    // Chỉ khai báo các thuộc tính đặc trưng của class con
    private int expInYear;
    private String proSkill;

    // Constructor không tham số
    public ExperienceCandidate() {
        super();
    }

    // Constructor dành cho các thuộc tính riêng của class con
    public ExperienceCandidate(int expInYear, String proSkill) {
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public ExperienceCandidate(int id, String firstName, String lastName, String phone, String email, String password, Role role, int expInYear, String proSkill) {
        super(id, firstName, lastName, phone, email, password, role);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public ExperienceCandidate(String firstName, String lastName, String phone, String email, String password, Role role, int expInYear, String proSkill) {
        super(firstName, lastName, phone, email, password, role);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        System.out.println("Thông tin nhân viên có kinh nghiệm");
        super.showInfo();
        System.out.println("expInYear :" +this.expInYear);
        System.out.println("proSkill  :" +this.proSkill);

    }
}