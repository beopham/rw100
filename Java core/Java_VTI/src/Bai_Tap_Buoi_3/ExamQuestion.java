package Bai_Tap_Buoi_3;

public class ExamQuestion {
    Exam exam;         // Đối tượng Exam
    Question question; // Đối tượng Question

    public void show() {
        System.out.println("Exam Question Connection");

        // In ra ID của Exam và Question
        System.out.println("ExamID: " + exam.examId);
        System.out.println("QuestionID: " + question.questionId);

        System.out.println("======================");
    }
}
