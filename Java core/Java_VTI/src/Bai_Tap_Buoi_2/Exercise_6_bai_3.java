package Bai_Tap_Buoi_2;

public class Exercise_6_bai_3 {
    public static void printPositiveIntegersUnderTen() {
        System.out.println("Danh sách các số nguyên dương nhỏ hơn 10:");

        for (int i = 1; i < 10; i++) {
            System.out.print(i + (i < 9 ? ", " : ""));
        }

        // In thêm dòng trống cho đẹp terminal
        System.out.println("\n-------------------------------------------");
    }
}
