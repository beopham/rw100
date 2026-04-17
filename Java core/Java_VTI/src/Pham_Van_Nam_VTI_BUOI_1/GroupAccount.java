package Pham_Van_Nam_VTI_BUOI_1;

import java.time.LocalDate;

public class GroupAccount {
    Group group;      // Thay vì int GroupID
    Account account;  // Thay vì int AccountID
    LocalDate joinDate;

    public void show() {
        System.out.println("Group Account Information");
        // Kiểm tra null để tránh lỗi nếu chưa gán đối tượng

        System.out.println("Group Name: " + group.groupId);
        System.out.println("User Name: " + account.AccountID);
        System.out.println("Join Date: " + joinDate);
        System.out.println("======================");
    }
}
