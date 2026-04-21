package Bai_Tap_Buoi_2;

import java.time.LocalDate;

public class Group {
    int groupId;
    String groupName;
    Account account; // Đây là ID của Account đã tạo nhóm này
    LocalDate createDate;

    public void show() {
        System.out.println("Group Information ");
        System.out.println("GroupID: " + groupId);
        System.out.println("GroupName: " + groupName);
        System.out.println("Creator: " + account.AccountID);
        System.out.println("Create Date: " + createDate);
        System.out.println("======================");
    }
}
