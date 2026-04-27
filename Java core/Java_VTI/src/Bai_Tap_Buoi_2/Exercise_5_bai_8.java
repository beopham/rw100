package Bai_Tap_Buoi_2;

import java.util.Scanner;

public class Exercise_5_bai_8 {
    public static void main(String[] args) {
        // Gọi hàm menu thực hiện Question 8
        menuChucNang();
    }

    // --- QUESTION 8: Luồng điều khiển chương trình ---
    public static void menuChucNang() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n================================================");
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1. Tạo Account");
            System.out.println("2. Tạo Department");
            System.out.println("Nhấn phím bất kỳ khác để thoát.");
            System.out.println("================================================");

            // Kiểm tra xem người dùng có nhập vào số hay không
            if (sc.hasNextInt()) {
                int choose = sc.nextInt();

                switch (choose) {
                    case 1:
                        createAccount(); // Gọi method đã viết ở Q5
                        break;
                    case 2:
                        createDepartment(); // Gọi method đã viết ở Q6
                        break;
                    default:
                        System.out.println("Mời bạn nhập lại (chỉ chọn 1 hoặc 2)!");
                        break;
                }
            } else {
                System.out.println("Thoát chương trình. Tạm biệt!");
                break; // Thoát vòng lặp nếu nhập chữ hoặc ký tự lạ
            }
        }
    }

    // --- Method bổ trợ cho Q5 (Tạo Account) ---
    public static void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Bắt đầu tạo Account ---");
        Account acc = new Account();

        System.out.print("Nhập ID: ");
        acc.AccountID = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập Username: ");
        acc.Username = sc.nextLine();

        System.out.println("Chọn Position (1:Dev, 2:Test, 3:ScrumMaster, 4:PM): ");
        int posNum = sc.nextInt();
        Position pos = new Position();
        switch (posNum) {
            case 1: pos.positionName = PositionName.DEV; break;
            case 2: pos.positionName = PositionName.TEST; break;
            case 3: pos.positionName = PositionName.SCRUM_MASTER; break;
            case 4: pos.positionName = PositionName.PM; break;
            default: pos.positionName = PositionName.DEV; break;
        }
        acc.position = pos;
        System.out.println("Đã tạo Account: " + acc.Username + " với chức vụ: " + acc.position.positionName);
    }

    // --- Method bổ trợ cho Q6 (Tạo Department) ---
    public static void createDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Bắt đầu tạo Department ---");
        Department dept = new Department();

        System.out.print("Nhập ID phòng ban: ");
        dept.departmentID = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập tên phòng ban: ");
        dept.departmentName = sc.nextLine();

        System.out.println(" Đã tạo Department: " + dept.departmentName);
    }
}
