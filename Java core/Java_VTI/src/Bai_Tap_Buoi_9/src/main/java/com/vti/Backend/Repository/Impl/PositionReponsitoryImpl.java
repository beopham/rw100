package com.vti.Backend.Repository.Impl;

import com.vti.Backend.Repository.IPositionReponsitory;
import com.vti.Entity.Position;
import com.vti.Enums.PositionName;
import com.vti.Utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionReponsitoryImpl implements IPositionReponsitory {

    @Override
    public List<Position> findAll() {
        List<Position> positionList = new ArrayList<>();
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from `position`";
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int positionId = rs.getInt("position_id");
                String name = rs.getString("position_name");
                PositionName positionName = PositionName.valueOf(name);
                Position position = new Position(positionId, positionName);
                positionList.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return positionList;
    }

    @Override
    public boolean Insert(Position position) {
        boolean ketqua = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "INSERT INTO `position` (position_name) VALUES (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, position.getPositionName().toString());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement, null);
        }
        return ketqua;
    }

    @Override
    public boolean Update(Position position) {
        boolean ketqua = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "UPDATE `rw100_testing_system`.`position` SET `position_name` = ? WHERE `position_id` = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, position.getPositionName().toString());
            preparedStatement.setInt(2, position.getPositionId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement, null);
        }
        return ketqua;
    }

    @Override
    public boolean Delete(int id) {
        boolean ketqua = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "DELETE FROM `rw100_testing_system`.`position` WHERE `position_id` = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement, null);
        }
        return ketqua;
    }

    @Override
    public Position selectByid(int id) {
        Position position = null;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM `position` WHERE position_id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int positionId = rs.getInt("position_id");
                String name = rs.getString("position_name");
                PositionName positionName = PositionName.valueOf(name);
                position = new Position(positionId, positionName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return position;
    }

    @Override
    public boolean checkPositionNameExist(PositionName positionName) {
        boolean check = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from `position` WHERE position_name = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, positionName.toString());
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return check;
    }

    @Override
    public boolean checkId(int id) {
        boolean check = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from `position` WHERE position_id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return check;
    }

    @Override
    public boolean checkExistNameAndIdNot(PositionName positionName, int id) {
        boolean check = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from `position` WHERE position_name = ? AND position_id != ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, positionName.toString());
            preparedStatement.setInt(2, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return check;
    }
}