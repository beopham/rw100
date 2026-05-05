package Bai_Tap_Buoi_4.Exercise_3_Access_Modifier.entity;

public class Position {
    private int positionID;
    private PositionName positionName;

    // --- GETTER & SETTER ---
    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }


    public void show() {
        System.out.println("Position Information ");
        System.out.println("PositionID: " + this.positionID);
        System.out.println("PositionName: " + this.positionName);
        System.out.println("======================");
    }


    public static void main(String[] args) {
        // Đối tượng 1
        Position pos1 = new Position();
        pos1.setPositionID(1);
        pos1.setPositionName(PositionName.DEV);

        // Đối tượng 2
        Position pos2 = new Position();
        pos2.setPositionID(2);
        pos2.setPositionName(PositionName.TEST);

        // Đối tượng 3
        Position pos3 = new Position();
        pos3.setPositionID(3);
        pos3.setPositionName(PositionName.PM);

        // Gọi hàm show()
        pos1.show();
        pos2.show();
        pos3.show();
    }
}