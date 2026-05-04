package Bai_Tap_Buoi_4.Exercise_2_Package.com.vti.frontend;

import Bai_Tap_Buoi_4.Exercise_2_Package.com.vti.backend.Excercise2;

public class Program2 {
    public static void main(String[] args) {
        Excercise2 ex2 = new Excercise2();

        System.out.println("--- Chạy Question 1 (Account - No Args) ---");
        ex2.question1();

        System.out.println("\n--- Chạy Question 2 (Account - Basic) ---");
        ex2.question2();

        System.out.println("\n--- Chạy Question 3 (Account - Position) ---");
        ex2.question3();

        System.out.println("\n--- Chạy Question 4 (Account - Full) ---");
        ex2.question4();
    }
}
