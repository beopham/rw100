package com.vti.Backend.Controller;

import com.vti.Entity.Account;
import com.vti.Entity.Department;
import com.vti.Entity.Position;

import java.util.List;
import java.util.Scanner;

public class AccountTest {

    private AccountController accountController = new AccountController();
    private DepartmentController departmentController = new DepartmentController();
    private PositionController positionController = new PositionController();
    private PositionTest positionTest = new PositionTest();
    private DepartmentTest departmentTest = new DepartmentTest();
    private Scanner sc = new Scanner(System.in);

    public void insertAccount() {
        System.out.println("--- THÊM MỚI TÀI KHOẢN ---");
        String email = "";
        String username = "";
        String fullName = "";
        Department department = null;
        Position position = null;

        while (true) {
            System.out.println("Nhập vào email:");
            email = sc.nextLine();
            if (email == null || email.trim().isEmpty()) {
                System.out.println("Email k đc để trống");
                continue;
            }
            // ĐÃ SỬA: Thêm dấu ! để kiểm tra nếu KHÔNG chứa ký tự @
            if (!email.contains("@")) {
                System.out.println("Email phải có @");
                continue;
            }
            if (accountController.checkEmailExist(email)) {
                System.out.println("Email này đã tồn tại trong hệ thống");
                continue;
            }
            break;
        }

        while (true) {
            // ĐÃ SỬA: Thay đổi nội dung thông báo thành username
            System.out.println("Nhập vào username:");
            username = sc.nextLine();
            if (username == null || username.trim().isEmpty()) {
                System.out.println("Username k đc để trống");
                continue;
            }
            if (accountController.checkUsernameExist(username)) {
                System.out.println("Username này đã tồn tại trong hệ thống");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Nhập vào full name:");
            fullName = sc.nextLine();
            if (fullName == null || fullName.trim().isEmpty()) {
                System.out.println("fullname k đc để trống");
                continue;
            }
            break;
        }

        departmentTest.showAllDepartment();
        while (true) {
            System.out.println("Nhập vào id phòng ban:");
            int iddepartment = sc.nextInt();
            sc.nextLine();
            department = departmentController.selectByid(iddepartment);
            if (department == null) {
                System.out.println("Lỗi: Phòng ban không tồn tại! Vui lòng nhập lại ID.");
                continue;
            }
            break;
        }

        positionTest.showPosition();
        while (true) {
            System.out.print("Nhập ID chức vụ đã chọn: ");
            int idpo = sc.nextInt();
            sc.nextLine();

            position = positionController.selectByid(idpo);
            if (position == null) {
                System.out.println("Lỗi: Chức vụ không tồn tại! Vui lòng nhập lại ID.");
                continue;
            }
            break;
        }

        Account account = new Account(email, username, fullName, department, position);
        if (accountController.Insert(account)) {
            System.out.println("Thêm thành công");
        } else {
            System.out.println("Thêm k thành công");
        }
    }
    public void updateAccount() {
        System.out.println("--- CẬP NHẬT TÀI KHOẢN ---");
        System.out.print("Nhập ID tài khoản cần sửa: ");
        int idacc = sc.nextInt();
        sc.nextLine();
        // kiểm tra id
        Account account_update = accountController.selectByid(idacc);
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
        departmentTest.showAllDepartment();
        System.out.print("Nhập ID Phòng ban đã chọn: ");
        int iddepartment = sc.nextInt();
        sc.nextLine();
        Department department = departmentController.selectByid(iddepartment);
        if (department == null) {
            System.out.println("Phòng ban không tồn tại! Hủy thao tác.");
            return;
        }

        positionTest.showPosition();
        System.out.print("Nhập ID chức vụ đã chọn: ");
        int idpo = sc.nextInt();
        sc.nextLine();
        Position position = positionController.selectByid(idpo);
        if (position == null) {
            System.out.println("chức vụ không tồn tại! Hủy thao tác.");
            return;
        }
        account_update.setEmail(email);
        account_update.setDepartment(department);
        account_update.setPosition(position);
        account_update.setUsername(username);
        account_update.setFullName(fullName);
        if (accountController.Update(account_update))
        {
            System.out.println("Cập nhật tài khoản thành công!");
        }
        else
        {
            System.out.println("Cập nhật thất bại!");
        }
    }
    public void deleteAccount() {
        System.out.println("--- XÓA TÀI KHOẢN ---");
        System.out.print("Nhập ID tài khoản cần xóa: ");
        int idacc = sc.nextInt();
        sc.nextLine();
        // kiểm tra id
        Account Account_delete = accountController.selectByid(idacc);
        if (Account_delete == null) {
            System.out.println("Không có id cần xóa");
            return;
        }
        if (accountController.Delete(idacc)) {
            System.out.println("xóa tài khoản thành công!");
        } else {
            System.out.println("xóa thất bại!");
        }
    }
    public void testShowAllAccount() {
        System.out.println("---------- DANH SÁCH TẤT CẢ TÀI KHOẢN ----------");
        List<Account> list = accountController.findAll();

        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách trống!");
        } else {
            for (Account acc : list) {
                acc.showInfo();
            }
        }
        System.out.println("------------------------------------------------");
    }

}

