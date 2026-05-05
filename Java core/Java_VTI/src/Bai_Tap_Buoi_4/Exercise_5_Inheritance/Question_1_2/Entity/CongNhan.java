package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity;

import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Enums.GioiTinh;

public class CongNhan extends  CanBo{
    private int bac;
    public CongNhan()
    {

    }

    public CongNhan(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, int bac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.bac = bac;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    @Override
    public void showinfor() {
        System.out.println("Thông Tin Công Nhân");
        super.showinfor();
        System.out.println("Bậc "+ this.getBac());
    }

}
