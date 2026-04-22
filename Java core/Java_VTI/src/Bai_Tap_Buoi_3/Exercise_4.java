package Bai_Tap_Buoi_3;

import java.time.LocalDate;
import java.util.Random;

public class Exercise_4 {
    public static void main(String[] args) {
        Random rd = new Random();
//        Question 1:
//        In ngẫu nhiên ra 1 số nguyên
        int bien = rd.nextInt(1, 10);
        System.out.println(bien);
//        Question 2:
//        In ngẫu nhiên ra 1 số thực
        double bien1 = rd.nextDouble(1, 10);
        System.out.println(bien1);
//        Question 3:  Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
        String[] dsTen = {
                "Linh", "Hoa", "Lan", "Mai", "Trâm",
                "Vy", "An", "Ngọc", "Tú", "Quỳnh"
        };
        int soluong=dsTen.length;
//        System.out.println(soluong);
        int ten=rd.nextInt(soluong);
        System.out.println("Tên bất kì "+ dsTen[ten]);

// --- Question 4: Ngẫu nhiên từ 24/07/1995 đến 20/12/1995 ---
        long minDayQ4 = LocalDate.of(1995, 7, 24).toEpochDay();
        long maxDayQ4 = LocalDate.of(1995, 12, 20).toEpochDay();

        long randomDayQ4 = minDayQ4 + rd.nextLong(maxDayQ4 - minDayQ4 + 1);
        System.out.println("Q4 - Ngày ngẫu nhiên năm 1995: " + LocalDate.ofEpochDay(randomDayQ4));


        // --- Question 5: Ngẫu nhiên trong 1 năm trở lại đây ---
        long maxDayQ5 = LocalDate.now().toEpochDay();
        long minDayQ5 = LocalDate.now().minusYears(1).toEpochDay();

        long randomDayQ5 = minDayQ5 + rd.nextLong(maxDayQ5 - minDayQ5 + 1);
        System.out.println("Q5 - Ngày ngẫu nhiên trong 1 năm qua: " + LocalDate.ofEpochDay(randomDayQ5));


        // --- Question 6: Ngẫu nhiên 1 ngày trong quá khứ ---
        // "Quá khứ" là từ ngày 01-01-1970 (mốc 0 của Epoch) đến hôm qua
        long maxDayQ6 = LocalDate.now().minusDays(1).toEpochDay();
        long minDayQ6 = 0; // Hoặc bạn có thể set một mốc xa hơn tùy ý

        long randomDayQ6 = rd.nextLong(maxDayQ6 + 1); // Random từ 0 đến maxDay
        System.out.println("Q6 - Một ngày ngẫu nhiên trong quá khứ: " + LocalDate.ofEpochDay(randomDayQ6));


//        Question 7:
//        Lấy ngẫu nhiên 1 số có 3 chữ số
        int bien3 = rd.nextInt(100, 1000-1);
        System.out.println(bien3);

    }
}
