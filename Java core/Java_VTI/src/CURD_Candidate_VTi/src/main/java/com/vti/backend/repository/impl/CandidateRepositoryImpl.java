package com.vti.backend.repository.impl;

import com.vti.backend.repository.CandidateRepository;
import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;
import com.vti.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CandidateRepositoryImpl implements CandidateRepository {
    @Override
    public void saveExperienceCandidate(ExperienceCandidate experienceCandidate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            // Câu lệnh SQL chèn vào 1 bảng duy nhất
            String sql = "INSERT INTO `thithu_vti_candidate`.`candidate` " +
                    "(`firstname`, `lastname`, `phone`, `email`, `password`, `role`, `exp_in_year`, `pro_skill`) " +
                    "VALUES (?, ?, ?, ?, ?, 'EXPERIENCECANDIDATE', ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, experienceCandidate.getFirstName());
            preparedStatement.setString(2, experienceCandidate.getLastName());
            preparedStatement.setString(3, experienceCandidate.getPhone());
            preparedStatement.setString(4, experienceCandidate.getEmail());
            preparedStatement.setString(5, experienceCandidate.getPassword());
            preparedStatement.setInt(6, experienceCandidate.getExpInYear());
            preparedStatement.setString(7, experienceCandidate.getProSkill());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement);
        }
    }

    public void saveFresherCandidate(FresherCandidate fresherCandidate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();

            // 1. Sửa lại câu SQL: đổi 'EXPERIENCECANDIDATE' thành 'FRESHERCANDIDATE'
            // và đổi 2 cột kinh nghiệm thành cột `graduation_rank`
            String sql = "INSERT INTO `thithu_vti_candidate`.`candidate` " +
                    "(`firstname`, `lastname`, `phone`, `email`, `password`, `role`, `graduation_rank`) " +
                    "VALUES (?, ?, ?, ?, ?, 'FRESHERCANDIDATE', ?);";

            preparedStatement = connection.prepareStatement(sql);

            // 2. Truyền dữ liệu chung từ đối tượng fresherCandidate
            preparedStatement.setString(1, fresherCandidate.getFirstName());
            preparedStatement.setString(2, fresherCandidate.getLastName());
            preparedStatement.setString(3, fresherCandidate.getPhone());
            preparedStatement.setString(4, fresherCandidate.getEmail());
            preparedStatement.setString(5, fresherCandidate.getPassword());

            // 3. Truyền thuộc tính riêng: Ép kiểu Enum GraduationRank về dạng String để lưu vào DB
            preparedStatement.setString(6, fresherCandidate.getGraduationRank().toString());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement);
        }
    }

    @Override
    public boolean loginCandidate(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT * FROM Candidate WHERE email = ? AND password = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true; // Đăng nhập thành công
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, resultSet);
        }

    }
}
