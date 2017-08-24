package org.zzd.pojo;

public class ExaminationAnswer {
    private Long id;

    private Long questionId;

    private String option;

    private String content;

    private Integer enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option == null ? null : option.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}