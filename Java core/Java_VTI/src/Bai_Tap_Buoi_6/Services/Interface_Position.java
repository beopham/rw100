package Bai_Tap_Buoi_6.Services;

import Bai_Tap_Buoi_6.Entity.Position;

import java.util.List;

public interface Interface_Position {
    public List<Position> showAllPosition();

    public List<Position> findByPositionName(String name);
}
