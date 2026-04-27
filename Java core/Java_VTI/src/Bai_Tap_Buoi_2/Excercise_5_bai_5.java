package Bai_Tap_Buoi_2;

import java.time.LocalDate;
import java.util.Scanner;

public class Excercise_5_bai_5 {
//    Question 5:
//    Viết lệnh cho phép người dùng tạo account (viết thành method)
//    Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và
//    vào chương trình sẽ chuyển thành Position.Dev, Position.Test, Position.ScrumMaster, Position.PM

    public static void main(String[] args) {
        // Gọi method để chạy thử
        createAccount();
    }

    public static void createAccount() {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Nhập thông tin tạo Account ---");
        Account acc = new Account();

        System.out.print("Nhập ID: ");
        acc.AccountID = sc.nextInt();
        sc.nextLine(); // Chống trôi lệnh

        System.out.print("Nhập Email: ");
        acc.email = sc.nextLine();

        System.out.print("Nhập Username: ");
        acc.Username = sc.nextLine();

        // --- Xử lý chọn Position ---
        System.out.println("Chọn Position (Nhập số tương ứng):");
        System.out.println("1. DEV");
        System.out.println("2. TEST");
        System.out.println("3. SCRUM_MASTER");
        System.out.println("4. PM");

        int positionNum = sc.nextInt();
        Position pos = new Position();

        switch (positionNum) {
            case 1:
                pos.positionName = PositionName.DEV;
                break;
            case 2:
                pos.positionName = PositionName.TEST;
                break;
            case 3:
                pos.positionName = PositionName.SCRUM_MASTER;
                break;
            case 4:
                pos.positionName = PositionName.PM;
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ, mặc định là DEV.");
                pos.positionName = PositionName.DEV;
                break;
        }
        acc.position = pos;
        acc.localDate = LocalDate.now();

        // --- In kết quả kiểm tra ---
        System.out.println("\n--- Account vừa tạo thành công ---");
        System.out.println("ID: " + acc.AccountID);
        System.out.println("User: " + acc.Username);
        System.out.println("Email: " + acc.email);
        System.out.println("Position: " + acc.position.positionName);
        System.out.println("Ngày tạo: " + acc.localDate);
    }
}
