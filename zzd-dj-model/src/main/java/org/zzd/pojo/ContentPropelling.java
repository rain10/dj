package org.zzd.pojo;

import java.util.Date;

public class ContentPropelling extends ContentPropellingKey {
    private Integer ing;

    private Date propellingTime;

    private Date acceptTime;

    public Integer getIng() {
        return ing;
    }

    public void setIng(Integer ing) {
        this.ing = ing;
    }

    public Date getPropellingTime() {
        return propellingTime;
    }

    public void setPropellingTime(Date propellingTime) {
        this.propellingTime = propellingTime;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }
}