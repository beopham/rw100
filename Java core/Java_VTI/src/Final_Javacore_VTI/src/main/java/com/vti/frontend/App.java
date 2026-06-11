package com.vti.frontend;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        functions function = new functions();

        while (true) {
            System.out.println("\n----------- QUẢN LÝ SINH VIÊN -----------");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật chuyên ngành cho sinh viên");
            System.out.println("4. Xóa sinh viên theo ID");
            System.out.println("5. Tìm kiếm sinh viên theo chuyên ngành");
            System.out.println("6. Kiểm tra độ mạnh mật khẩu");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng (0-6): ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                   function.hienThiDanhSachSinhVien();
                    break;
                case "2":
                    function.themsinhvien();
                    break;
                case "3":
                    function.updateChuyenNganh();
                    break;
                case "4":
                    function.xoaSinhVien();
                    break;
                case "5":
                    function.timKiemTheoChuyenNganh();
                    break;
                case "6":
                    function.kiemTraPassword();
                    break;
                case "0":
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }
}