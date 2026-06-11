package com.vti.frontend;

import com.vti.backend.controller.ControllerStudent;
import com.vti.backend.entity.Major;
import com.vti.backend.entity.Student;
import com.vti.utils.ScannerUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class functions {
    private ControllerStudent controllerStudent = new ControllerStudent();
    private ScannerUtils scannerUtils = new ScannerUtils();
    private Scanner sc = new Scanner(System.in);

    public void themsinhvien() {
        System.out.println("--- THÊM MỚI SINH VIÊN ---");
        System.out.println("Nhập vào tên sinh viên");
        String ten =scannerUtils.nhapten();
        String email="" ;
        while (true)
        {
            System.out.println("Nhập vào email sinh viên ");
            email =scannerUtils.nhapEmail();
            if(controllerStudent.checkEmailExist(email))
            {
                System.out.println("email đã tồn tại rồi");
            }
            else
            {
                break;
            }
        }
        // 3. Nhập ngày sinh
        System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
        LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());

        // 4. Nhập Major ID
        System.out.print("Nhập ID chuyên ngành (major_id): ");
        int majorId = scannerUtils.inputId();
        Major major=new Major(majorId);
        Student student = new Student( ten, email, dateOfBirth,major);

        boolean isSuccess = controllerStudent.inertStudent(student);

        if (isSuccess) {
            System.out.println("Thêm sinh viên thành công!");
        } else {
            System.out.println(" Có lỗi xảy ra, thêm sinh viên thất bại!");
        }
    }
    public void hienThiDanhSachSinhVien() {
        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
// Gọi controller để lấy danh sách từ database
        List<Student> studentList = controllerStudent.findAll();
        for(Student student :studentList)
        {
             student.showInfo();
        }
    }
    public void updateChuyenNganh() {
        System.out.println("--- CẬP NHẬT CHUYÊN NGÀNH ---");

        // 1. Nhập ID sinh viên cần sửa
        System.out.print("Nhập ID sinh viên: ");
        int studentId = scannerUtils.inputId();

        // Kiểm tra xem sinh viên có tồn tại không trước khi update (tùy chọn)
        if (controllerStudent.findById(studentId) == null) {
            System.out.println("Không tìm thấy sinh viên với ID: " + studentId);
            return;
        }

        // 2. Nhập ID chuyên ngành mới
        System.out.print("Nhập ID chuyên ngành mới: ");
        int newMajorId = scannerUtils.inputId();

        // 3. Tạo đối tượng Student chứa thông tin cập nhật
        Major major = new Major(newMajorId);
        Student student = new Student(studentId); // Chỉ cần ID sinh viên
        student.setMajorId(major);

        // 4. Gọi Controller
        if (controllerStudent.updateStudent(student)) {
            System.out.println("Cập nhật chuyên ngành thành công!");
        } else {
            System.out.println("Cập nhật thất bại!");
        }
    }
    public void xoaSinhVien() {
        System.out.println("--- XÓA SINH VIÊN ---");
        System.out.print("Nhập ID sinh viên cần xóa: ");
        int id = scannerUtils.inputId();

        // Kiểm tra xem sinh viên có tồn tại không
        Student student = controllerStudent.findById(id);
        if (student == null) {
            System.out.println(" Không tìm thấy sinh viên có ID: " + id);
            return;
        }

        // Hiển thị thông tin sinh viên định xóa để xác nhận
        System.out.println("Bạn có chắc chắn muốn xóa sinh viên: " + student.getFullName() + " (Y/N)");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            if (controllerStudent.deleteStudent(id)) {
                System.out.println("Đã xóa sinh viên thành công!");
            } else {
                System.out.println("Có lỗi xảy ra, xóa thất bại!");
            }
        } else {
            System.out.println("Đã hủy thao tác xóa.");
        }
    }
    public void timKiemTheoChuyenNganh() {
        System.out.println("--- TÌM KIẾM THEO CHUYÊN NGÀNH ---");
        System.out.print("Nhập tên chuyên ngành cần tìm (ví dụ: Công nghệ thông tin): ");
        String majorName = sc.nextLine().trim();

        List<Student> resultList = controllerStudent.findByMajor(majorName);

        if (resultList.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên nào thuộc chuyên ngành: " + majorName);
        } else {
            System.out.println("Tìm thấy " + resultList.size() + " sinh viên:");
            for (Student st : resultList) {
                st.showInfo(); // Gọi hàm hiển thị dọc đã tạo trước đó
            }
        }
    }
    public void kiemTraPassword() {
        System.out.println("--- KIỂM TRA MẬT KHẨU ---");
        String password = scannerUtils.nhapPassword();
        System.out.println("✅ Chúc mừng! Mật khẩu của bạn rất mạnh và hợp lệ.");
    }
}
