package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity;

import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Enums.GioiTinh;

public class CanBo {
    private String hoTen;
    private int tuoi;
    private GioiTinh gioiTinh; // Nam, Nữ, Khác
    private String diaChi ;

    public CanBo()
    {

    }

    public CanBo(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public void showinfor()
    {
        System.out.println("Họ tên: " + this.getHoTen());
        System.out.println("Tuổi: " + this.getTuoi());
        System.out.println("Giới tính: " + this.getGioiTinh());
        System.out.println("Địa chỉ: " + this.getDiaChi());
    }
}
