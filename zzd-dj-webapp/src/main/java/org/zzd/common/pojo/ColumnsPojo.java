package org.zzd.common.pojo;

public class ColumnsPojo {
	
	private String field;
	private String title;
	private int width = 100;
	private String align = "center";
	private boolean hidden = false;
	private boolean sortable = true;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "{field:'" + field + "', title:'" + title + "', width:" + width + ", align:'" + align
				+ "', hidden:" + hidden + ", sortable:" + sortable+"}";
	}
	public ColumnsPojo() {
		super();
	}
	public ColumnsPojo(String field, String title) {
		super();
		this.field = field;
		this.title = title;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public boolean getHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public boolean isSortable() {
		return sortable;
	}
	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}
	
	
	
}
