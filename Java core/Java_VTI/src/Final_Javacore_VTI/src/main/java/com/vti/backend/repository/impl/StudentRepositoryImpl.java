package com.vti.backend.repository.impl;

import com.vti.backend.entity.Major;
import com.vti.backend.entity.Student;
import com.vti.backend.repository.StudentRepository;
import com.vti.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        // Sửa câu lệnh SQL để JOIN với bảng Major
        String sql = "SELECT st.*, mj.major_name " +
                        "FROM `Student` st " +
                        "LEFT JOIN `Major` mj ON st.major_id = mj.major_id";

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                LocalDate dateOfBirth = rs.getObject("date_of_birth", LocalDate.class);
                int majorId = rs.getInt("major_id");
                String majorName = rs.getString("major_name"); // Lấy tên từ bảng Major

                // Khởi tạo Major với cả ID và Tên
                Major major = new Major(majorId, majorName);
                Student student = new Student(studentId, fullName, email, dateOfBirth, major);
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public boolean inertStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean ketqua = false;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO `Student` (`full_name`, `email`, `date_of_birth`, `major_id`) " +
                         "VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setObject(3, student.getDateOfBirth());
            preparedStatement.setInt(4, student.getMajorId().getMajor_id());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement);

        }
        return ketqua;
    }


    @Override
    public boolean updateStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean ketqua = false;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "UPDATE `Student` SET `major_id` = ? WHERE `student_id` = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, student.getMajorId());
            preparedStatement.setInt(2, student.getStudentId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement);

        }
        return ketqua;
    }

    @Override
    public Student findById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Student student=null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from `Student` where student_id=? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                LocalDate dateOfBirth = rs.getObject("date_of_birth", LocalDate.class);
                int majorId = rs.getInt("major_id");
                Major major = new Major(majorId);
                student = new Student(studentId, fullName, email, dateOfBirth, major);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, rs);
        }
        return student;
    }

    @Override
    public boolean deleteStudent(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean ketqua = false;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "DELETE FROM `student_management`.`Student` WHERE (`student_id` = ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ketqua = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement);

        }
        return ketqua;
    }

    @Override
    public List<Student> findByMajor(String major_name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Student> studentList = new ArrayList<>();

        try {
            connection = JDBCUtils.getConnection();
            String sql = "select st.*, mj.major_name " +
                        "from `Student` as st " +
                        "inner join `Major` as mj " +
                        "on st.major_id = mj.major_id " +
                        "where mj.major_name = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,major_name);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                LocalDate dateOfBirth = rs.getObject("date_of_birth", LocalDate.class);
                int majorId = rs.getInt("major_id");
                String majorName = rs.getString("major_name");
                Major major = new Major(majorId, majorName);
                Student student = new Student(studentId, fullName, email, dateOfBirth, major);
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, rs);

        }
        return studentList;
    }

    @Override
    public boolean checkEmailExist(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean ketqua = false;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from `Student` WHERE `email` = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ketqua = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, rs);

        }
        return ketqua;
    }
}
