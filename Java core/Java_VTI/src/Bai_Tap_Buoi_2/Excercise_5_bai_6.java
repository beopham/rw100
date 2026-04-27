package Bai_Tap_Buoi_2;

import java.util.Scanner;

public class Excercise_5_bai_6 {

//    Question 6:
//    Viết lệnh cho phép người dùng tạo department (viết thành method)

    public static void main(String[] args) {
        // Bạn có thể gọi thử method này trong main để kiểm tra
        createDepartment();
    }

    // --- QUESTION 6: Method tạo Department ---
    public static void createDepartment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Nhập thông tin để tạo Department ---");
        Department dept = new Department();

        // 1. Nhập ID phòng ban
        System.out.print("Nhập ID phòng ban: ");
        dept.departmentID = scanner.nextInt();

        // 2. Chống trôi lệnh (Xử lý ký tự Enter còn sót lại sau khi nhập số)
        scanner.nextLine();

        // 3. Nhập tên phòng ban
        System.out.print("Nhập tên phòng ban: ");
        dept.departmentName = scanner.nextLine();

        // 4. In thông tin xác nhận đã tạo thành công
        System.out.println("\n>> Đã tạo phòng ban thành công!");
        System.out.println("Thông tin vừa nhập:");
        System.out.println("ID: " + dept.departmentID);
        System.out.println("Tên: " + dept.departmentName);
        System.out.println("---------------------------------------");
    }
}
