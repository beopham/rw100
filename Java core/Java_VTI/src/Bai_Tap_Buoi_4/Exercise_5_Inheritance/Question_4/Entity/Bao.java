package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Entity;

import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Service.Showinfor;

public class Bao extends TaiLieu {
    private int ngayPhatHanh;

    public Bao()
    {

    }

    public Bao(String maTaiLieu, String tenNXB, int soBanPhatHanh, int ngayPhatHanh) {
        super(maTaiLieu, tenNXB, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public int getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(int ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public void show() {
        System.out.println("---------- THÔNG TIN BÁO ----------");
        System.out.println("Mã tài liệu: " + getMaTaiLieu());
        System.out.println("Tên nhà xuất bản: " + getTenNXB());
        System.out.println("Số bản phát hành: " + getSoBanPhatHanh());
        System.out.println("Ngày phát hành: " + this.ngayPhatHanh);
        System.out.println("-----------------------------------");
    }
}
