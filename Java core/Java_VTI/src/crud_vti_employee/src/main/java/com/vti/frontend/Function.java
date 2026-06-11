package com.vti.frontend;

import com.vti.backend.controller.UserController;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

import java.util.List;
import java.util.Scanner;

public class Function {
    private UserController userController = new UserController();
    private ScannerUtils scannerUtils = new ScannerUtils();
    private Scanner sc = new Scanner(System.in);

    public void showuser() {
        List<User> userList = userController.findAll();
        for (User user : userList) {
            user.showShortInfo();
        }
    }

    public void showuserALL() {
        List<User> userList = userController.findAll();
        for (User user : userList) {
            user.show();
        }
    }

    public void timusertheoID() {
        System.out.println("Nhập vào ID");
        int id = scannerUtils.inputId();
        User user = userController.findById(id);
        if (user == null) {
            System.out.println("ID bạn nhập vào k có");
        }
        else
        {
            System.out.println("--- Thông tin User tìm thấy ---");
            user.show();
        }
    }

    public void deleteuser() {
        System.out.println("Nhập vào ID");
        int id = scannerUtils.inputId();
        User user = userController.findById(id);
        if (user == null) {
            System.out.println("ID bạn nhập vào k có");
        }
        else
        {
            userController.deleteById(id);
            System.out.println("xóa thành công");
        }
    }
   public void loginuser()
   {
       System.out.println("--- ĐĂNG NHẬP HỆ THỐNG ---");

       System.out.print("Nhập vào Email: ");
       String email=scannerUtils.nhapEmail();

       System.out.print("Nhập vào password: ");
       String pw=scannerUtils.nhapmk();
       User user=userController.login(email,pw);
       if (user == null) {
           System.out.println("Bạn phải đăng kí thông tin kia mới đăng nhp đc");
       }
       else
       {
           System.out.println("login thành công");
       }
   }
   public void themnhanvien()
   {

   }
}
