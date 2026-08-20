package com.techquiz.app.dao;

import com.techquiz.app.config.DBConnection;
import com.techquiz.app.pojo.Question;
import com.techquiz.app.pojo.QuestionStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionsDAO {
    public static void addQuestions(QuestionStore qstore) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
        ArrayList<Question> questionList = qstore.getAllQuestions();
        for (Question q : questionList){
            ps.setString(1, q.getExamID());
            ps.setInt(2, q.getQno());
            ps.setString(3, q.getQuestion());
            ps.setString(4, q.getAnswer1());
            ps.setString(5, q.getAnswer2());
            ps.setString(6, q.getAnswer3());
            ps.setString(7, q.getAnswer4());
            ps.setString(8, q.getCorrectAnswer());
            ps.setString(9,q.getLanguage());
            ps.executeUpdate();

        }
    }

    public static ArrayList<Question> getQuestionsByExamId (String examId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from questions where examid=?");
        ps.setString(1, examId);
        ResultSet resultSet = ps.executeQuery();
        ArrayList<Question> questionList = new ArrayList<>();
        while (resultSet.next()){
            int questionNum = resultSet.getInt(2);
            String question = resultSet.getString("question");
            String option1 = resultSet.getString("answer1");
            String option2 = resultSet.getString("answer2");
            String option3 = resultSet.getString("answer3");
            String option4 = resultSet.getString("answer4");
            String correctAnswer = resultSet.getString("correct_answer");
            String language = resultSet.getString("language");
            Question obj = new Question(examId,questionNum,language,option1,option2,option3,option4,correctAnswer,question);
            questionList.add(obj);
        }
        return questionList;
    }

    public static boolean updateQuestions(QuestionStore questionStore) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement preparedStatement;
        Question question;
        int i = 0;
        while (questionStore.getCount() > i){
            question = questionStore.getQuestion(i);
            preparedStatement = conn.prepareStatement("update questions set question=?, answer1=?, answer2=?, answer3=?, answer4=?, correct_answer=? where examid=? and qno=?");
            preparedStatement.setString(1,question.getQuestion());
            preparedStatement.setString(2,question.getAnswer1());
            preparedStatement.setString(3, question.getAnswer2());
            preparedStatement.setString(4, question.getAnswer3());
            preparedStatement.setString(5, question.getAnswer4());
            preparedStatement.setString(6,question.getCorrectAnswer());
            preparedStatement.setString(7,question.getExamID());
            preparedStatement.setInt(8,question.getQno());
            preparedStatement.executeUpdate();
            i += 1;
        }
        if (i == questionStore.getCount()){
            return true;
        }
        else {
            return false;
        }
    }
}
