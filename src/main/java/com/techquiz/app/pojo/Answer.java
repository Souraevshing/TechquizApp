package com.techquiz.app.pojo;

import java.util.Objects;

public class Answer {
    private String examId;
    private String subject;
    private int questionNumber;
    private String chosenAnswer;
    private String correctAnswer;

    public Answer(String examId, String subject, int questionNumber, String chosenAnswer, String correctAnswer) {
        this.examId = examId;
        this.subject = subject;
        this.questionNumber = questionNumber;
        this.chosenAnswer = chosenAnswer;
        this.correctAnswer = correctAnswer;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.examId);
        hash = 37 * hash + Objects.hashCode(this.subject);
        hash = 37 * hash + this.questionNumber;
        hash = 37 * hash + Objects.hashCode(this.chosenAnswer);
        hash = 37 * hash + Objects.hashCode(this.correctAnswer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "examId='" + examId + '\'' +
                ", subject='" + subject + '\'' +
                ", questionNumber=" + questionNumber +
                ", chosenAnswer='" + chosenAnswer + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
