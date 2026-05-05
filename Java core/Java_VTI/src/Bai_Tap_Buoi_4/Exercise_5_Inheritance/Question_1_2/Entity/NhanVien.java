package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity;

import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Enums.GioiTinh;

public class NhanVien extends CanBo{
    private String congViec;

    public NhanVien()
    {

    }

    public NhanVien(String congViec) {
        this.congViec = congViec;
    }

    public NhanVien(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, String congViec) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    @Override
    public void showinfor() {
        System.out.println("Thông Tin Nhân Viên");
        super.showinfor();
        System.out.println("Công Việc "+ this.getCongViec());
    }
}
