package org.zzd.pojo;

import java.util.Date;

public class MemberTest extends MemberTestKey {
    private Date timeCost;

    private Integer score;

    private Integer state;

    public Date getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(Date timeCost) {
        this.timeCost = timeCost;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}