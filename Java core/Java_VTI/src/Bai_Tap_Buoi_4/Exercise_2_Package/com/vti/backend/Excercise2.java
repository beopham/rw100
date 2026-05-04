package Bai_Tap_Buoi_4.Exercise_2_Package.com.vti.backend;

import Bai_Tap_Buoi_4.Exercise_1_Constructor.Account;
import Bai_Tap_Buoi_4.Exercise_1_Constructor.Position;
import Bai_Tap_Buoi_4.Exercise_1_Constructor.PositionName;

import java.time.LocalDate;

public class Excercise2 {
    public void question1()
    {
        Position pos = new Position();
        pos.PositionID = 1;
        pos.positionName = PositionName.DEV;
        Account acc1 = new Account();
        acc1.AccountID = 1;
        acc1.Email = "nam.vku@gmail.com";
        acc1.Username = "nam_vku";
        acc1.FirstName = "Phạm";
        acc1.LastName = "Nam";
        acc1.fullName = acc1.FirstName + " " + acc1.LastName; // Tự ghép logic fullName
        acc1.position = pos; // Gán đối tượng Position đã tạo ở trên
        acc1.localDate = LocalDate.now(); // Gán ngày hiện tại

    }
    public void question2()
    {
        Position pos = new Position();
        pos.PositionID = 1;
        pos.positionName = PositionName.DEV;
        Account acc2 = new Account(1, "nam.pv@gmail.com", "nam_vku", "Phạm", "Nam");
    }
    public void question3()
    {
        Position pos = new Position();
        pos.PositionID = 1;
        pos.positionName = PositionName.DEV;
        Account acc3 = new Account(2, "vti.academy@gmail.com", "vti_student", pos, "Nguyễn", "An");
    }
    public void question4()
    {
        Position pos = new Position();
        pos.PositionID = 1;
        pos.positionName = PositionName.DEV;
        Account acc4 = new Account(3, "test.user@yahoo.com", "tester_01", pos, LocalDate.of(2025, 12, 25), "Lê", "Bình");

    }
}
