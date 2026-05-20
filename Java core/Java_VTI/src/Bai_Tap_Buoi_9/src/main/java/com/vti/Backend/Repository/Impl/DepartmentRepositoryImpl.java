package com.vti.Backend.Repository.Impl;

import com.vti.Backend.Repository.IDepartmentRepository;
import com.vti.Entity.Department;
import com.vti.Utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements IDepartmentRepository {

    @Override
    public List<Department> findAll() {
        List<Department> departmentList=new ArrayList<>();

        try {
            Connection con= JDBCUtil.getConnection();
            String sql = "SELECT * FROM department " ;
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next())
            {
                int departmentId=rs.getInt("department_id");
                String departmentName=rs.getString("department_name");
                Department department=new Department(departmentId,departmentName);
                departmentList.add(department);
            }
            JDBCUtil.closeConnection(con,preparedStatement,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentList;

    }

    @Override
    public boolean Insert(Department department) {

        boolean ketqua=false;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql = "INSERT INTO department (department_name) VALUES (?)";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setString(1,department.getDepartmentName());
            int thaydoi= preparedStatement.executeUpdate();
            if(thaydoi>0)
            {
                ketqua=true;
            }
            JDBCUtil.closeConnection(con,preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public boolean Update(Department department) {
        boolean ketqua=false;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql = "UPDATE department " +
                         "SET department_name = ?" +
                         " WHERE department_id = ?;";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setString(1,department.getDepartmentName());
            preparedStatement.setInt(2,department.getDepartmentId());
            int thaydoi= preparedStatement.executeUpdate();
            if(thaydoi>0)
            {
                ketqua=true;
            }
            JDBCUtil.closeConnection(con,preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketqua;
    }

    @Override
    public boolean Delete(int id) {

        boolean ketqua=false;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql = "DELETE FROM department WHERE department_id = ?";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int thaydoi= preparedStatement.executeUpdate();
            if(thaydoi>0)
            {
                ketqua=true;
            }
            JDBCUtil.closeConnection(con,preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public Department selectByid(int id) {
        Department department=null;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql = "SELECT * FROM department WHERE department_id = ?";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next())
            {
                int departmentId=rs.getInt("department_id");
                String departmentName=rs.getString("department_name");
                department=new Department(departmentId,departmentName);
            }
            JDBCUtil.closeConnection(con,preparedStatement,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;

    }

    @Override
    public boolean checkId(int id) {
        boolean check_id =false;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql = "SELECT * FROM department WHERE department_id = ?";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs= preparedStatement.executeQuery();
            if(rs.next())
            {
                check_id=true;
            }
            JDBCUtil.closeConnection(con,preparedStatement,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check_id;
    }
    @Override
    public boolean checkName(String name) {
        boolean check_name =false;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql = "SELECT * FROM department WHERE department_name = ?";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet rs= preparedStatement.executeQuery();
            if(rs.next())
            {
                check_name=true;
            }
            JDBCUtil.closeConnection(con,preparedStatement,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check_name;
    }

    @Override
    public boolean checkExistNameAndIdNot(String name, int id) {
        boolean check_name_id =false;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql = "select * from department where department_name =?" +
                         " and department_id !=?";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            ResultSet rs= preparedStatement.executeQuery();
            if(rs.next())
            {
                check_name_id=true;
            }
            JDBCUtil.closeConnection(con,preparedStatement,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check_name_id;
    }

}
