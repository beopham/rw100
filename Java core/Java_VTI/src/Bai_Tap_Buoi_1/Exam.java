package Bai_Tap_Buoi_1;

import java.time.LocalDate;

public class Exam {
    int examId;
    String code;
    String title;
    CategoryQuestion category; // Đối tượng Category
    int duration;
    Account creator;           // Đối tượng Account (Người tạo)
    LocalDate createDate;

    public void show() {
        System.out.println("Exam Information");
        System.out.println("ExamID: " + examId);
        System.out.println("Code: " + code);
        System.out.println("Title: " + title);

        // In ra ID của Category và Creator
        System.out.println("CategoryID: " + category.categoryId);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("CreatorID: " + creator.AccountID);

        System.out.println("Create Date: " + createDate);
        System.out.println("======================");
    }
}
