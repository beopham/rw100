package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Frontend;

import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Backend.QuanLiTaiLieu;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Entity.Bao;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Entity.Sach;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_4.Entity.TapChi;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLiTaiLieu quanLi = new QuanLiTaiLieu();

        while (true) {
            System.out.println("\n===== PHẦN MỀM QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Thêm mới tài liệu");
            System.out.println("2. Hiển thị danh sách tài liệu");
            System.out.println("3. Xóa tài liệu theo mã");
            System.out.println("4. Tìm kiếm theo loại và mã");
            System.out.println("5. Thoát");
            System.out.print("Mời bạn chọn chức năng: ");
            if (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập số!");
                sc.nextLine(); // Đọc bỏ ký tự thừa
                continue;
            }
            int luaChon = sc.nextInt();
            sc.nextLine(); // Chống trôi lệnh

            switch (luaChon) {
                case 1:
                    System.out.println("Chọn loại muốn thêm (1: Sách, 2: Tạp chí, 3: Báo): ");

                    int loai = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nhập mã tài liệu: ");
                    String ma = sc.nextLine();
                    System.out.print("Nhập tên NXB: ");
                    String nxb = sc.nextLine();
                    System.out.print("Nhập số bản phát hành: ");
                    int soBan = sc.nextInt();
                    sc.nextLine();

                    if (loai == 1) {
                        System.out.print("Nhập tên tác giả: ");
                        String tacGia = sc.nextLine();
                        System.out.print("Nhập số trang: ");
                        int soTrang = sc.nextInt();
                        quanLi.Them(new Sach(ma, nxb, soBan, tacGia, soTrang));
                    } else if (loai == 2) {
                        System.out.print("Nhập số phát hành: ");
                        int soPH = sc.nextInt();
                        System.out.print("Nhập tháng phát hành: ");
                        int thangPH = sc.nextInt();
                        quanLi.Them(new TapChi(ma, nxb, soBan, soPH, thangPH));
                    } else if (loai == 3) {
                        System.out.print("Nhập ngày phát hành: ");
                        int ngayPH = sc.nextInt();
                        quanLi.Them(new Bao(ma, nxb, soBan, ngayPH));
                    }
                    break;

                case 2:
                    quanLi.hienthi();
                    break;

                case 3:
                    System.out.print("Nhập mã cần xóa: ");
                    String maXoa = sc.nextLine();
                    quanLi.xoa(maXoa);
                    break;

                case 4:
                    System.out.println("Bạn muốn tìm loại nào? (1: Sách, 2: Tạp chí, 3: Báo): ");
                    int loaiTim = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập mã tài liệu cần tìm: ");
                    String maTim = sc.nextLine();
                    quanLi.timkiem(loaiTim, maTim);
                    break;

                case 5:
                    System.out.println("Tạm biệt!");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}