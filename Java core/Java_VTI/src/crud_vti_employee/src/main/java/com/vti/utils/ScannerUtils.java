package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
    private Scanner sc = new Scanner(System.in);

    public String checkfullName() {
        while (true) {
            String ten = sc.nextLine().trim();
            if (ten.isEmpty()) {
                System.out.println("Bạn k đc để trống tên");
                continue;
            }
            String regex = "^[\\p{L} ]+$";
            if (ten.matches(regex)) {
                return ten;
            } else {
                System.out.println("bạn nhập sai kí tự tên");
                System.out.println("mời bạn nhập lại");
            }
        }
    }
    public String nhapEmail() {
        while (true) {
            String email = sc.nextLine().trim();

            // 1. Kiểm tra trống
            if (email.isEmpty()) {
                System.out.println("Không được để trống Email!");
                continue;
            }

            // 2. Định nghĩa chuỗi Regex kiểm tra Email chuẩn
            // Regex này cho phép chữ, số, dấu chấm trước chữ @, và bắt buộc có tên miền (.com, .com.vn,...) phía sau.
            String regexEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

            // 3. Kiểm tra bằng matches()
            if (email.matches(regexEmail)) {
                return email; // Đúng định dạng -> trả về và thoát hàm luôn
            } else {
                System.out.println("Email không đúng định dạng (Ví dụ đúng: nguyen.vannam@vti.com.vn)!");
            }
        }
    }
    public String nhapmk() {
        while (true) {
            String mk = sc.nextLine().trim();
            if (mk.isEmpty()) {
                System.out.println(" mật khẩu k đc để tên trống");
                System.out.println("mời bạn nhập lại");
                continue;
            }
            String regex ="^(?=.*[A-Z]).{6,12}$";
            if (mk.matches(regex)) {
                return mk;
            } else {
                System.out.println("mật khẩu k đúng định dạng");
                System.out.println("nhập từ 6 tới 12 ký tự, có ít nhất 1 ký tự viết hoa");
                System.out.println("mời bạn nhập lại");
            }
        }
    }
    public  int inputId() {
        while (true) {
            try {
                String input = sc.nextLine().trim();
                int id = Integer.parseInt(input);

                // Kiểm tra nếu ID nhỏ hơn hoặc bằng 0 thì bắt nhập lại
                if (id <= 0) {
                    System.err.print("❌ Lỗi: ID phải là số nguyên dương lớn hơn 0! Nhập lại: ");
                    continue; // Ép vòng lặp chạy lại từ đầu
                }

                return id; // Thỏa mãn điều kiện thì trả về kết quả

            } catch (NumberFormatException e) {
                System.err.print("❌ Lỗi: ID phải là một số nguyên hợp lệ! Nhập lại: ");
            }
        }
    }


}
