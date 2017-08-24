package org.zzd.common.pojo;

import java.util.Date;

public class RoleResult {
	
	    private Long id;

	    private String description;

	    private Short enabled;

	    private String name;

	    private Date opTime;

	    private String operator;

	    private Integer sort;

	    private Long orgid;
	    
	    private String checked="";
	    

	    public String getChecked() {
			return checked;
		}

		public void setChecked(String checked) {
			this.checked = checked;
		}

		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }

	    public Short getEnabled() {
	        return enabled;
	    }

	    public void setEnabled(Short enabled) {
	        this.enabled = enabled;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name == null ? null : name.trim();
	    }

	    public Date getOpTime() {
	        return opTime;
	    }

	    public void setOpTime(Date opTime) {
	        this.opTime = opTime;
	    }

	    public String getOperator() {
	        return operator;
	    }

	    public void setOperator(String operator) {
	        this.operator = operator == null ? null : operator.trim();
	    }

	    public Integer getSort() {
	        return sort;
	    }

	    public void setSort(Integer sort) {
	        this.sort = sort;
	    }

	    public Long getOrgid() {
	        return orgid;
	    }

	    public void setOrgid(Long orgid) {
	        this.orgid = orgid;
	    }
	}

