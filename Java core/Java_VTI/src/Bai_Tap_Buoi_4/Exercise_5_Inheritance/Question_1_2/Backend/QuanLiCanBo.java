package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Backend;

import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity.CanBo;

import java.util.ArrayList;
import java.util.List;

public class QuanLiCanBo {
    private List<CanBo> quanlicanbo;

    public QuanLiCanBo() {
        this.quanlicanbo = new ArrayList<>();
    }

    public QuanLiCanBo(List<CanBo> quanlicanbo) {
        this.quanlicanbo = quanlicanbo;
    }

    public List<CanBo> getQuanlicanbo() {
        return quanlicanbo;
    }

    public void setQuanlicanbo(List<CanBo> quanlicanbo) {
        this.quanlicanbo = quanlicanbo;
    }

    // Thêm mới cán bộ.
    public void themCanbo(CanBo canBo) {
        quanlicanbo.add(canBo);
    }

    // Tìm kiếm theo họ tên.
    public void timKiemtheoHoTen(String hoTen) {
        boolean isSearch = false;
        for (CanBo cb : quanlicanbo) {
            if (cb.getHoTen().equalsIgnoreCase(hoTen)) {
                cb.showinfor();
                isSearch = true;
            }
        }
        if (isSearch == false) {
            System.out.println("K có thông tin cán bộ");
        }
    }

    //    Hiện thị thông tin về danh sách các cán bộ.
    public void showIn4() {
        if (quanlicanbo == null || quanlicanbo.isEmpty()) {
            System.out.println("k có danh sách cán bộ nào");
            return;
        }
        for (CanBo cb : quanlicanbo) {
            cb.showinfor();
        }
    }

    //    Nhập vào tên của cán bộ và delete cán bộ đó
    public void xoaCanbo(String hoTen) {
        if (quanlicanbo == null || quanlicanbo.isEmpty()) {
            System.out.println("k có danh sách cán bộ nào");
            return;
        }
        boolean isDelete = quanlicanbo.removeIf(hoten -> hoten.getHoTen().equalsIgnoreCase(hoTen));
        if (isDelete == true) {
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("k xóa đc ");
        }
    }
}
