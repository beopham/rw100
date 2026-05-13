package Bai_Tap_Buoi_7.Backend;

import Bai_Tap_Buoi_7.Database.JDBCUtil;
import Bai_Tap_Buoi_7.Entity.Department;
import Bai_Tap_Buoi_7.Services.Interface_Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuanLiDepartment implements Interface_Department {


    @Override
    public List<Department> inDanhSachPhongBanCoTu2NhanVien() {
        List<Department> departmentList=new ArrayList<>();

        try {
            Connection con= JDBCUtil.getConnection();
            String sql = "SELECT d.department_id, d.department_name " +
                    "FROM department d " +
                    "JOIN account a ON d.department_id = a.department_id " +
                    "GROUP BY d.department_id, d.department_name " +
                    "HAVING COUNT(a.account_id) >= 2";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next())
            {
                int departmentId=rs.getInt("department_id");
                String departmentName=rs.getString("department_name");
                Department department=new Department(departmentId,departmentName);
                departmentList.add(department);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentList;
    }
}
