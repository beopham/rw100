package com.vti.Backend.Controller;

import com.vti.Entity.Position;
import com.vti.Enums.PositionName;

import java.util.List;
import java.util.Scanner;

public class PositionTest {
    private PositionController positionController = new PositionController();
    private Scanner sc = new Scanner(System.in);

    public void showPosition()
    {
        System.out.println("---------- DANH SÁCH TẤT CẢ CHỨC VỤ ----------");
        List<Position> list = positionController.findAll();
        if (list == null || list.isEmpty()) {
            System.out.println("Không tìm thấy chức vụ nào trong cơ sở dữ liệu.");
        } else {
            for (Position pos : list) {
                pos.showInfo(); // Dùng showInfo() cho đồng bộ với các class khác
            }
        }
        System.out.println("----------------------------------------------");
    }
    public void insertPosition() {
        System.out.println("--- THÊM MỚI CHỨC VỤ ---");
        System.out.println("Chọn tên chức vụ: 1.DEV, 2.TEST, 3.SCRUM_MASTER, 4.PM");
        System.out.print("Lựa chọn của bạn: ");
        int chon = sc.nextInt();
        sc.nextLine();
        PositionName positionName = null;
        if (chon == 1) {
            positionName = PositionName.DEV;
        } else if (chon == 2) {
            positionName = PositionName.TEST;
        } else if (chon == 3) {
            positionName = PositionName.SCRUM_MASTER;
        } else if (chon == 4) {
            positionName = PositionName.PM;
        } else {
            System.out.println("lựa chọn k hợp lệ");
            return;
        }
        Position position = new Position(positionName);
        if (positionController.Insert(position)) {
            System.out.println("thêm thành công");
        } else {
            System.out.println("Thêm Không thành công");
        }
    }
    public void updatePosition()
    {
        System.out.println("--- Cập Nhập CHỨC VỤ ---");
        System.out.print("Nhập vào ID ");
        int chonid = sc.nextInt();
        sc.nextLine();
        Position kiemtraid = positionController.selectByid(chonid);
        if (kiemtraid == null) {
            System.out.println("Không tìm thấy ID");
            return;
        }
        System.out.println("Thông tin chức vụ hiện tại" + kiemtraid.getPositionName());
        System.out.println("Chọn tên chức vụ mới: 1.DEV, 2.TEST, 3.SCRUM_MASTER, 4.PM");
        System.out.print("Lựa chọn của bạn: ");
        int chon = sc.nextInt();
        sc.nextLine();
        if (chon == 1) {
            kiemtraid.setPositionName(PositionName.DEV);
        } else if (chon == 2) {
            kiemtraid.setPositionName(PositionName.TEST);
        } else if (chon == 3) {
            kiemtraid.setPositionName(PositionName.SCRUM_MASTER);
        } else if (chon == 4) {
            kiemtraid.setPositionName(PositionName.PM);
        } else {
            System.out.println("lựa chọn k hợp lệ");
            return;
        }
        if (positionController.Update(kiemtraid)) {
            System.out.println("Cập nhập thành công");
        } else {
            System.out.println("k cập nhập đc");
        }
    }
    public void deletePosition()
    {
        System.out.println("--- Xóa CHỨC VỤ ---");
        System.out.print("Nhập vào ID ");
        int chonid = sc.nextInt();
        sc.nextLine();
        Position kiemtraid = positionController.selectByid(chonid);
        if (kiemtraid == null) {
            System.out.println("Không tìm thấy ID");
            return;
        }
        if (positionController.Delete(chonid)) {
            System.out.println("xóa thành công");
        } else {
            System.out.println("xóa Không thành công");
        }

    }
}
