package Pham_Van_Nam_VTI_BUOI_1;

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
