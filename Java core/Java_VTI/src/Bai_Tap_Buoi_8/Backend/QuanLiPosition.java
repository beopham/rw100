package Bai_Tap_Buoi_8.Backend;

import Bai_Tap_Buoi_8.Database.JDBCUtil;
import Bai_Tap_Buoi_8.Entity.Position;
import Bai_Tap_Buoi_8.Enums.PositionName;
import Bai_Tap_Buoi_8.Services.Interface_Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuanLiPosition implements Interface_Position {

    @Override
    public List<Position> showAllPosition() {
        List<Position> positionList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "select * from `position`";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int positionId = rs.getInt("position_id");
                String name = rs.getString("position_name");
                PositionName positionName = PositionName.valueOf(name);
                Position position = new Position(positionId, positionName);
                positionList.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }

    @Override
    public List<Position> findByPositionName(String name) {
        List<Position> positionList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "select * from `position` where position_name like ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int positionId = rs.getInt("position_id");
                String namea = rs.getString("position_name");
                PositionName positionName = PositionName.valueOf(namea);
                Position position = new Position(positionId, positionName);
                positionList.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }

    @Override
    public boolean insert(Position position) {
        boolean ketqua = false;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "INSERT INTO `position` (position_name)\n" +
                         "VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, position.getPositionName().toString());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public boolean delete(int id) {
        boolean ketqua = false;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "DELETE FROM `rw100_testing_system`.`position`" +
                    "WHERE `position_id` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public boolean update(Position position) {
        boolean ketqua = false;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "UPDATE `rw100_testing_system`.`position` " +
                         "SET `position_name` = ? " +
                         "WHERE `position_id` = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, position.getPositionName().toString());
            preparedStatement.setInt(2, position.getPositionId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public Position getById(int id) {
        Position position=null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM `position` WHERE position_id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int positionId = rs.getInt("position_id");
                String name = rs.getString("position_name");
                PositionName positionName = PositionName.valueOf(name);
                position = new Position(positionId, positionName);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return position;
    }
}
