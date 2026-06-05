package com.vti.frontend;

import com.vti.backend.controller.ControllerCandidate;
import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;
import com.vti.enums.GraduationRank;
import com.vti.enums.Role;
import com.vti.utils.ScannerUtils;

import java.util.Scanner;

public class CandidateTest {
    private ControllerCandidate controllerCandidate = new ControllerCandidate();
    private ScannerUtils scannerUtils = new ScannerUtils();
    private Scanner sc = new Scanner(System.in);

    public void themuungcuviencokinhnghiem() {
        System.out.println("\n=========================================");
        System.out.println("   ĐĂNG KÝ ỨNG VIÊN CÓ KINH NGHIỆM       ");
        System.out.println("=========================================");

        // 1. Nhập các thông tin cơ bản
        System.out.print("Nhập Họ (First Name): ");
        String firstName = scannerUtils.nhapten();

        System.out.print("Nhập Tên (Last Name): ");
        String lastName = scannerUtils.nhapten();
        System.out.print("Nhập Số điện thoại: ");
        String phone = scannerUtils.nhapsdth();

        System.out.print("Nhập Email: ");
        String email = scannerUtils.nhapEmail();
        System.out.print("Nhập Mật khẩu: ");
        String password = scannerUtils.nhapmk();

        System.out.print("Nhập Số năm kinh nghiệm: ");
        // Ép kiểu chuỗi vừa nhập về dạng số nguyên int để nạp vào Constructor
        int expInYear = scannerUtils.nhapsonamkn();
        System.out.print("Nhập Kỹ năng chuyên môn (Pro Skill): ");
        String proSkill = sc.nextLine().trim();
        ExperienceCandidate experienceCandidate = new ExperienceCandidate(firstName, lastName, phone, email, password, Role.EXPERIENCECANDIDATE, expInYear, proSkill);
        try {
            controllerCandidate.saveExperienceCandidate(experienceCandidate);
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("K thêm đc");
        }
    }

    public void themuungcuvienfresher() {
        System.out.println("\n=========================================");
        System.out.println("   ĐĂNG KÝ ỨNG VIÊN FRESHER (MỚI RA TRƯỜNG) ");
        System.out.println("=========================================");

        // 1. Nhập các thông tin cơ bản
        System.out.print("Nhập Họ (First Name): ");
        String firstName = scannerUtils.nhapten();
        System.out.print("Nhập Tên (Last Name): ");
        String lastName = scannerUtils.nhapten();
        System.out.print("Nhập Số điện thoại: ");
        String phone = scannerUtils.nhapsdth();
        System.out.print("Nhập Email: ");
        String email = scannerUtils.nhapEmail();
        System.out.print("Nhập Mật khẩu: ");
        String password = scannerUtils.nhapmk();
        GraduationRank graduationRank = scannerUtils.ranksinhvien();

        // 3. Đóng gói dữ liệu vào Constructor của FresherCandidate (id tạm để là 0 vì DB tự tăng)
        FresherCandidate fresherCandidate = new FresherCandidate(
                firstName, lastName, phone, email, password, Role.FRESHERCANDIDATE, graduationRank
        );

        // 4. Đẩy xuống Controller để lưu vào Database
        try {
            controllerCandidate.saveFresherCandidate(fresherCandidate);
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("K thêm đc");
        }
    }

    public void dangnhap()
    {
        System.out.print("Nhập Email: ");
        String email = scannerUtils.nhapEmail();
        System.out.print("Nhập Mật khẩu: ");
        String password = scannerUtils.nhapmk();
        boolean kiemtratk=controllerCandidate.loginCandidate(email,password);
        if(kiemtratk)
        {
            System.out.println("đng nhập thành công");
        }
        else if(!kiemtratk)
        {
            System.out.println("bạn chưa đăng ký thông tin mời b đăng ký");
        }
    }

}
