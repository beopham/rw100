package com.vti.Frontend;

import com.vti.Backend.Controller.AccountTest;
import java.util.Scanner;

public class AccountFunction {
    private final AccountTest accountTest = new AccountTest();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ TÀI KHOẢN ===");
            System.out.println("1. Xem danh sách tài khoản");
            System.out.println("2. Thêm mới tài khoản");
            System.out.println("3. Cập nhật thông tin tài khoản");
            System.out.println("4. Xóa tài khoản");
            System.out.println("5. Thoát");
            System.out.print("Mời bạn chọn chức năng (1-5): ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    accountTest.testShowAllAccount();
                    break;
                case "2":
                    accountTest.insertAccount();
                    break;
                case "3":
                    accountTest.updateAccount();
                    break;
                case "4":
                    accountTest.deleteAccount();
                    break;
                case "5":
                    System.out.println("Đang thoát hệ thống tài khoản... Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn sai rồi! Vui lòng nhập từ 1 đến 5.");
            }
        }
    }
}