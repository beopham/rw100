package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Backend;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Entity.Bao;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Entity.Sach;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Entity.TaiLieu;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Entity.TapChi;

import java.util.ArrayList;
import java.util.List;

public class QuanLiTaiLieu {
    private List<TaiLieu> danhsachTaiLieus;

    public QuanLiTaiLieu() {
        this.danhsachTaiLieus = new ArrayList<>();
    }

    public QuanLiTaiLieu(List<TaiLieu> danhsachTaiLieus) {
        this.danhsachTaiLieus = danhsachTaiLieus;
    }

    public List<TaiLieu> getDanhsachTaiLieus() {
        return danhsachTaiLieus;
    }

    public void setDanhsachTaiLieus(List<TaiLieu> danhsachTaiLieus) {
        this.danhsachTaiLieus = danhsachTaiLieus;
    }

    //    Thêm mới tài liêu: Sách, tạp chí, báo.
    public void Them(TaiLieu taiLieu) {
        danhsachTaiLieus.add(taiLieu);
    }

    //    Xoá tài liệu theo mã tài liệu.
    public void xoa(String maTaiLieu) {
        boolean isXoa = danhsachTaiLieus.removeIf(taiLieu -> taiLieu.getMaTaiLieu().equalsIgnoreCase(maTaiLieu));
        if (isXoa) {
            System.out.println("đã xóa tài liệu thành công");
        } else {
            System.out.println("k xóa đc");
        }
    }

    //    Hiện thị thông tin về tài liệu.
    public void hienthi() {
        if (danhsachTaiLieus == null || danhsachTaiLieus.isEmpty()) {
            System.out.println("không danh sách tài liệu nào");
            return;
        }
        for (TaiLieu taiLieu : danhsachTaiLieus) {
            taiLieu.show();
        }
    }
    //   Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.

    public void timkiem(int loai, String maTaiLieu) {
        boolean isTimKiem = false;
        for (TaiLieu taiLieu : danhsachTaiLieus) {
            // Kiểm tra loại trước (1: Sách, 2: Tạp chí, 3: Báo)
            // Sau đó mới kiểm tra mã tài liệu

            if (loai == 1 && taiLieu instanceof Sach sach && sach.getMaTaiLieu().equalsIgnoreCase(maTaiLieu)) {
                sach.show();
                isTimKiem = true;
            } else if (loai == 2 && taiLieu instanceof TapChi tapChi && tapChi.getMaTaiLieu().equalsIgnoreCase(maTaiLieu)) {
                tapChi.show();
                isTimKiem = true;
            } else if (loai == 3 && taiLieu instanceof Bao bao && bao.getMaTaiLieu().equalsIgnoreCase(maTaiLieu)) {
                bao.show();
                isTimKiem = true;
            }
        }

        if (!isTimKiem) {
            System.out.println("Không tìm thấy thông tin tài liệu phù hợp!");
        }
    }
}
