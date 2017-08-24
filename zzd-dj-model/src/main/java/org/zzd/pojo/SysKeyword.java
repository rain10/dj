package org.zzd.pojo;

import java.io.Serializable;

public class SysKeyword implements Serializable{
    private Long id;

    private String keyword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
}