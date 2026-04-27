package Bai_Tap_Buoi_2;

import java.util.Scanner;

public class Exercise_5_bai_7 {
    public static void kiemTraChanLe(int n) {
        if (n % 2 == 0) {
            System.out.println(n + " là số chẵn.");
        } else {
            System.out.println(n + " là số lẻ.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào một số nguyên: ");

        // Kiểm tra xem người dùng có nhập đúng số nguyên không để tránh lỗi crash
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            kiemTraChanLe(n);
        } else {
            System.out.println("Lỗi: Bạn phải nhập vào một số nguyên!");
        }

        sc.close(); // Đóng scanner
    }
}
