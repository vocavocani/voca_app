package com.vvn.vocavocani.group;

/**
 * Created by soo13 on 2017-09-01.
 */

public class GroupBoardComment {

    private int commentId;
    private String writer;
    private int writerId;
    private String wirterPhoto;
    private String timestamp;
    private String content;

    public GroupBoardComment(int commentId, String writer, int writerId,
                             String writerPhoto, String timestamp, String content) {
        this.commentId = commentId;
        this.writer = writer;
        this.writerId = writerId;
        this.wirterPhoto = writerPhoto;
        this.timestamp = timestamp;
        this.content = content;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWirterPhoto() {
        return wirterPhoto;
    }

    public void setWirterPhoto(String wirterPhoto) {
        this.wirterPhoto = wirterPhoto;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
