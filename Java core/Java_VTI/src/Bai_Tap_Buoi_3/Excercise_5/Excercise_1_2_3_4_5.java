package Bai_Tap_Buoi_3.Excercise_5;

import Bai_Tap_Buoi_3.Department;

public class Excercise_1_2_3_4_5 {
    public static void main(String[] args) {
        // Khởi tạo mảng các phòng ban (ví dụ 3 phòng)
        Department[] depts = new Department[3];

        // Tạo dữ liệu mẫu cho phòng 1
        depts[0] = new Department();
        depts[0].departmentID = 101;
        depts[0].departmentName = "Phòng Nhân Sự";

        // Tạo dữ liệu mẫu cho phòng 2
        depts[1] = new Department();
        depts[1].departmentID = 102;
        depts[1].departmentName = "Phòng Kỹ Thuật";

        // Tạo dữ liệu mẫu cho phòng 3
        depts[2] = new Department();
        depts[2].departmentID = 103;
        depts[2].departmentName = "Phòng Giám Đốc";


        // Question 1: In ra thông tin của phòng ban thứ 1 (sử dụng toString())
        System.out.println("Q1: " + depts[0]);

        System.out.println("----------------------------");

        // Question 2: In ra thông tin của tất cả phòng ban (sử dụng toString())
        System.out.println("Q2: Danh sách tất cả phòng ban:");
        for (int i = 0; i < depts.length; i++) {
            System.out.println(depts[i].toString());
        }

        System.out.println("----------------------------");

        // Question 3: In ra tên của phòng ban thứ 1
        // (Vì trong class bạn không có field 'địa chỉ', mình sẽ in 'tên' nhé)
        System.out.println("Q3: Tên phòng ban thứ 1 là: " + depts[0].departmentName);
//        Question 4: Kiểm tra tên phòng ban thứ 1
//        // Lấy tên của phòng ban đầu tiên ra để so sánh
        if (depts[0].departmentName.equals("Phòng A")) {
            System.out.println("Q4: Phòng ban thứ 1 đúng là Phòng A");
        } else {
            System.out.println("Q4: Phòng ban thứ 1 không phải là Phòng A. Tên thật là: " + depts[0].departmentName);
        }
//        Question 5: So sánh 2 phòng ban (theo tên)
        // So sánh tên của phòng ở vị trí 0 và phòng ở vị trí 1
        if (depts[0].departmentName.equals(depts[1].departmentName)) {
            System.out.println("Q5: Hai phòng ban này có tên bằng nhau.");
        } else {
            System.out.println("Q5: Hai phòng ban này có tên khác nhau.");
        }
    }
}
