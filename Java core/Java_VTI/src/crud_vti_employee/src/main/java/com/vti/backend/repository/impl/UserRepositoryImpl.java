package com.vti.backend.repository.impl;

import com.vti.backend.repository.UserRepository;
import com.vti.entity.Admin;
import com.vti.entity.Employee;
import com.vti.entity.User;
import com.vti.enums.Role;
import com.vti.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        User user = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from `user`";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("user_id");
                String full_name = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Role role = resultSet.getObject("role", Role.class);
                if (Role.ADMIN.equals(role)) {
                    int exp_in_year = resultSet.getInt("exp_in_year");
                    user = new Admin(id, full_name, email, password, exp_in_year);
                    userList.add(user);
                } else if (Role.EMPLOYEE.equals(role)) {
                    String pro_skill = resultSet.getString("pro_skill");
                    user = new Employee(id, full_name, email, password, pro_skill);
                    userList.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, resultSet);
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from `user` where user_id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String full_name = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Role role = resultSet.getObject("role", Role.class);
                if (Role.ADMIN.equals(role)) {
                    int exp_in_year = resultSet.getInt("exp_in_year");
                    user = new Admin(userId, full_name, email, password, exp_in_year);
                    return user;
                } else if (Role.EMPLOYEE.equals(role)) {
                    String pro_skill = resultSet.getString("pro_skill");
                    user = new Employee(userId, full_name, email, password, pro_skill);
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, resultSet);
        }
        return user;
    }

    @Override
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from `user` where user_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement);
        }
    }

    @Override
    public User login(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from `user` where email =? and password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String full_name = resultSet.getString("full_name");
                String email_user = resultSet.getString("email");
                String password_user = resultSet.getString("password");
                Role role = resultSet.getObject("role", Role.class);
                if (Role.ADMIN.equals(role)) {
                    int exp_in_year = resultSet.getInt("exp_in_year");
                    user = new Admin(userId, full_name, email_user, password_user, exp_in_year);
                    return user;
                } else if (Role.EMPLOYEE.equals(role)) {
                    String pro_skill = resultSet.getString("pro_skill");
                    user = new Employee(userId, full_name, email_user, password_user, pro_skill);
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, resultSet);
        }
        return user;
    }

    @Override
    public void insertEmplyee(Employee employee) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO `crud_vti_employee`.`user` (`full_name`, `email`,`password`, `pro_skill`, `role`)" +
                         " VALUES (?,?, 123456, ?, 'employee');\n";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getFullName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getProSkill());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement);
        }

    }
}
