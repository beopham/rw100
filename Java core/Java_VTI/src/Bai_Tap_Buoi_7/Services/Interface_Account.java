package Bai_Tap_Buoi_7.Services;

import Bai_Tap_Buoi_7.Entity.Account;

import java.util.List;

public interface Interface_Account {
    // Chỉ in ra thôi nên dùng void
    public List<Account> showAllAccount();

    // Tìm xong trả về danh sách để nơi khác còn dùng lại dữ liệu này
    public List<Account> findByFullname(String fullname);

    // Tìm xong trả về danh sách kết quả
    public List<Account> findByFullnameAndUsername(String fullname, String username);
}
