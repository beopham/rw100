package Bai_Tap_Buoi_6.Entity;

import Bai_Tap_Buoi_6.Enums.PositionName;

public class Position {
    private int positionId;
    private PositionName positionName;

    public Position() {
    }

    public Position(PositionName positionName) {
        this.positionName = positionName;
    }

    public Position(int positionId, PositionName positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }

    // Getter và Setter
    public int getPositionId() {
        return this.positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName=" + positionName +
                '}';
    }
    // Hàm hiển thị chi tiết từng cột
    public void showInfo() {
        System.out.println("Mã chức vụ (ID): " + this.positionId);
        System.out.println("Tên chức vụ    : " + this.positionName);
        System.out.println("----------------------------");
    }
}