package org.zzd.pojo;

import java.util.Date;

public class Question {
    private Long id;

    private Long testId;

    private Long number;

    private String question;

    private String answer;

    private Integer type;

    private Integer enabled;

    private Long manager;

    private Date manegerTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

    public Date getManegerTime() {
        return manegerTime;
    }

    public void setManegerTime(Date manegerTime) {
        this.manegerTime = manegerTime;
    }
}