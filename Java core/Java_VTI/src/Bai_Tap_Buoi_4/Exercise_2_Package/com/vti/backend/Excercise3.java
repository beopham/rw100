package Bai_Tap_Buoi_4.Exercise_2_Package.com.vti.backend;

import Bai_Tap_Buoi_4.Exercise_1_Constructor.Position;
import Bai_Tap_Buoi_4.Exercise_1_Constructor.PositionName;
import Bai_Tap_Buoi_4.Exercise_2_Package.com.vti.entity.Account;
import Bai_Tap_Buoi_4.Exercise_2_Package.com.vti.entity.Group;

import java.time.LocalDate;

public class Excercise3 {
    public void question1()
    {
        // Lấy lại acc2 và acc3 từ bài trước
        Account acc2 = new Account(1, "nam.pv@gmail.com", "nam_vku", "Phạm", "Nam");
        Account acc3 = new Account(2, "vti.academy@gmail.com", "vti_student", null, "Nguyễn", "An");
        // 1. Khởi tạo mảng Account
        Account[] groupAccounts = { acc2, acc3 };

        // 2. Sử dụng Constructor loại 2 (truyền mảng Account)
        Group group1 = new Group("Java Class", acc2, groupAccounts, LocalDate.now());

    }
    public void question2()
    {

        // Lấy lại acc2 và acc3 từ bài trước
        Account acc2 = new Account(1, "nam.pv@gmail.com", "nam_vku", "Phạm", "Nam");
        Account acc3 = new Account(2, "vti.academy@gmail.com", "vti_student", null, "Nguyễn", "An");
        // 1. Khởi tạo mảng Account
        Account[] groupAccounts = { acc2, acc3 };

        String[] usernames = { "nam_vku", "vti_student", "admin" };

        Group group2 = new Group("VTI Academy", acc3, usernames, LocalDate.of(2026, 5, 3));

    }

}
