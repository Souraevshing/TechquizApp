package com.techquiz.app.pojo;

public class Performance {
    private String examId;
    private String language;
    private String userId;
    private int right;
    private int wrong;
    private int unAttempted;
    private double percentage;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getUnAttempted() {
        return unAttempted;
    }

    public void setUnAttempted(int unAttempted) {
        this.unAttempted = unAttempted;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Performance() {
    }

    public Performance(String userId, String examId, int right, int wrong, int unAttempted, double percentage, String language) {
        this.examId = examId;
        this.language = language;
        this.userId = userId;
        this.right = right;
        this.wrong = wrong;
        this.unAttempted = unAttempted;
        this.percentage = percentage;
    }
}
