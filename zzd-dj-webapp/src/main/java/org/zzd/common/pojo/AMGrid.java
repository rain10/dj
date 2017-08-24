package org.zzd.common.pojo;

import java.util.Arrays;

public class AMGrid {
	
	private String url;
	private boolean pagination = true;
	private boolean fit = true;
	private boolean border = false;
	private boolean nowrap = true;
	private boolean rownumbers = true;
	private boolean fitColumns = true;
	private boolean singleSelect = true;
	private boolean collapsible = true;
	private int[] pageList = { 10, 20, 30, 40, 50,200,1000};
	private String columns;
	
	
	
	public String getColumns() {
		return columns;
	}
	public void setColumns(String columns) {
		this.columns = columns;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		url = "'"+url+"'";
		this.url = url;
	}
	public boolean isPagination() {
		return pagination;
	}
	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}
	@Override
	public String toString() {
		return "url:" + url + ", pagination:" + pagination + ", fit:" + fit + ", border:" + border + ", nowrap:"
				+ nowrap + ", rownumbers:" + rownumbers + ", fitColumns:" + fitColumns + ", singleSelect:"
				+ singleSelect + ", collapsible:" + collapsible + ", pageList:" + Arrays.toString(pageList)
				+ ", columns:[" + columns + "]";
	}
	public boolean isFit() {
		return fit;
	}
	public void setFit(boolean fit) {
		this.fit = fit;
	}
	public boolean isBorder() {
		return border;
	}
	public void setBorder(boolean border) {
		this.border = border;
	}
	public boolean isNowrap() {
		return nowrap;
	}
	public void setNowrap(boolean nowrap) {
		this.nowrap = nowrap;
	}
	public boolean isRownumbers() {
		return rownumbers;
	}
	public void setRownumbers(boolean rownumbers) {
		this.rownumbers = rownumbers;
	}
	public boolean isFitColumns() {
		return fitColumns;
	}
	public void setFitColumns(boolean fitColumns) {
		this.fitColumns = fitColumns;
	}
	public boolean isSingleSelect() {
		return singleSelect;
	}
	public void setSingleSelect(boolean singleSelect) {
		this.singleSelect = singleSelect;
	}
	public boolean isCollapsible() {
		return collapsible;
	}
	public void setCollapsible(boolean collapsible) {
		this.collapsible = collapsible;
	}
	public int[] getPageList() {
		return pageList;
	}
	public void setPageList(int[] pageList) {
		this.pageList = pageList;
	}
	
	
	
	
}
