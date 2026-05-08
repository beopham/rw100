package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Backend;

import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity.CanBo;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity.CongNhan;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity.KySu;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity.NhanVien;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Enums.GioiTinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public void themCanbo() {
        Scanner sc = new Scanner(System.in);

        // 1. NHẬP THÔNG TIN CHUNG (Chỉ viết 1 lần)
        System.out.print("Nhập họ tên: ");
        String hoTen = sc.nextLine();

        System.out.print("Nhập tuổi: ");
        int tuoi = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập giới tính (1.Nam, 2.Nữ, 3.Khác): ");
        GioiTinh gioiTinh = null;
        int gt = sc.nextInt();
        sc.nextLine();
        if (gt == 1) {
            gioiTinh = GioiTinh.NAM;
        } else if (gt == 2) {
            gioiTinh = GioiTinh.NỮ;
        } else if (gt == 3) {
            gioiTinh = GioiTinh.KHÁC;
        }

        System.out.print("Nhập địa chỉ: ");
        String diaChi = sc.nextLine();

        // 2. CHỌN LOẠI CÁN BỘ ĐỂ NHẬP THÔNG TIN RIÊNG
        System.out.println("--- Chọn loại cán bộ muốn thêm ---");
        System.out.println("1. Công nhân | 2. Kỹ sư | 3. Nhân viên");
        System.out.print("Lựa chọn của bạn: ");
        int loai = sc.nextInt();
        sc.nextLine();

        if (loai == 1) {
            // Riêng cho Công nhân
            System.out.print("Nhập bậc (1-10): ");
            int bac = sc.nextInt();
            sc.nextLine();
            CanBo cb = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac);
            quanlicanbo.add(cb);
            System.out.println("=> Đã thêm Công nhân thành công");

        } else if (loai == 2) {
            // Riêng cho Kỹ sư
            System.out.print("Nhập ngành đào tạo: ");
            String nganhDaoTao = sc.nextLine();
            CanBo cb = new KySu(hoTen, tuoi, gioiTinh, diaChi, nganhDaoTao);
            quanlicanbo.add(cb);
            System.out.println("=> Đã thêm Kỹ sư thành công");

        } else if (loai == 3) {
            // Riêng cho Nhân viên
            System.out.print("Nhập công việc: ");
            String congViec = sc.nextLine();
            CanBo cb = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec);
            quanlicanbo.add(cb);
            System.out.println("=> Đã thêm Nhân viên thành công");

        } else {
            System.out.println("Lựa chọn loại cán bộ không hợp lệ!");
        }
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
