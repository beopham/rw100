package com.vti.frontend;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Khởi tạo đối tượng từ file test của bạn
        CandidateTest test = new CandidateTest();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== HỆ THỐNG QUẢN LÝ ỨNG VIÊN ======");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký tài khoản ứng viên");
            System.out.println("3. Thoát");
            System.out.print("Mời bạn chọn chức năng (1-3): ");
            if (!sc.hasNextInt()) {
                System.out.println("Bạn phải nhập định dạng là số!");
                sc.nextLine(); // Bắt buộc phải có dòng này để nuốt chữ rác đi, tránh lặp vô hạn
                continue;
            }
            int choose = sc.nextInt();
            sc.nextLine(); // Chống trôi lệnh
            if (choose == 1) {
                test.dangnhap();
                break;
            } else if (choose == 2) {
                System.out.println("\n--- CHỌN LOẠI ỨNG VIÊN ĐĂNG KÝ ---");
                System.out.println("1. Ứng viên có kinh nghiệm (Experience)");
                System.out.println("2. Ứng viên mới ra trường (Fresher)");
                System.out.print("Mời bạn nhập lựa chọn (1 hoặc 2): ");
                if (!sc.hasNextInt()) {
                    System.out.println("Bạn phải nhập định dạng là số!");
                    sc.nextLine(); // Bắt buộc phải có dòng này để nuốt chữ rác đi, tránh lặp vô hạn
                    continue;
                }
                int chooseRegister = sc.nextInt();
                sc.nextLine(); // Chống trôi lệnh
                if (chooseRegister == 1) {
                    test.themuungcuviencokinhnghiem(); // Gọi hàm của bạn
                } else if (chooseRegister == 2) {
                    test.themuungcuvienfresher();      // Gọi hàm của bạn
                } else {
                    System.err.println("Lựa chọn không hợp lệ!");
                }
            } else if (choose == 3) {
                System.out.println("đã thoát");
                break;
            }
        }
    }
}