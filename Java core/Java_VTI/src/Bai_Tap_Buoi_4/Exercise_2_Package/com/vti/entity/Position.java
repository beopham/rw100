package Bai_Tap_Buoi_4.Exercise_2_Package.com.vti.entity;

public class Position {
    int PositionID;
    PositionName positionName;

    public void show() {
        System.out.println("Position Information ");
        System.out.println("PositionID: " + PositionID);
        System.out.println("PositionName: " + positionName);
        System.out.println("======================");
    }

    public static void main(String[] args) {
        // Đối tượng 1
        Position pos1 = new Position();
        pos1.PositionID = 1;
        pos1.positionName = PositionName.DEV;

        // Đối tượng 2
        Position pos2 = new Position();
        pos2.PositionID = 2;
        pos2.positionName = PositionName.TEST;

        // Đối tượng 3
        Position pos3 = new Position();
        pos3.PositionID = 3;
        pos3.positionName = PositionName.PM;

        // Gọi hàm show() để kiểm tra kết quả
        pos1.show();
        pos2.show();
        pos3.show();
    }
}