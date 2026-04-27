package Bai_Tap_Buoi_3.Excercise_3_Unboxing_Boxing;

public class Excercise_1_2_3_4 {
    //    Question 1: Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//    Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu thập phân)
    public static void Cau_1() {
        Integer luongInteger = 5000;

        float luongFloat = (float) luongInteger;
        System.out.printf("Lương sau khi chuyển đổi: %.2f $\n", luongFloat);

    }
//    Question 2:
//    Khai báo 1 String có value = "1234567"
//    Hãy convert String đó ra số int

    public static void Cau_2() {
        String a = "1234567";
        Integer epKieuWrapper = Integer.valueOf(a);
        int epKieu_NguyenThuy = Integer.parseInt(a);

        System.out.println("Kết quả kiểu Wrapper: " + epKieuWrapper);
        System.out.println("Kết quả kiểu Nguyên thủy: " + epKieu_NguyenThuy);
    }
//    Question 3:
//    Khởi tạo 1 số Integer có value là chữ "1234567"
//    Sau đó convert số trên thành datatype int
public static void Cau_3() {
    String a = "1234567";
    Integer epKieuWrapper = Integer.valueOf(a);
    int epKieu_NguyenThuy = epKieuWrapper;

    System.out.println("Kết quả kiểu Wrapper: " + epKieuWrapper);
    System.out.println("Kết quả kiểu Nguyên thủy: " + epKieu_NguyenThuy);
    System.out.println(epKieu_NguyenThuy);


}
    public static void main(String[] args) {
        Cau_1();
        Cau_2();
        Cau_3();
    }
}
