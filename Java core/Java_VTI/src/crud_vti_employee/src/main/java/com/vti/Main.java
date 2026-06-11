package com.vti;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Trường hợp: a = i++ ---");
        int i1 = 1; // Giả định ban đầu i = 1 để sau khi tăng i sẽ bằng 2 như trong ảnh

        int a1 = i1; // Step 1: Gán giá trị hiện tại của i1 cho a1 (a1 = 1)
        i1 = i1 + 1; // Step 2: Lúc này mới tăng i1 lên 1 đơn vị (i1 = 2)

        System.out.println("Kết quả: i = " + i1); // In ra 2
        System.out.println("Kết quả: a = " + a1); // In ra 1


        // --- TRƯỜNG HỢP 2: Tiền tố (Pre-increment) a = ++i ---
        System.out.println("\n--- Trường hợp: a = ++i ---");
        int i2 = 1; // Giả định ban đầu i = 1

        // Bản chất tách nhỏ: i++; sau đó a = i;
        int a2 = ++i2;

        System.out.println("Kết quả: i = " + i2); // In ra 2
        System.out.println("Kết quả: a = " + a2); // In ra 2
    }

}