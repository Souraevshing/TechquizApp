package com.techquiz.app.dao;

import com.techquiz.app.config.DBConnection;
import com.techquiz.app.pojo.Exam;

import java.sql.*;
import java.util.ArrayList;

public class ExamDAO {
    public static String getExamId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(*) from exam");
        resultSet.next();
        int record = resultSet.getInt(1);
        String examId = "EX - "+ (record + 1);
        return examId;
    }

    public static boolean addExam(Exam exam) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into exam values (?,?,?)");
        ps.setString(1, exam.getExamId());
        ps.setString(2, exam.getLanguage());
        ps.setInt(3, exam.getTotalQuestions());
        int ans = ps.executeUpdate();
        return ans == 1;
    }

    public static ArrayList<String> getExamIdBySubject (String Subject) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select  examid from exam where language=?");
        ps.setString(1, Subject);
        ResultSet resultSet = ps.executeQuery();
        ArrayList<String> examIdList = new ArrayList<>();
        while (resultSet.next()){
            examIdList.add(resultSet.getString(1));
        }
        return examIdList;
    }

    public static int getQuestionCountBySubject (String examId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select  total_question from exam where examid=?");
        ps.setString(1, examId);
        ResultSet resultSet = ps.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static ArrayList<String> getAllExamLanguage () throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select language from exam");
        ResultSet resultSet = ps.executeQuery();
        ArrayList<String> languageList = new ArrayList<>();
        while (resultSet.next()){
            String language = resultSet.getString(1);
            if (!languageList.contains(language)){
                languageList.add(language);
            }
        }
        return languageList;
    }

    public static boolean isPaperSet (String subject) throws SQLException{
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select examid from exam where language=?");
        preparedStatement.setString(1,subject);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }


    public static  ArrayList<String> getExamIdsBySubject(String userId, String subject) throws SQLException{
        //String query = "Select examid from exam where language=? minus select examid from performance where userid=?";
        String query = "Select examid from exam where language=?  AND examid NOT IN (select examid from performance where userid=?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, subject);
        ps.setString(2,userId);
        ResultSet resultSet = ps.executeQuery();
        ArrayList<String> examIdList = new ArrayList<>();
        while (resultSet.next()){
            examIdList.add(resultSet.getString(1));
        }
        return examIdList;
    }
}
