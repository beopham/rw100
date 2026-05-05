package Bai_Tap_Buoi_4.Exercise_3_Access_Modifier.entity;

import java.time.LocalDate;

public class Group {
    private int groupID;
    private String groupName;
    private Account creator;
    private Account[] accounts;
    private String[] usernames;
    private LocalDate createDate;

    // --- GETTER & SETTER ---
    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public String[] getUsernames() {
        return usernames;
    }

    public void setUsernames(String[] usernames) {
        this.usernames = usernames;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    // --- CONSTRUCTORS ---
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

    // --- METHOD SHOW ---
    public void showGroupInfo() {
        System.out.println("Group: " + this.groupName);
        // Vì Username trong lớp Account đã là private, nên phải dùng .getUsername()
        System.out.println("Creator: " + (this.creator != null ? this.creator.getUsername() : "Unknown"));
        System.out.println("Create Date: " + this.createDate);
        System.out.println("--------------------------");
    }


}