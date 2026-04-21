package Bai_Tap_Buoi_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise_2 {
    public static void main(String[] args) {
//        Question 1:  Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
        int a = 5;
        System.out.println(a);

//        Question 2:
//        Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng như sau: 100,000,000
        int number = 100000000;

        System.out.printf("%,d", number);
//        Question 3:
//        Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau
// Khai báo số thực
        double number1 = 5.567098;

        System.out.printf("%.4f", number1);
//        Question 4:
//        Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
//        Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//        Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.

                // Khai báo Họ và tên
        String fullName = "Nguyễn Văn A";
        System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân.", fullName);

//        Question 5:
//        Lấy thời gian bây giờ và in ra theo định dạng sau:
//        24/04/2020 11h:16p:20s

        // 1. Lấy thời gian hiện tại của hệ thống
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'p':ss");

        // 3. Format và in ra console
        String formattedDate = now.format(formatter);
        System.out.println(formattedDate);
    }
}
