package com.vti.entity;

import com.vti.enums.GraduationRank;
import com.vti.enums.Role;

public class FresherCandidate extends Candidate{
    private GraduationRank graduationRank;

    public FresherCandidate()
    {
       super();
    }
    public FresherCandidate(GraduationRank graduationRank) {
        this.graduationRank = graduationRank;
    }

    public FresherCandidate(String firstName, String lastName, String phone, String email, String password, Role role, GraduationRank graduationRank) {
        super(firstName, lastName, phone, email, password, role);
        this.graduationRank = graduationRank;
    }

    public FresherCandidate(int id, String firstName, String lastName, String phone, String email, String password, Role role, GraduationRank graduationRank) {
        super(id, firstName, lastName, phone, email, password, role);
        this.graduationRank = graduationRank;
    }

    public GraduationRank getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(GraduationRank graduationRank) {
        this.graduationRank = graduationRank;
    }

    @Override
    public void showInfo() {
        System.out.println("Thông tin nhân viên fresher");
        super.showInfo();
        System.out.println("hạng tốt nghiệp" +this.graduationRank);
    }
}
