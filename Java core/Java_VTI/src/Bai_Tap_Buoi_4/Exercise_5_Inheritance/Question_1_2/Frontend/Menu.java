package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Frontend;

import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Backend.QuanLiCanBo;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity.CanBo;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity.CongNhan;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity.KySu;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Entity.NhanVien;
import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Enums.GioiTinh;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        QuanLiCanBo qlcb = new QuanLiCanBo();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào số");

        while (true) {
            System.out.println("\n------ QUẢN LÝ CÁN BỘ ------");
            System.out.println("1. Thêm mới cán bộ");
            System.out.println("2. Tìm kiếm theo họ tên");
            System.out.println("3. Hiển thị danh sách cán bộ");
            System.out.println("4. Xóa cán bộ theo tên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");
            // Kiểm tra nếu người dùng nhập chữ thay vì số để tránh crash

            if (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập số!");
                sc.nextLine(); // Đọc bỏ ký tự thừa
                continue;
            }
            int chon = sc.nextInt();
            sc.nextLine();
            if (chon == 1) {
                System.out.println("--- Chọn loại cán bộ muốn thêm ---");
                System.out.println("1. Công nhân");
                System.out.println("2. Kỹ sư");
                System.out.println("3. Nhân viên");
                System.out.print("Lựa chọn của bạn: ");
                int loai = sc.nextInt();
                sc.nextLine();
                if (loai == 1) {
                    // Các thông tin chung của CanBo
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
                    System.out.print("Nhập bậc (1-10): ");
                    int bac = sc.nextInt();
                    CanBo cb = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac);
                    qlcb.themCanbo(cb);
                    System.out.println("Đã thêm công nhân thành công");
                } else if (loai == 2) {
                    // Các thông tin chung của CanBo
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
                    System.out.print("Nhập ngành đào tạo: ");
                    String nganh = sc.nextLine();
                    CanBo cb = new KySu(hoTen, tuoi, gioiTinh, diaChi, nganh);
                    qlcb.themCanbo(cb);
                    System.out.println("Đã thêm kỹ sư thành công");
                } else if (loai == 3) {
                    // Các thông tin chung của CanBo
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
                    System.out.print("Nhập công việc: ");
                    String congViec = sc.nextLine();
                    CanBo cb = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec);
                    qlcb.themCanbo(cb);
                    System.out.println("Đã thêm nhân viên thành công");
                }
            } else if (chon == 2) {
                System.out.print("Nhập họ tên: ");
                String hoTen = sc.nextLine();
                qlcb.timKiemtheoHoTen(hoTen);
            } else if (chon == 3) {
                qlcb.showIn4();
            } else if (chon == 4) {
                System.out.print("Nhập họ tên: ");
                String hoTen = sc.nextLine();
                qlcb.xoaCanbo(hoTen);
            } else if (chon == 5) {
                System.out.println("Đã thoát chương trình");
                break;
            }
        }


    }
}
