package com.vvn.vocavocani.group;

/**
 * Created by soo13 on 2017-08-06.
 */

public class GroupBoardItem {
    private int boardId;
    private String boardTitle;
    private int boardWriterId;
    private String boardWriterName;
    private String boardWriterPhoto;
    private String timestamp;
    private String content;
    private int boardType;
    private int replyCount;

    public GroupBoardItem(int boardId, String boardTitle, int boardWriterId,
                          String boardWriterName, String boardWriterPhoto,
                          String timestamp, String content, int replyCount) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.boardWriterId = boardWriterId;
        this.boardWriterName = boardWriterName;
        this.boardWriterPhoto = boardWriterPhoto;
        this.timestamp = timestamp;
        this.content = content;
        this.replyCount = replyCount;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public int getBoardWriterId() {
        return boardWriterId;
    }

    public void setBoardWriterId(int boardWriterId) {
        this.boardWriterId = boardWriterId;
    }

    public String getBoardWriterName() {
        return boardWriterName;
    }

    public void setBoardWriterName(String boardWriterName) {
        this.boardWriterName = boardWriterName;
    }

    public String getBoardWriterPhoto() {
        return boardWriterPhoto;
    }

    public void setBoardWriterPhoto(String boardWriterPhoto) {
        this.boardWriterPhoto = boardWriterPhoto;
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

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }
}
