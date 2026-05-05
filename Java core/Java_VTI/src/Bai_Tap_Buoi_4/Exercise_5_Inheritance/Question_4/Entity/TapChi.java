package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Entity;

import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Service.Showinfor;

public class TapChi extends  TaiLieu {
    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChi()
    {

    }
    public TapChi(String maTaiLieu, String tenNXB, int soBanPhatHanh, int soPhatHanh, int thangPhatHanh) {
        super(maTaiLieu, tenNXB, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    public int getSoPhatHanh() {
        return soPhatHanh;
    }

    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }

    public int getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public void show() {
        System.out.println("---------- THÔNG TIN TẠP CHÍ ----------");
        System.out.println("Mã tài liệu: " + getMaTaiLieu());
        System.out.println("Tên nhà xuất bản: " + getTenNXB());
        System.out.println("Số bản phát hành: " + getSoBanPhatHanh());
        System.out.println("Số phát hành: " + this.soPhatHanh);
        System.out.println("Tháng phát hành: " + this.thangPhatHanh);
        System.out.println("---------------------------------------");
    }
}
