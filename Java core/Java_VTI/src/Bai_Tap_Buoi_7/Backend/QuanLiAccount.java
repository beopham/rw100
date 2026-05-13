package Bai_Tap_Buoi_7.Backend;

import Bai_Tap_Buoi_7.Database.JDBCUtil;
import Bai_Tap_Buoi_7.Entity.Account;
import Bai_Tap_Buoi_7.Entity.Department;
import Bai_Tap_Buoi_7.Entity.Position;
import Bai_Tap_Buoi_7.Services.Interface_Account;

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
        List<Account> accountList=new ArrayList<>();
        try
        {
            Connection con= JDBCUtil.getConnection();
            String sql="select * from `account`";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next())
            {

                int id = rs.getInt("account_id");
                String email = rs.getString("email");
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                LocalDateTime createDate = rs.getObject("create_date", LocalDateTime.class);
                Department department=new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                Position position=new Position();
                position.setPositionId(rs.getInt("position_id"));
                Account account=new Account(id,email,userName,fullName,department,position,createDate);
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public List<Account> findByFullname(String fullname) {
        List<Account> accountList=new ArrayList<>();
        try
        {
            Connection con= JDBCUtil.getConnection();
            String sql="select * from `account` where username like ?";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + fullname + "%");
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("account_id");
                String email = rs.getString("email");
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                LocalDateTime createDate = rs.getObject("create_date", LocalDateTime.class);
                Department department=new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                Position position=new Position();
                position.setPositionId(rs.getInt("position_id"));
                Account account=new Account(id,email,userName,fullName,department,position,createDate);
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public List<Account> findByFullnameAndUsername(String fullname, String username) {
        List<Account> accountList=new ArrayList<>();
        try
        {
            Connection con= JDBCUtil.getConnection();
            String sql = "SELECT * FROM `account` WHERE full_name LIKE ? AND username LIKE ?";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + fullname + "%");
            preparedStatement.setString(2, "%" + username + "%");
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("account_id");
                String email = rs.getString("email");
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                LocalDateTime createDate = rs.getObject("create_date", LocalDateTime.class);
                Department department=new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                Position position=new Position();
                position.setPositionId(rs.getInt("position_id"));
                Account account=new Account(id,email,userName,fullName,department,position,createDate);
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;

    }
}
