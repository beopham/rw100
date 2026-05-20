package com.vti.Backend.Repository.Impl;

import com.vti.Backend.Repository.IAccountReponsitory;
import com.vti.Backend.Service.Impl.AccountServiceImpl;
import com.vti.Entity.Account;
import com.vti.Entity.Department;
import com.vti.Entity.Position;
import com.vti.Utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountReponsitoryImpl implements IAccountReponsitory {
    @Override
    public List<Account> findAll() {
        List<Account> accountList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "select * from `account`";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("account_id");
                String email = rs.getString("email");
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                LocalDateTime createDate = rs.getObject("create_date", LocalDateTime.class);
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                Position position = new Position();
                position.setPositionId(rs.getInt("position_id"));
                Account account = new Account(id, email, userName, fullName, department, position, createDate);
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;

    }

    @Override
    public boolean Insert(Account account) {
        boolean ketqua = false;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO `account` (\n" +
                        "    email,\n" +
                        "    username,\n" +
                        "    full_name,\n" +
                        "    department_id,\n" +
                        "    position_id\n" +
                        ")\n" +
                        "VALUES\n" +
                        "(?,?,?,?,?),";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, account.getEmail());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getFullName());
            preparedStatement.setInt(4, account.getDepartment().getDepartmentId());
            preparedStatement.setInt(5, account.getPosition().getPositionId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketqua;

    }

    @Override
    public boolean Update(Account account) {
        boolean ketqua = false;
        try {
            Connection con = JDBCUtil.getConnection();
            // 1. Dùng lệnh UPDATE, không dùng INSERT
            String sql = "UPDATE `account`" +
                    " SET `email` = ?," +
                    " `username` = ?, " +
                    "`full_name` = ?, " +
                    "`department_id` = ?," +
                    "`position_id` = ? " +
                    "WHERE `account_id` = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, account.getEmail());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getFullName());
            preparedStatement.setInt(4, account.getDepartment().getDepartmentId());
            preparedStatement.setInt(5, account.getPosition().getPositionId());
            preparedStatement.setInt(6, account.getAccountId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketqua;

    }

    @Override
    public boolean Delete(int id) {
        boolean ketqua = false;
        try {
            Connection con = JDBCUtil.getConnection();
            // 1. Dùng lệnh UPDATE, không dùng INSERT
            String sql = " DELETE FROM `rw100_testing_system`.`account`" +
                    " WHERE (`account_id` = ?);\n";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketqua;

    }

    @Override
    public Account selectByid(int id) {
        Account account = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "select * from   `account` where account_id =?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idac = rs.getInt("account_id");
                String email = rs.getString("email");
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                LocalDateTime createDate = rs.getObject("create_date", LocalDateTime.class);
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                Position position = new Position();
                position.setPositionId(rs.getInt("position_id"));
                account = new Account(idac, email, userName, fullName, department, position, createDate);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;

    }

    @Override
    public boolean checkUsernameExist(String username) {
        boolean check=false;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "select * from `account` WHERE username = ?" ;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                check=true;
            }
            JDBCUtil.closeConnection(con,preparedStatement,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean checkEmailExist(String email) {
        boolean check=false;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "select * from `account` WHERE email = ?" ;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,email);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                check=true;
            }
            JDBCUtil.closeConnection(con,preparedStatement,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean checkAccountIdExist(int id) {
        boolean check=false;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "select * from `account` WHERE account_id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                check=true;
            }
            JDBCUtil.closeConnection(con,preparedStatement,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
