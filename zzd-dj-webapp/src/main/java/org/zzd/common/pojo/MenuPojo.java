package org.zzd.common.pojo;

import java.util.List;

public class MenuPojo {
	private Long id;

    private String author;

    private String enabled;

    private String icon;

    private String name;

    private Long pid;

    private Integer sort;

    private String target;

    private String title;

    private String type;

    private Short authorization;

    private Short havemune;

    private List children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Short getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Short authorization) {
		this.authorization = authorization;
	}

	public Short getHavemune() {
		return havemune;
	}

	public void setHavemune(Short havemune) {
		this.havemune = havemune;
	}

	public List getChildren() {
		return children;
	}

	public void setChildren(List children) {
		this.children = children;
	}

	
    
}
