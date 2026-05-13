package Bai_Tap_Buoi_8.Frontend;

import Bai_Tap_Buoi_8.Backend.Management;
import java.util.Scanner;

public class Menu_Position {
    public static void main(String[] args) {
        // Khởi tạo đối tượng xử lý logic
        Management management = new Management();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= QUẢN LÝ CHỨC VỤ (POSITION) =========");
            System.out.println("1. Xem danh sách tất cả chức vụ");
            System.out.println("2. Tìm kiếm chức vụ theo tên");
            System.out.println("3. Thêm mới một chức vụ");
            System.out.println("4. Cập nhật chức vụ (theo ID)");
            System.out.println("5. Xóa chức vụ (theo ID)");
            System.out.println("0. Thoát chương trình");
            System.out.println("==============================================");
            System.out.print("Mời bạn chọn chức năng: ");

            String input = sc.nextLine();

            // Sử dụng cấu trúc if-else để điều hướng
            if (input.equals("1")) {
                management.displayAllPositions();
            }
            else if (input.equals("2")) {
                management.searchPositionByName();
            }
            else if (input.equals("3")) {
                management.insertPosition();
            }
            else if (input.equals("4")) {
                management.updatePosition();
            }
            else if (input.equals("5")) {
                management.deletePosition();
            }
            else if (input.equals("0")) {
                System.out.println("Cảm ơn bạn đã sử dụng hệ thống. Tạm biệt!");
                break; // Thoát vòng lặp
            }
            else {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại từ 0 đến 5.");
            }
        }

        sc.close();
    }
}