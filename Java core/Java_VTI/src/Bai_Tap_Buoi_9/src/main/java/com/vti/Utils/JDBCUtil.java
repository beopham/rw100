package com.vti.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {


    private static final String URL = "jdbc:mysql://localhost:3306/rw100_testing_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
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

    public static void closeConnection(Connection c) {
        try {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        } catch (SQLException e) {
            System.err.println("Lỗi: Không thể đóng kết nối!");
            e.printStackTrace();
        }
    }
}