package Bai_Tap_Buoi_3.Excercise_1_Datatype_Casting;

import java.util.Random;
import java.util.Scanner;

public class Exercise_1_2_3_4 {
    public static void main(String[] args) {
        System.out.println("--- Câu 1: Ép kiểu lương ---");
        cau1_EpKieuLuong();

        System.out.println("\n--- Câu 2: Lấy số ngẫu nhiên ---");
        // Lưu kết quả của Câu 2 để truyền vào Câu 3
        String ketQuaCau2 = cau2_TaoSoNgauNhien();

        System.out.println("\n--- Câu 3: Lấy 2 số cuối ---");
        cau3_LayHaiSoCuoi(ketQuaCau2);

        System.out.println("\n--- Câu 4: Tính thương 2 số ---");
        cau4_TinhThuongHaiSo();
    }

    /**
     * Question 1: Khai báo lương float và ép kiểu sang int để làm tròn
     */
    public static void cau1_EpKieuLuong() {
        float luongAccount1 = 5240.5f;
        float luongAccount2 = 10970.055f;

        // Ép kiểu float sang int (cắt bỏ phần thập phân)
        int luongLamTron1 = (int) luongAccount1;
        int luongLamTron2 = (int) luongAccount2;

        System.out.println("Lương Account 1 ban đầu: " + luongAccount1 + " $");
        System.out.println("Lương Account 1 sau khi làm tròn: " + luongLamTron1 + " $");
        System.out.println("Lương Account 2 ban đầu: " + luongAccount2 + " $");
        System.out.println("Lương Account 2 sau khi làm tròn: " + luongLamTron2 + " $");
    }

    /**
     * Question 2: Tạo số ngẫu nhiên có 5 chữ số
     * Trả về chuỗi (String) để sử dụng cho câu tiếp theo
     */
    public static String cau2_TaoSoNgauNhien() {
        Random ngauNhien = new Random();
        // Lấy số từ 0 đến 99999
        int soRandom = ngauNhien.nextInt(100000);

        // Định dạng đủ 5 chữ số, nếu thiếu thì thêm số 0 ở đầu
        String soDaDinhDang = String.format("%05d", soRandom);

        System.out.println("Số ngẫu nhiên vừa tạo: " + soDaDinhDang);
        return soDaDinhDang;
    }

    /**
     * Question 3: Lấy 2 số cuối của số vừa tạo ở trên
     */
    public static void cau3_LayHaiSoCuoi(String chuoiSo) {
        // Cách 1: Dùng Substring (cắt từ vị trí thứ 3 đến hết)
        String haiSoCuoi = chuoiSo.substring(3);

        System.out.println("Hai số cuối của chuỗi \"" + chuoiSo + "\" là: " + haiSoCuoi);
    }

    /**
     * Question 4: Nhập a, b từ bàn phím và tính thương
     */
    public static void cau4_TinhThuongHaiSo() {
        Scanner nhapLieu = new Scanner(System.in);

        System.out.print("Mời bạn nhập số nguyên a: ");
        int a = nhapLieu.nextInt();

        System.out.print("Mời bạn nhập số nguyên b: ");
        int b = nhapLieu.nextInt();

        // Kiểm tra điều kiện mẫu số khác 0
        if (b == 0) {
            System.out.println("Lỗi: Không thể thực hiện phép chia cho số 0!");
        } else {
            // Ép kiểu số a sang float để kết quả thương có phần thập phân
            float thuong = (float) a / b;
            System.out.println("Kết quả: " + a + " chia cho " + b + " bằng " + thuong);
        }
    }
}
