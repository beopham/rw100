package Bai_Tap_Buoi_8.Frontend;

import Bai_Tap_Buoi_8.Backend.Management;
import java.util.Scanner;

public class Menu_Account {
    public static void main(String[] args) {
        // Khởi tạo Management để gọi các hàm xử lý logic
        Management management = new Management();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= HỆ THỐNG QUẢN LÝ TÀI KHOẢN (ACCOUNT) =========");
            System.out.println("| 1. Hiển thị danh sách tất cả tài khoản                |");
            System.out.println("| 2. Tìm kiếm tài khoản theo Họ tên                     |");
            System.out.println("| 3. Tìm kiếm tài khoản theo Họ tên và Username         |");
            System.out.println("| 4. Thêm mới tài khoản                                 |");
            System.out.println("| 5. Cập nhật thông tin tài khoản (theo ID)             |");
            System.out.println("| 6. Xóa tài khoản (theo ID)                            |");
            System.out.println("| 0. Thoát chương trình                                 |");
            System.out.println("=========================================================");
            System.out.print("Mời bạn nhập lựa chọn: ");

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
                management.ínsertAccount();
            }
            else if (choice.equals("5")) {
                management.updateAccount();
            }
            else if (choice.equals("6")) {
                management.deleteAccount();
            }
            else if (choice.equals("0")) {
                System.out.println("Cảm ơn bạn đã sử dụng hệ thống. Tạm biệt!");
                break; // Thoát vòng lặp
            }
            else {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại từ 0 đến 6.");
            }
        }
        sc.close();
    }
}