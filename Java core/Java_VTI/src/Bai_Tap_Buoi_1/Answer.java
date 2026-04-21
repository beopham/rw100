package Bai_Tap_Buoi_1;

public class Answer {
    int answerId;
    String content;
    Question question; // Liên kết đến đối tượng Question
    boolean isCorrect; // Đúng (true) hoặc Sai (false)

    public void show() {
        System.out.println("Answer Information");
        System.out.println("AnswerID: "   + answerId);
        System.out.println("Content:  "    + content);
        System.out.println("Question: "   + question.questionId);
        System.out.println("Is Correct: " + isCorrect );
        System.out.println("======================");
    }
}
