package Bai_Tap_Buoi_4.Exercise_1_Constructor;


import java.time.LocalDate;

public class Group {
    int groupID;
    String groupName;
    Account creator;
    Account[] accounts;
    String[] usernames;
    LocalDate createDate;

    public Group() {
    }

    public Group(String groupName, Account creator, Account[] accounts, LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }

    public Group(String groupName, Account creator, String[] usernames, LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.usernames = usernames;
        this.createDate = createDate;
    }

    public void showGroupInfo() {
        System.out.println("Group: " + groupName);
        System.out.println("Creator: " + (creator != null ? creator.Username : "Unknown"));
        System.out.println("Create Date: " + createDate);
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        // Lấy lại acc2 và acc3 từ bài trước
        Account acc2 = new Account(1, "nam.pv@gmail.com", "nam_vku", "Phạm", "Nam");
        Account acc3 = new Account(2, "vti.academy@gmail.com", "vti_student", null, "Nguyễn", "An");
        // 1. Khởi tạo mảng Account
        Account[] groupAccounts = { acc2, acc3 };

        // 2. Sử dụng Constructor loại 2 (truyền mảng Account)
        Group group1 = new Group("Java Class", acc2, groupAccounts, LocalDate.now());

        // 3. Khởi tạo mảng Username (String)
        String[] usernames = { "nam_vku", "vti_student", "admin" };

        // 4. Sử dụng Constructor loại 3 (truyền mảng String usernames)
        Group group2 = new Group("VTI Academy", acc3, usernames, LocalDate.of(2026, 5, 3));

        // In thử thông tin
        group1.showGroupInfo();
        group2.showGroupInfo();
    }
}
