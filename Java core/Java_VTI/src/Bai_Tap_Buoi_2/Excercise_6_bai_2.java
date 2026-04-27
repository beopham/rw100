package Bai_Tap_Buoi_2;

public class Excercise_6_bai_2 {
    public static void printAccountDetails(Account[] accounts) {
        System.out.println("====================================================");
        System.out.println("          DANH SÁCH THÔNG TIN ACCOUNT               ");
        System.out.println("====================================================");

        if (accounts == null || accounts.length == 0) {
            System.out.println("Danh sách trống!");
            return;
        }

        for (Account acc : accounts) {
            System.out.println("ID: " + acc.AccountID);
            System.out.println("Username: " + acc.Username);
            System.out.println("Email: " + acc.email);

            // Kiểm tra Null để tránh lỗi nếu chưa gán Department/Position
            String deptName = (acc.department != null) ? acc.department.departmentName : "Chưa xác định";
            String posName = (acc.position != null) ? acc.position.positionName.toString() : "Chưa xác định";

            System.out.println("Phòng ban: " + deptName);
            System.out.println("Chức vụ: " + posName);
            System.out.println("Ngày tạo: " + acc.localDate);
            System.out.println("----------------------------------------------------");
        }
    }
}
