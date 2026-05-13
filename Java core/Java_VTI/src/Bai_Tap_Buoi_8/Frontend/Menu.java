package Bai_Tap_Buoi_8.Frontend;

import Bai_Tap_Buoi_8.Backend.Management;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Management management = new Management();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n======= HỆ THỐNG QUẢN LÝ NHÂN SỰ =======");
            System.out.println("1. Xem tất cả tài khoản (Account)");
            System.out.println("2. Tìm tài khoản theo họ tên");
            System.out.println("3. Tìm tài khoản theo họ tên & Username");
            System.out.println("4. Xem danh sách tất cả chức vụ (Position)");
            System.out.println("5. Tìm chức vụ theo tên");
            System.out.println("6. Xem phòng ban có từ 2 nhân viên trở lên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng (0-6): ");

            String choice = sc.nextLine();
            if (choice.equals("1")) {
                management.testShowAllAccount();
            }
            else if (choice.equals("2")) {
                management.testFindByFullname();
            }
            else if (choice.equals("3")) {
                management.testFindByFullnameAndUsername();
            }
            else if (choice.equals("4")) {
                management.displayAllPositions();
            }
            else if (choice.equals("5")) {
                management.searchPositionByName();
            }
            else if (choice.equals("6")) {
                management.hienThiPhongBanCoTu2NhanVien();
            }
            else if (choice.equals("0")) {
                System.out.println("Đang thoát hệ thống... Tạm biệt!");
                break; // Thoát khỏi vòng lặp while
            }
            else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại từ 0 đến 6!");
            }
        }

        sc.close();
    }
}