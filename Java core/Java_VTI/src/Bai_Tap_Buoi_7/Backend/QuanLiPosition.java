package Bai_Tap_Buoi_7.Backend;

import Bai_Tap_Buoi_7.Database.JDBCUtil;
import Bai_Tap_Buoi_7.Entity.Position;
import Bai_Tap_Buoi_7.Enums.PositionName;
import Bai_Tap_Buoi_7.Services.Interface_Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuanLiPosition implements Interface_Position {

    @Override
    public List<Position> showAllPosition() {
        List<Position> positionList=new ArrayList<>();
        try
        {
            Connection con= JDBCUtil.getConnection();
            String sql="select * from `position`";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next())
            {
                int positionId =rs.getInt("position_id");
                String name=rs.getString("position_name");
                PositionName positionName=PositionName.valueOf(name);
                Position position=new Position(positionId,positionName);
                positionList.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }

    @Override
    public List<Position> findByPositionName(String name) {
        List<Position> positionList=new ArrayList<>();
        try
        {
            Connection con= JDBCUtil.getConnection();
            String sql="select * from `position` where position_name like ?";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next())
            {
                int positionId =rs.getInt("position_id");
                String namea=rs.getString("position_name");
                PositionName positionName=PositionName.valueOf(namea);
                Position position=new Position(positionId,positionName);
                positionList.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }
}
