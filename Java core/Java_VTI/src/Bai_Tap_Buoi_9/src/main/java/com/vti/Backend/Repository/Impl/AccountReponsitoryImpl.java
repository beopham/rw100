package com.vti.Backend.Repository.Impl;

import com.vti.Backend.Repository.IAccountReponsitory;
import com.vti.Entity.Account;
import com.vti.Entity.Department;
import com.vti.Entity.Position;
import com.vti.Utils.JDBCUtil;

import java.io.BufferedReader;
import java.io.FileReader;
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
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from `account`";
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
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
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return accountList;
    }

    @Override
    public boolean Insert(Account account) {
        boolean ketqua = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "INSERT INTO `account` (email, username, full_name, department_id, position_id) VALUES (?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
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
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, null);
        }
        return ketqua;
    }

    @Override
    public boolean Update(Account account) {
        boolean ketqua = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "UPDATE `account` SET `email` = ?, `username` = ?, `full_name` = ?, `department_id` = ?, `position_id` = ? WHERE `account_id` = ?";
            preparedStatement = con.prepareStatement(sql);
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
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, null);
        }
        return ketqua;
    }

    @Override
    public boolean Delete(int id) {
        boolean ketqua = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = " DELETE FROM `rw100_testing_system`.`account` WHERE (`account_id` = ?);";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, null);
        }
        return ketqua;
    }

    @Override
    public Account selectByid(int id) {
        Account account = null;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from `account` where account_id =?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
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
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return account;
    }

    @Override
    public boolean checkUsernameExist(String username) {
        boolean check = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from `account` WHERE username = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
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
    public boolean checkEmailExist(String email) {
        boolean check = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from `account` WHERE email = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
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
    public boolean checkAccountIdExist(int id) {
        boolean check = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from `account` WHERE account_id = ?";
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
    public boolean importAccountFromCSV(String pathName) {
        boolean importfile=false;

        if (!pathName.endsWith(".csv")) {
            System.out.println("Lỗi: File được chọn không phải là file CSV!");
            return false; // Phải trả về false vì kiểu hàm là boolean
        }
        try (BufferedReader rd = new BufferedReader(new FileReader(pathName))) {
            String line=rd.readLine();
            while ((line= rd.readLine()) !=null)
            {
                String dsaccount[]=line.split(",");
                String email = dsaccount[0].trim();
                String username = dsaccount[1].trim();
                String fullname = dsaccount[2].trim();

                int departmentID = Integer.parseInt(dsaccount[3].trim());
                int positionID = Integer.parseInt(dsaccount[4].trim());
                Department department=new Department(departmentID);
                Position position=new Position(positionID);
                Account account= new Account(email,username,fullname,department,position);
                if(Insert(account))
                {
                    importfile=true;
                }
            }

        } catch (Exception e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            e.printStackTrace();
            return  false;
        }

        return importfile;
    }
}