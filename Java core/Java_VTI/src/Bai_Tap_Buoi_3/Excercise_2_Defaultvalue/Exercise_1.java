package Bai_Tap_Buoi_3.Excercise_2_Defaultvalue;

import Bai_Tap_Buoi_3.Account;

import java.time.LocalDate;

public class Exercise_1 {
    public static void main(String[] args) {
        // Gọi method và nhận lại mảng đã khởi tạo
        Account[] danhSachAccount = khoiTaoMangAccount();

        // In ra màn hình để kiểm tra kết quả
        System.out.println("--- Danh sách Account sau khi khởi tạo ---");
        for (Account acc : danhSachAccount) {
            System.out.println("Email: " + acc.email);
            System.out.println("Username: " + acc.Username);
            System.out.println("FullName: " + acc.FullName); // Giả sử class Account có biến FullName
            System.out.println("CreateDate: " + acc.localDate);
            System.out.println("-------------------------");
        }
    }

    /**
     * Question 1: Tạo mảng Account và khởi tạo 5 phần tử dùng vòng lặp For
     */
    public static Account[] khoiTaoMangAccount() {
        // 1. Khai báo mảng Account có 5 phần tử
        Account[] mangAccount = new Account[5];

        // 2. Sử dụng vòng lặp For để khởi tạo từng phần tử
        for (int i = 0; i < mangAccount.length; i++) {
            // CỰC KỲ QUAN TRỌNG: Phải khởi tạo đối tượng tại vị trí i trước khi gán thuộc tính
            mangAccount[i] = new Account();

            // Gán giá trị theo yêu cầu (i + 1 để bắt đầu từ số 1)
            int soThuTu = i + 1;
            mangAccount[i].email = "Email " + soThuTu;
            mangAccount[i].Username = "User name " + soThuTu;
            mangAccount[i].FullName = "Full name " + soThuTu;
            mangAccount[i].localDate = LocalDate.now();
        }

        return mangAccount;
    }
}
