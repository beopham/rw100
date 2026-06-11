package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
    private Scanner sc = new Scanner(System.in);
    public String nhapten() {
        while (true) {
            String ten = sc.nextLine().trim();
            if (ten.isEmpty()) {
                System.out.println("k đc để tên trống");
                System.out.println("mời bạn nhập lại");
                continue;
            }
            String regex = "^[\\p{L} ]+$";
            if (ten.matches(regex)) {
                return ten;
            } else {
                System.out.println("tên nhập k đúng định dạng");
                System.out.println("mời bạn nhập lại");
            }
        }
    }
    public String nhapPassword() {
        // Giải thích Regex:
        // ^                 : Bắt đầu chuỗi
        // (?=.*[A-Z])       : Phải có ít nhất 1 chữ in hoa
        // (?=.*[a-z])       : Phải có ít nhất 1 chữ thường
        // (?=.*\\d)         : Phải có ít nhất 1 chữ số
        // (?=.*[@#$%^&+!])  : Phải có ít nhất 1 ký tự đặc biệt
        // (?!.*\\s)         : Không được có khoảng trắng
        // .{8,20}           : Độ dài từ 8 đến 20 ký tự
        // $                 : Kết thúc chuỗi
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+!])(?!.*\\s).{8,20}$";

        while (true) {
            System.out.print("Nhập mật khẩu: ");
            String pass = sc.nextLine().trim();

            if (pass.matches(regex)) {
                return pass;
            } else {
                System.out.println("❌ Mật khẩu không hợp lệ!");
                System.out.println("Quy tắc: 8-20 ký tự, bao gồm chữ hoa, chữ thường, số, ký tự đặc biệt (@#$%^&+!) và KHÔNG khoảng trắng.");
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

    public  int inputId() {
        while (true) {
            try {
                String input = sc.nextLine().trim();
                int id = Integer.parseInt(input);

                // Kiểm tra nếu ID nhỏ hơn hoặc bằng 0 thì bắt nhập lại
                if (id <= 0) {
                    System.err.print("Lỗi: ID phải là số nguyên dương lớn hơn 0! Nhập lại: ");
                    continue; // Ép vòng lặp chạy lại từ đầu
                }

                return id; // Thỏa mãn điều kiện thì trả về kết quả

            } catch (NumberFormatException e) {
                System.err.print("❌ Lỗi: ID phải là một số nguyên hợp lệ! Nhập lại: ");
            }
        }
    }


}
