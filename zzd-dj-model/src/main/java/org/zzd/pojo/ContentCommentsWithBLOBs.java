package org.zzd.pojo;

public class ContentCommentsWithBLOBs extends ContentComments {
    private String commentFilter;

    private String comment;

    public String getCommentFilter() {
        return commentFilter;
    }

    public void setCommentFilter(String commentFilter) {
        this.commentFilter = commentFilter == null ? null : commentFilter.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}