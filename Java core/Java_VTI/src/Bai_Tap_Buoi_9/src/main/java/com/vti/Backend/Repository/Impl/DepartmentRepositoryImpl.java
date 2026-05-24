package com.vti.Backend.Repository.Impl;

import com.vti.Backend.Repository.IDepartmentRepository;
import com.vti.Entity.Department;
import com.vti.Utils.JDBCUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements IDepartmentRepository {

    @Override
    public List<Department> findAll() {
        List<Department> departmentList = new ArrayList<>();
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM department";
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                Department department = new Department(departmentId, departmentName);
                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return departmentList;
    }

    @Override
    public boolean Insert(Department department) {
        boolean ketqua = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = JDBCUtil.getConnection();
            String sql = "INSERT INTO department (department_name) VALUES (?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, department.getDepartmentName());
            int thaydoi = preparedStatement.executeUpdate();
            if (thaydoi > 0) {
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
    public boolean Update(Department department) {
        boolean ketqua = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = JDBCUtil.getConnection();
            String sql = "UPDATE department SET department_name = ? WHERE department_id = ?;";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setInt(2, department.getDepartmentId());
            int thaydoi = preparedStatement.executeUpdate();
            if (thaydoi > 0) {
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
            String sql = "DELETE FROM department WHERE department_id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int thaydoi = preparedStatement.executeUpdate();
            if (thaydoi > 0) {
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
    public Department selectByid(int id) {
        Department department = null;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM department WHERE department_id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                department = new Department(departmentId, departmentName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return department;
    }

    @Override
    public boolean checkId(int id) {
        boolean check_id = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM department WHERE department_id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                check_id = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return check_id;
    }

    @Override
    public boolean checkName(String name) {
        boolean check_name = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM department WHERE department_name = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                check_name = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return check_name;
    }

    @Override
    public boolean checkExistNameAndIdNot(String name, int id) {
        boolean check_name_id = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from department where department_name =? and department_id !=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                check_name_id = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con, preparedStatement, rs);
        }
        return check_name_id;
    }

    //    pathName = "D:/rw100/Java core/Java_VTI/src/CSV/department_name.csv";
    @Override
    public boolean importDepartmentFromCSV(String pathName) {
         boolean importfile=false;

        if (!pathName.endsWith(".csv")) {
            System.out.println("Lỗi: File được chọn không phải là file CSV!");
            return false; // Phải trả về false vì kiểu hàm là boolean
        }
        try (BufferedReader rd = new BufferedReader(new FileReader(pathName))) {
            String line;
            while ((line= rd.readLine()) !=null)
            {
                System.out.println(line);
                String danhsachtenphongban[]=line.split(",");
                String tenpb=danhsachtenphongban[0];
                Department department=new Department(tenpb);
                boolean ketqua=Insert(department);
                if(ketqua)
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