import com.vti.Frontend.DepartmentFunction;
import com.vti.Frontend.PositionFunction;
import com.vti.Frontend.AccountFunction; // Thêm import này
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DepartmentFunction departmentFunction = new DepartmentFunction();
        PositionFunction positionFunction = new PositionFunction();
        AccountFunction accountFunction = new AccountFunction();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=================================");
            System.out.println("   HỆ THỐNG QUẢN LÝ RW100 VTI   ");
            System.out.println("=================================");
            System.out.println("1. Quản lý Phòng Ban (Department)");
            System.out.println("2. Quản lý Chức Vụ (Position)");
            System.out.println("3. Quản lý Tài Khoản (Account)");
            System.out.println("4. Thoát chương trình");
            System.out.print("Mời bạn chọn phân hệ (1-4): ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    departmentFunction.run();
                    break;
                case "2":
                    positionFunction.run();
                    break;
                case "3":
                    accountFunction.run();
                    break;
                case "4":
                    System.out.println("Đã đóng toàn bộ hệ thống. Tạm biệt!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại từ 1 đến 4!");
            }
        }
    }
}