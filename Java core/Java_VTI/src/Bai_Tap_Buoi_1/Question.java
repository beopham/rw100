package Bai_Tap_Buoi_1;

import java.time.LocalDate;

public class Question {

    int questionId;
    String content;
    CategoryQuestion category;
    TypeQuestion type;
    Account creator;
    LocalDate createDate;


    public void show() {
        System.out.println("Question Information");
        System.out.println("QuestionID: " + questionId);
        System.out.println("Content: " + content);

        System.out.println("Category: " + category.categoryId);
        System.out.println("Type: " + type.TypeID);
        System.out.println("Creator: " + creator.AccountID);

        System.out.println("Create Date: " + createDate);
        System.out.println("======================");
    }
}