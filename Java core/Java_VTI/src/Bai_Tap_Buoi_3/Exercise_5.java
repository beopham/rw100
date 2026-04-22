package Bai_Tap_Buoi_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercise_5 {
    public static void main(String[] args) {
//        Question 1:
//        Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào số nguyên");
        int a = sc.nextInt();
        System.out.println(a);
//        Question 2:
//        Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
        System.out.println("nhập vào số thực 1");
        double b = sc.nextDouble();
        System.out.println(b);
        System.out.println("nhập vào số thực 2");
        double c = sc.nextDouble();
        System.out.println(c);
//        Question 3:
//        Viết lệnh cho phép người dùng nhập họ và tên
        System.out.print("Mời bạn nhập họ và tên: ");
        String hoTen = sc.nextLine();
        System.out.println("Chào bạn: " + hoTen);
//        Question 4:
//        Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
        DateTimeFormatter dinhdang = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Mời bạn nhập ngày sinh (ví dụ: 24/07/1995): ");
        String ngay = sc.nextLine();

        LocalDate ngaySinh = LocalDate.parse(ngay, dinhdang);

        // 3. In kết quả để kiểm tra
        System.out.println("Ngày sinh bạn vừa nhập là: " + ngaySinh);
        System.out.println("Năm sinh của bạn là: " + ngaySinh.getYear());
    }

}
