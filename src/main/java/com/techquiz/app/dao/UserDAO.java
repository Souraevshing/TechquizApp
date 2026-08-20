package com.techquiz.app.dao;

import com.techquiz.app.config.DBConnection;
import com.techquiz.app.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static boolean validateUser(User user) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet resultSet = ps.executeQuery();
        return resultSet.next();
    }

    public static boolean updatePassword(String userId, String password) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update users set password=? where userid=?");
        preparedStatement.setString(1,password);
        preparedStatement.setString(2,userId);
        int result = preparedStatement.executeUpdate();
        if (result > 0){
            return true;
        }
        return false;
    }

    public static boolean addUsers(User user) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into users values(?,?,?)");
        preparedStatement.setString(1, user.getUserId());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getUserType());
        int result = preparedStatement.executeUpdate();
        if (result > 0){
            return true;
        }
        return false;
    }
}
