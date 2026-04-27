package Bai_Tap_Buoi_2;

public class Excercise_6_bai_1 {
    //        Question 1:
//        Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
    public static void main(String[] args) {
        // Gọi method để thực hiện in số chẵn
        printPositiveEvenNumbers();
    }

    /**
     * Question 1: Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
     */
    public static void printPositiveEvenNumbers() {
        System.out.println("Các số chẵn nguyên dương nhỏ hơn 10 là:");

        for (int i = 2; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        // Xuống dòng sau khi in xong
        System.out.println();
    }
}
