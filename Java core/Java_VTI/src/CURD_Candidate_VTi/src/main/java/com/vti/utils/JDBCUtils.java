package com.vti.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

    private static final String URL = "jdbc:mysql://localhost:3306/thithu_vti_candidate";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    // Mở kết nối đến Database
    public static Connection getConnection() {
        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Lỗi: Không thể kết nối đến Database!");
            e.printStackTrace();
        }
        return c;
    }

    // Hàm 1: Đóng cả 3 tài nguyên (Dùng cho các câu lệnh SELECT cần đọc dữ liệu)
    public static void closeConnection(Connection c, Statement st, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println("Lỗi: Không thể đóng ResultSet!");
        }

        try {
            if (st != null && !st.isClosed()) {
                st.close();
            }
        } catch (SQLException e) {
            System.err.println("Lỗi: Không thể đóng Statement!");
        }

        try {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        } catch (SQLException e) {
            System.err.println("Lỗi: Không thể đóng Connection!");
        }
    }

    // Hàm 2: Đóng 2 tài nguyên (Dùng cho INSERT, UPDATE, DELETE - không có ResultSet)
    public static void closeConnection(Connection c, Statement st) {
        closeConnection(c, st, null); // Gọi lại hàm 3 tham số phía trên, truyền rs = null
    }

    // Hàm 3: Chỉ đóng Connection (Giữ lại hàm cũ của bạn để tránh lỗi ở các class khác)
    public static void closeConnection(Connection c) {
        closeConnection(c, null, null); // Gọi lại hàm 3 tham số phía trên, truyền st và rs = null
    }
}
