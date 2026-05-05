package Bai_Tap_Buoi_4.Exercise_4_Encapsulation.Question_1.Front_end;

import Bai_Tap_Buoi_4.Exercise_4_Encapsulation.Question_1.Entity.Student;

public class Demo {
    public static void main(String[] args) {
        Student st = new Student();
        st.setId(1);
        st.setName("Phạm Văn Nam");
        st.setHometown("Đà Nẵng");
        st.setScore(8.0); // Gán điểm ban đầu là 8.0

        st.showInfo();
        System.out.println("thông tin sau cập nhập điểm");

        st.CongThemDiem(1);
        st.showInfo();
    }
}
