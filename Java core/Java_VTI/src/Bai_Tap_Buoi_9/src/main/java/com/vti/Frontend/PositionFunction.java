package com.vti.Frontend;

import com.vti.Backend.Controller.PositionTest;
import java.util.Scanner;

public class PositionFunction {
    private  PositionTest positionTest = new PositionTest();
    private  Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ CHỨC VỤ ===");
            System.out.println("1. Xem danh sách chức vụ");
            System.out.println("2. Thêm mới chức vụ");
            System.out.println("3. Cập nhật thông tin chức vụ");
            System.out.println("4. Xóa chức vụ");
            System.out.println("5. Thoát");
            System.out.print("Mời bạn chọn chức năng (1-5): ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    positionTest.showPosition();
                    break;
                case "2":
                    positionTest.insertPosition();
                    break;
                case "3":
                    positionTest.updatePosition();
                    break;
                case "4":
                    positionTest.deletePosition();
                    break;
                case "5":
                    System.out.println("Đang thoát hệ thống chức vụ... Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn sai rồi! Vui lòng nhập từ 1 đến 5.");
            }
        }
    }
}