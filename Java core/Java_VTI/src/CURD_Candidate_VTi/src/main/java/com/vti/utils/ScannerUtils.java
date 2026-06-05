package com.vti.utils;

import com.vti.enums.GraduationRank;

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
            String regrex = "^[a-zA-Z\\s]+$";
            if (ten.matches(regrex)) {
                return ten;
            } else {
                System.out.println("tên nhập k đúng định dạng");
                System.out.println("mời bạn nhập lại");
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
            String regrex ="^(?=.*[A-Z]).{6,12}$";
            if (mk.matches(regrex)) {
                return mk;
            } else {
                System.out.println("mật khẩu k đúng định dạng");
                System.out.println("mời bạn nhập lại");
            }
        }
    }
    public String nhapsdth() {
        while (true) {
            String sdth = sc.nextLine().trim();
            if (sdth.isEmpty()) {
                System.out.println("số điện thoại k đc để null");
                System.out.println("mời bạn nhập lại");
                continue;
            }
            // 2. Khai báo Regex (Bắt đầu bằng số 0, tổng dài 9-12 số)
            String regex = "^0\\d{8,11}$";
            if (sdth.matches(regex)) {
                return sdth;
            } else {
                System.out.println("số điện thoại k đúng định dạng");
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

    public int nhapsonamkn() {
        while (true) {
            try {
                String namkn = sc.nextLine().trim();
                int sonamkn = Integer.parseInt(namkn);
                if (sonamkn >= 0 && sonamkn <= 10) {
                    return sonamkn;
                } else {
                    System.out.println("bạn phải nhập từ 0 đến 10 ");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Bạn phải nhập số k đc nhập chữ");
            }

        }
    }

    public GraduationRank ranksinhvien() {
        while (true) {
            try {
                System.out.println("1. EXCELLENCE (Xuất sắc)");
                System.out.println("2. GOOD (Giỏi)");
                System.out.println("3. FAIR (Khá)");
                System.out.println("4. POOR (Trung bình/Yếu)");
                System.out.print("Mời bạn chọn xếp loại (1-4): ");

                String rank = sc.nextLine().trim();
                int luachon = Integer.parseInt(rank);

                // Rút gọn: return thẳng Enum về luôn, không cần khai báo biến trung gian rồi gán nữa
                if (luachon == 1) {
                    return GraduationRank.EXCELLENCE;
                } else if (luachon == 2) {
                    return GraduationRank.GOOD;
                } else if (luachon == 3) {
                    return GraduationRank.FAIR;
                } else if (luachon == 4) {
                    return GraduationRank.POOR;
                } else {
                    System.out.println("Bạn phải nhập từ 1 đến 4 để chọn rank!");
                }
            } catch (Exception e) {
                // Đã bỏ e.printStackTrace() để màn hình Console sạch sẽ, chỉ hiện câu thông báo dưới đây
                System.out.println("Bạn phải nhập số nguyên!");
            }
        }
    }
}
