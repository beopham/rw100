package Bai_Tap_Buoi_3.Excercise_4_String;

import java.util.Scanner;

public class Excercise_1_2 {
//    Question 1:
//    Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó
//            (các từ có thể cách nhau bằng nhiều khoảng trắng );
    public static  void Cau1()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập xâu kí tự: ");
        String s = sc.nextLine();

        // 1. trim(): Xóa khoảng trắng thừa ở đầu và cuối xâu
        // 2. split("\\s+"): Tách xâu dựa trên một hoặc nhiều khoảng trắng
//        s = s.trim();
        String demtu[]=s.trim().split(" ");
        System.out.println("số lượng từ là " +demtu.length);
    }
//    Question 2:
//    Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;

    public static void Cau_2()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập xâu s1: ");
        String s1 = sc.nextLine();
        System.out.print("Nhập xâu s2: ");
        String s2 = sc.nextLine();

        // Nối s2 vào sau s1
        s1 = s1 + s2;

        System.out.println("Xâu sau khi nối: " + s1);
    }

    public static void main(String[] args) {
        Cau1();
    }
}
