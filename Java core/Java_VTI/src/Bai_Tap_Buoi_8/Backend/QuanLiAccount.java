package Bai_Tap_Buoi_8.Backend;

import Bai_Tap_Buoi_8.Database.JDBCUtil;
import Bai_Tap_Buoi_8.Entity.Account;
import Bai_Tap_Buoi_8.Entity.Department;
import Bai_Tap_Buoi_8.Entity.Position;
import Bai_Tap_Buoi_8.Services.Interface_Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuanLiAccount implements Interface_Account {
    @Override
    public List<Account> showAllAccount() {
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
    public List<Account> findByFullname(String fullname) {
        List<Account> accountList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "select * from `account` where username like ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + fullname + "%");
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
    public List<Account> findByFullnameAndUsername(String fullname, String username) {
        List<Account> accountList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM `account` WHERE full_name LIKE ? AND username LIKE ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + fullname + "%");
            preparedStatement.setString(2, "%" + username + "%");
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
    public boolean insert(Account account) {
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
    public boolean update(Account account) {
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
    public boolean delete(int id) {

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
    public Account getById(int idac) {
        Account account = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "select * from   `account` where account_id =?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idac);
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
                account = new Account(id, email, userName, fullName, department, position, createDate);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
