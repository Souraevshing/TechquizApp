package com.techquiz.app.pojo;

import java.util.Objects;

public class Question {
    private String examID;
    private int qno;
    private String language;
    private String answer1, answer2, answer3, answer4;
    private String correctAnswer;
    private String question;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.examID);
        hash = 17 * hash + this.qno;
        hash = 17 * hash + Objects.hashCode(this.language);
        hash = 17 * hash + Objects.hashCode(this.answer1);
        hash = 17 * hash + Objects.hashCode(this.answer2);
        hash = 17 * hash + Objects.hashCode(this.answer3);
        hash = 17 * hash + Objects.hashCode(this.answer4);
        hash = 17 * hash + Objects.hashCode(this.correctAnswer);
        hash = 17 * hash + Objects.hashCode(this.question);
        return hash;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Question(String examID, int qno, String language, String answer1, String answer2, String answer3, String answer4, String correctAnswer, String question) {
        this.examID = examID;
        this.qno = qno;
        this.language = language;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.question = question;
    }
}
