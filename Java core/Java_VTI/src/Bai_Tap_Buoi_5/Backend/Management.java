package Bai_Tap_Buoi_5.Backend;

import Bai_Tap_Buoi_5.Entity.Account;
import Bai_Tap_Buoi_5.Entity.Department;
import Bai_Tap_Buoi_5.Entity.Position;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    private List<Department> departmentList = new ArrayList<>();
    private List<Position> positionList = new ArrayList<>();
    private List<Account> accountList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public void addDepartment() {
        System.out.println("Nhập vào số lượng phòng ban");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhập phòng ban thứ " + (i + 1) + " ---");

            System.out.print("Nhập ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Chống trôi lệnh trước khi nhập String

            System.out.print("Nhập tên phòng ban: ");
            String name = sc.nextLine();

            // Tạo đối tượng và add vào list
            Department department = new Department(id, name);
            departmentList.add(department);
        }
        System.out.println("Đã thêm thành công " + n + " phòng ban!");
    }

    public void addPosition() {
        System.out.print("Nhập vào số lượng chức vụ muốn thêm: ");
        int n = sc.nextInt();
        sc.nextLine(); // Dọn dẹp phím Enter dư thừa

        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhập chức vụ thứ " + (i + 1) + " ---");

            System.out.print("Nhập ID chức vụ: ");
            int id = sc.nextInt();
            sc.nextLine(); // Chống trôi lệnh trước khi nhập tên

            System.out.print("Nhập tên chức vụ (Dev, Test, PM...): ");
            String name = sc.nextLine();

            // Tạo đối tượng và add vào list positionList
            Position position = new Position(id, name);
            positionList.add(position);
        }
        System.out.println("Đã thêm thành công " + n + " chức vụ!");
    }

    public void addAccount() {
        if (departmentList.isEmpty() || positionList.isEmpty()) {
            System.out.println("Lỗi: Danh sách Phòng ban hoặc Chức vụ đang trống!");
            return;
        }
        System.out.print("Bạn muốn nhập bao nhiêu Account? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập Account thứ " + (i + 1) + " ---");

            System.out.print("Nhập ID Account: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Nhập Email: ");
            String email = sc.nextLine();

            System.out.print("Nhập Username: ");
            String username = sc.nextLine();

            System.out.print("Nhập Full Name: ");
            String fullName = sc.nextLine();

            System.out.println("Danh sach phòng ban để bạn chọnn");
            for (Department dp : departmentList) {
                dp.showInfo();
            }
            System.out.println("Nhập vào id phòng ban mà bạn muốn ");
            int idpb = sc.nextInt();
            sc.nextLine();
            Department chonIDdp = null;
            for (Department d : departmentList) {
                if (d.getDepartmentId() == idpb) {
                    chonIDdp = d;
                    break;
                }
            }

            System.out.println("Danh sach positions để bạn chọnn");
            for (Position po : positionList) {
                po.showInfo();
            }
            System.out.println("Nhập vào id phòng ban mà bạn muốn ");
            int idpo = sc.nextInt();
            sc.nextLine();
            Position chonIDpo = null;
            for (Position po : positionList) {
                if (po.getPositionId() == idpo) {
                    chonIDpo = po;
                    break;
                }
            }

            Account acc = new Account(id, email, username, fullName, chonIDdp, chonIDpo, LocalDate.now());
            accountList.add(acc);

            System.out.println("=> Đã lưu thành công Account: " + fullName);
        }
    }

    public void xemdanhsachphongban() {
        if (departmentList.isEmpty()) {
            System.out.println("Phòng Ban Chưa có danh sách");
            return;
        }
        for (Department department : departmentList) {
            department.showInfo();
        }
    }

    public void xemdanhsachpo() {
        if (positionList.isEmpty()) {
            System.out.println("Position Chưa có danh sách");
            return;
        }
        for (Position position : positionList) {
            position.showInfo();
        }
    }

    public void xemdanhsachacc() {
        if (accountList.isEmpty()) {
            System.out.println("Chưa có danh sách tài khoản nào");
            return;
        }
        for (Account account : accountList) {
            account.showInfo();
        }
    }

    public void timkiemacctheotenphongban() {
        boolean istimKiem = false;
        System.out.println("Nhập vào tên phòng ban");
        String tenpb = sc.nextLine();
        for (Account account : getAccountList()) {
            if (account.getDepartment().getDepartmentName().equalsIgnoreCase(tenpb)) {
                istimKiem = true;
                account.showInfo();
            }
        }
        if(istimKiem)
        {
            System.out.println("K có acc mà bạn tìm kiếm");
        }
    }
    public void timkiemacctheotenpchucvu() {
        boolean istimKiem = false;
        System.out.println("Nhập vào tên chức vụ");
        String tenpb = sc.nextLine();
        for (Account account : getAccountList()) {
            if (account.getPosition().getPositionName().equalsIgnoreCase(tenpb)) {
                istimKiem = true;
                account.showInfo();
            }
        }
        if(istimKiem)
        {
            System.out.println("K có acc mà bạn tìm kiếm");
        }
    }
    public void xoaaccfullname()
    {
        System.out.println("Nhập vào full name");
        String fullnames = sc.nextLine();
        boolean isXoa=accountList.removeIf(account -> account.getFullName().equalsIgnoreCase(fullnames));
        if(isXoa==true)
        {
            System.out.println("Đã xóa thành công");
        }
        else
        {
            System.out.println("K xóa được");
        }
    }
}
