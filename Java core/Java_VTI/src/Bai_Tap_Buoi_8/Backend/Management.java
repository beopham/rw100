package Bai_Tap_Buoi_8.Backend;

import Bai_Tap_Buoi_8.Enums.PositionName;
import Bai_Tap_Buoi_8.Entity.Account;
import Bai_Tap_Buoi_8.Entity.Department;
import Bai_Tap_Buoi_8.Entity.Position;

import java.util.List;
import java.util.Scanner;

public class Management {

    private QuanLiAccount quanLiAccount = new QuanLiAccount();
    private QuanLiDepartment quanLiDepartment = new QuanLiDepartment();
    private QuanLiPosition quanLiPosition = new QuanLiPosition();
    private Scanner sc = new Scanner(System.in);

    // ================= NHÓM CHỨC NĂNG PHÒNG BAN (DEPARTMENT) =================

    public void hienThiPhongBanCoTu2NhanVien() {
        System.out.println("---------- DANH SÁCH PHÒNG BAN CÓ TỪ 2 NHÂN VIÊN TRỞ LÊN ----------");
        List<Department> danhSach = quanLiDepartment.inDanhSachPhongBanCoTu2NhanVien();

        if (danhSach == null || danhSach.isEmpty()) {
            System.out.println("Không tìm thấy phòng ban nào thỏa mãn điều kiện.");
        } else {
            for (Department dep : danhSach) {
                dep.showInfo();
            }
        }
        System.out.println("------------------------------------------------------------------");
    }

    public void displayAllDepartments() {
        System.out.println("---------- DANH SÁCH PHÒNG BAN CÓ TỪ 2 NHÂN VIÊN TRỞ LÊN ----------");
        List<Department> danhSach = quanLiDepartment.selectALLdepartment();

        if (danhSach == null || danhSach.isEmpty()) {
            System.out.println("Không tìm thấy phòng ban nào .");
        } else {
            for (Department dep : danhSach) {
                dep.showInfo();
            }
        }
        System.out.println("------------------------------------------------------------------");
    }

    // ================= NHÓM CHỨC NĂNG CHỨC VỤ (POSITION) =================
    public void insertPosition() {
        System.out.println("--- THÊM MỚI CHỨC VỤ ---");
        System.out.println("Chọn tên chức vụ: 1.DEV, 2.TEST, 3.SCRUM_MASTER, 4.PM");
        System.out.print("Lựa chọn của bạn: ");
        int chon = sc.nextInt();
        sc.nextLine();
        PositionName positionName = null;
        if (chon == 1) {
            positionName = PositionName.DEV;
        } else if (chon == 2) {
            positionName = PositionName.TEST;
        } else if (chon == 3) {
            positionName = PositionName.SCRUM_MASTER;
        } else if (chon == 4) {
            positionName = PositionName.PM;
        } else {
            System.out.println("lựa chọn k hợp lệ");
            return;
        }
        Position position = new Position(positionName);
        if (quanLiPosition.insert(position)) {
            System.out.println("thêm thành công");
        } else {
            System.out.println("Thêm Không thành công");
        }
    }

    public void deletePosition() {
        System.out.println("--- Xóa CHỨC VỤ ---");
        System.out.print("Nhập vào ID ");
        int chonid = sc.nextInt();
        sc.nextLine();
        Position kiemtraid = quanLiPosition.getById(chonid);
        if (kiemtraid == null) {
            System.out.println("Không tìm thấy ID");
            return;
        }
        if (quanLiPosition.delete(chonid)) {
            System.out.println("xóa thành công");
        } else {
            System.out.println("xóa Không thành công");
        }
    }

    public void updatePosition() {
        System.out.println("--- Cập Nhập CHỨC VỤ ---");
        System.out.print("Nhập vào ID ");
        int chonid = sc.nextInt();
        sc.nextLine();
        Position kiemtraid = quanLiPosition.getById(chonid);
        if (kiemtraid == null) {
            System.out.println("Không tìm thấy ID");
            return;
        }
        System.out.println("Thông tin chức vụ hiện tại" + kiemtraid.getPositionName());
        System.out.println("Chọn tên chức vụ mới: 1.DEV, 2.TEST, 3.SCRUM_MASTER, 4.PM");
        System.out.print("Lựa chọn của bạn: ");
        int chon = sc.nextInt();
        sc.nextLine();
        if (chon == 1) {
            kiemtraid.setPositionName(PositionName.DEV);
        } else if (chon == 2) {
            kiemtraid.setPositionName(PositionName.TEST);
        } else if (chon == 3) {
            kiemtraid.setPositionName(PositionName.SCRUM_MASTER);
        } else if (chon == 4) {
            kiemtraid.setPositionName(PositionName.PM);
        } else {
            System.out.println("lựa chọn k hợp lệ");
            return;
        }
        if (quanLiPosition.update(kiemtraid)) {
            System.out.println("Cập nhập thành công");
        } else {
            System.out.println("k cập nhập đc");
        }
    }

    public void displayAllPositions() {
        System.out.println("---------- DANH SÁCH TẤT CẢ CHỨC VỤ ----------");
        List<Position> list = quanLiPosition.showAllPosition();

        if (list == null || list.isEmpty()) {
            System.out.println("Không tìm thấy chức vụ nào trong cơ sở dữ liệu.");
        } else {
            for (Position pos : list) {
                pos.showInfo(); // Dùng showInfo() cho đồng bộ với các class khác
            }
        }
        System.out.println("----------------------------------------------");
    }

    public void searchPositionByName() {
        System.out.print("Nhập tên chức vụ cần tìm (ví dụ: DEV): ");
        String name = sc.nextLine();

        System.out.println("---------- KẾT QUẢ TÌM KIẾM CHO: " + name + " ----------");
        List<Position> list = quanLiPosition.findByPositionName(name);

        if (list == null || list.isEmpty()) {
            System.out.println("Không tìm thấy chức vụ nào có tên chứa: " + name);
        } else {
            for (Position pos : list) {
                pos.showInfo();
            }
        }
        System.out.println("---------------------------------------------------------");
    }

    // ================= NHÓM CHỨC NĂNG TÀI KHOẢN (ACCOUNT) =================

    public void testShowAllAccount() {
        System.out.println("---------- DANH SÁCH TẤT CẢ TÀI KHOẢN ----------");
        List<Account> list = quanLiAccount.showAllAccount();

        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách trống!");
        } else {
            for (Account acc : list) {
                acc.showInfo();
            }
        }
        System.out.println("------------------------------------------------");
    }

    public void testFindByFullname() {
        System.out.print("Nhập họ tên cần tìm: ");
        String name = sc.nextLine();

        System.out.println("---------- KẾT QUẢ TÌM KIẾM THEO TÊN: " + name + " ----------");
        List<Account> list = quanLiAccount.findByFullname(name);

        if (list == null || list.isEmpty()) {
            System.out.println("Không tìm thấy tài khoản nào khớp với tên: " + name);
        } else {
            for (Account acc : list) {
                acc.showInfo();
            }
        }
        System.out.println("-------------------------------------------------------------");
    }

    public void testFindByFullnameAndUsername() {
        System.out.print("Nhập họ tên cần tìm: ");
        String fname = sc.nextLine();
        System.out.print("Nhập username cần tìm: ");
        String uname = sc.nextLine();

        System.out.println("---------- KẾT QUẢ TÌM KIẾM KẾT HỢP (Name: " + fname + " & User: " + uname + ") ----------");
        List<Account> list = quanLiAccount.findByFullnameAndUsername(fname, uname);

        if (list == null || list.isEmpty()) {
            System.out.println("Không tìm thấy tài khoản khớp với cả 2 điều kiện!");
        } else {
            for (Account acc : list) {
                acc.showInfo();
            }
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    public void ínsertAccount() {
        System.out.print("Nhập Email: ");
        String email = sc.nextLine();
        System.out.print("Nhập Username: ");
        String username = sc.nextLine();
        System.out.print("Nhập Full Name: ");
        String fullName = sc.nextLine();

        displayAllDepartments();
        System.out.print("Nhập ID Phòng ban đã chọn: ");
        int iddepartment = sc.nextInt();
        sc.nextLine();
        Department department = quanLiDepartment.getByid(iddepartment);
        if (department == null) {
            System.out.println("Phòng ban không tồn tại! Hủy thao tác.");
            return;
        }
        displayAllPositions();
        System.out.print("Nhập ID chức vụ đã chọn: ");
        int idpo = sc.nextInt();
        sc.nextLine();
        Position position = quanLiPosition.getById(idpo);
        if (position == null) {
            System.out.println("chức vụ không tồn tại! Hủy thao tác.");
            return;
        }
        Account account = new Account(email, username, fullName, department, position);
        if (quanLiAccount.insert(account)) {
            System.out.println("Thêm tài khoản thành công!");
        } else {
            System.out.println("Thêm tài khoản thất bại!");
        }
    }

    public void updateAccount() {
        System.out.println("--- CẬP NHẬT TÀI KHOẢN ---");
        System.out.print("Nhập ID tài khoản cần sửa: ");
        int idacc = sc.nextInt();
        sc.nextLine();
        // kiểm tra id
        Account account_update = quanLiAccount.getById(idacc);
        if (account_update == null) {
            System.out.println("Id acccount k tồn tại");
            return;
        }
        System.out.print("Nhập Email mới: ");
        String email = sc.nextLine();
        System.out.print("Nhập Username mới: ");
        String username = sc.nextLine();
        System.out.print("Nhập Full Name mới: ");
        String fullName = sc.nextLine();
        displayAllDepartments();
        System.out.print("Nhập ID Phòng ban đã chọn: ");
        int iddepartment = sc.nextInt();
        sc.nextLine();
        Department department = quanLiDepartment.getByid(iddepartment);
        if (department == null) {
            System.out.println("Phòng ban không tồn tại! Hủy thao tác.");
            return;
        }
        displayAllPositions();
        System.out.print("Nhập ID chức vụ đã chọn: ");
        int idpo = sc.nextInt();
        sc.nextLine();
        Position position = quanLiPosition.getById(idpo);
        if (position == null) {
            System.out.println("chức vụ không tồn tại! Hủy thao tác.");
            return;
        }
        account_update.setEmail(email);
        account_update.setDepartment(department);
        account_update.setPosition(position);
        account_update.setUsername(username);
        account_update.setFullName(fullName);
        if (quanLiAccount.update(account_update)) {
            System.out.println("Cập nhật tài khoản thành công!");
        } else {
            System.out.println("Cập nhật thất bại!");
        }
    }

    public void deleteAccount() {
        System.out.println("--- XÓA TÀI KHOẢN ---");
        System.out.print("Nhập ID tài khoản cần xóa: ");
        int idacc = sc.nextInt();
        sc.nextLine();
        // kiểm tra id
        Account Account_delete = quanLiAccount.getById(idacc);
        if (Account_delete == null) {
            System.out.println("Không có id cần xóa");
        }
        if (quanLiAccount.delete(idacc)) {
            System.out.println("xóa tài khoản thành công!");
        } else {
            System.out.println("xóa thất bại!");
        }
    }
}
