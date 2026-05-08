package Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Frontend;

import Bai_Tap_Buoi_4.Exercise_5_Inheritance.Question_1_2.Backend.QuanLiCanBo;


import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        QuanLiCanBo qlcb = new QuanLiCanBo();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ QUẢN LÝ CÁN BỘ ------");
            System.out.println("1. Thêm mới cán bộ");
            System.out.println("2. Tìm kiếm theo họ tên");
            System.out.println("3. Hiển thị danh sách cán bộ");
            System.out.println("4. Xóa cán bộ theo tên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");

            if (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập số!");
                sc.nextLine();
                continue;
            }
            int chon = sc.nextInt();
            sc.nextLine();

            if (chon == 1) {
                qlcb.themCanbo();
            }
            else if (chon == 2) {
                System.out.print("Nhập họ tên cần tìm: ");
                String hoTen = sc.nextLine();
                qlcb.timKiemtheoHoTen(hoTen);
            }
            else if (chon == 3) {
                qlcb.showIn4();
            }
            else if (chon == 4) {
                System.out.print("Nhập họ tên cần xóa: ");
                String hoTen = sc.nextLine();
                qlcb.xoaCanbo(hoTen);
            }
            else if (chon == 5) {
                System.out.println("Đã thoát chương trình");
                break;
            }
            else {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
        }
    }
}
