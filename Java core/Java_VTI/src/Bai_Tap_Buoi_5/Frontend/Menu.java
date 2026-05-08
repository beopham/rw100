package Bai_Tap_Buoi_5.Frontend;

import Bai_Tap_Buoi_5.Backend.Management;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Management management = new Management();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= HỆ THỐNG QUẢN LÝ NHÂN SỰ =========");
            System.out.println("1. Nhập danh sách Phòng ban");
            System.out.println("2. Nhập danh sách Chức vụ");
            System.out.println("3. Nhập danh sách Tài khoản (Account)");
            System.out.println("4. Xem danh sách Phòng ban");
            System.out.println("5. Xem danh sách Chức vụ");
            System.out.println("6. Xem danh sách Tài khoản");
            System.out.println("7. Tìm Account theo Tên Phòng Ban");
            System.out.println("8. Tìm Account theo Tên Chức Vụ");
            System.out.println("9. Xóa Account theo Full Name");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn (0-9): ");

            if (!sc.hasNextInt()) {
                System.out.println("Lỗi: Vui lòng nhập số!");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // Dọn dẹp bộ nhớ đệm

            if (choice == 1) {
                management.addDepartment();
            }
            else if (choice == 2) {
                management.addPosition();
            }
            else if (choice == 3) {
                management.addAccount();
            }
            // Tách xem danh sách phòng ban
            else if (choice == 4) {
                System.out.println("--- DANH SÁCH PHÒNG BAN ---");
                management.xemdanhsachphongban();
            }
            // Tách xem danh sách chức vụ
            else if (choice == 5) {
                System.out.println("--- DANH SÁCH CHỨC VỤ ---");
                management.xemdanhsachpo();
            }
            else if (choice == 6) {
                System.out.println("--- DANH SÁCH TÀI KHOẢN ---");
                management.xemdanhsachacc();
            }
            else if (choice == 7) {
                management.timkiemacctheotenphongban();
            }
            else if (choice == 8) {
                management.timkiemacctheotenpchucvu();
            }
            else if (choice == 9) {
                management.xoaaccfullname();
            }
            else if (choice == 0) {
                System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                break;
            }
            else {
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
        sc.close();
    }
}