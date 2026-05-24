package com.vti.Frontend;

import com.vti.Backend.Controller.DepartmentTest;
import java.util.Scanner;

public class DepartmentFunction {
    private DepartmentTest departmentTest = new DepartmentTest();
    private  Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ PHÒNG BAN ===");
            System.out.println("1. Xem danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Cập nhật thông tin phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. import file csv phòng ban");
            System.out.println("6. Thoát");
            System.out.print("Mời bạn chọn chức năng (1-5): ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    departmentTest.showAllDepartment();
                    break;
                case "2":
                    departmentTest.insertDepartment();
                    break;
                case "3":
                    departmentTest.updateDepartment();
                    break;
                case "4":
                    departmentTest.deleteDepartment();
                    break;
                case "5":
                    departmentTest.importDepartmentFromCSV();
                    break;
                case "6":
                    System.out.println("Đang thoát chương trình... Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn sai rồi! Vui lòng nhập từ 1 đến 5.");
            }
        }
    }
}