package Bai_Tap_Buoi_7.Backend;

import Bai_Tap_Buoi_7.Entity.Account;
import Bai_Tap_Buoi_7.Entity.Department;
import Bai_Tap_Buoi_7.Entity.Position;

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

    // ================= NHÓM CHỨC NĂNG CHỨC VỤ (POSITION) =================

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
}