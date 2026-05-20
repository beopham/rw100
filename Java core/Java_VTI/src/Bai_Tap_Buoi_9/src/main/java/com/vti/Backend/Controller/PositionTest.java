package com.vti.Backend.Controller;

import com.vti.Entity.Position;
import com.vti.Enums.PositionName;

import java.util.List;
import java.util.Scanner;

public class PositionTest {
    private PositionController positionController = new PositionController();
    private Scanner sc = new Scanner(System.in);

    public void showPosition() {
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
        if (positionController.checkPositionNameExist(positionName)) {
            System.out.println("Tên này đã tổn tại r");
            return;
        }
        Position position = new Position(positionName);
        if (positionController.Insert(position)) {
            System.out.println("thêm thành công");
        } else {
            System.out.println("Thêm Không thành công");
        }
    }

    public void updatePosition() {
        System.out.println("--- CẬP NHẬT CHỨC VỤ ---");
        int chonid;

        while (true) {
            System.out.print("Nhập vào ID chức vụ cần cập nhật: ");
            chonid = sc.nextInt();
            sc.nextLine();

            if (chonid <= 0) {
                System.out.println("Bạn phải nhập ID lớn hơn 0!");
                continue;
            }
            if (!positionController.checkId(chonid)) {
                System.out.println("ID không chính xác vì nó không có trong database! Vui lòng nhập lại.");
                continue;
            }
            break;
        }

        Position positionUpdate = positionController.selectByid(chonid);
        if (positionUpdate == null) {
            System.out.println("Không tìm thấy thông tin chức vụ!");
            return;
        }
        System.out.println("-> Chức vụ hiện tại: " + positionUpdate.getPositionName());
        System.out.println("-------------------------------------------------");

        PositionName targetPositionName = null;

        while (true) {
            System.out.println("Chọn tên chức vụ mới: 1.DEV, 2.TEST, 3.SCRUM_MASTER, 4.PM");
            System.out.print("Lựa chọn của bạn (1-4): ");
            int chon = sc.nextInt();
            sc.nextLine();

            if (chon == 1) {
                targetPositionName = PositionName.DEV;
            } else if (chon == 2) {
                targetPositionName = PositionName.TEST;
            } else if (chon == 3) {
                targetPositionName = PositionName.SCRUM_MASTER;
            } else if (chon == 4) {
                targetPositionName = PositionName.PM;
            } else {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại từ 1 đến 4.");
                System.out.println("-------------------------------------------------");
                continue;
            }

            if (positionController.checkExistNameAndIdNot(targetPositionName, chonid)) {
                System.out.println("Lỗi: Chức vụ " + targetPositionName + " đã tồn tại ở một ID khác trong hệ thống rồi!");
                System.out.println("Vui lòng chọn chức vụ khác.");
                System.out.println("-------------------------------------------------");
                continue;
            }

            break;
        }

        positionUpdate.setPositionName(targetPositionName);

        if (positionController.Update(positionUpdate)) {
            System.out.println("Cập nhật chức vụ thành công!");
        } else {
            System.out.println("Cập nhật thất bại!");
        }
    }

    public void deletePosition() {
        System.out.println("--- Xóa CHỨC VỤ ---");
        int chonid;
        while (true) {
            System.out.print("Nhập vào ID ");
            chonid = sc.nextInt();
            sc.nextLine();
            if(chonid<0)
            {
                System.out.println("bạn phải nhập id lớn hơn 0");
                continue;
            }
            if(!positionController.checkId(chonid))
            {
                System.out.println("bạn nhập id k chính xác vì nó k c trong database");
                continue;
            }
            break;
        }

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
