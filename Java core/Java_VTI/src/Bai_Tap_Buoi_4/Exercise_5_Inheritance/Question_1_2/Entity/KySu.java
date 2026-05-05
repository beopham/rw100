package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity;

import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Enums.GioiTinh;

public class KySu extends CanBo{
    private String nganhDaoTao;

    public KySu()
    {

    }

    public KySu(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    public KySu(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, String nganhDaoTao) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public void showinfor() {
        System.out.println("Thông Tin Kỹ Sư");
        super.showinfor();
        System.out.println("Ngành Đào Tạo "+ this.getNganhDaoTao());
    }
}
