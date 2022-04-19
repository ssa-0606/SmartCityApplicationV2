package com.example.testsmartcityapplication.ui.home.pojo;

public class NewsItem {
    private int id;
    private String cover;
    private String title;
    private String content;
    private String publishDate;
    private int likeNum;
    private int commentNum;
    private int readNum;
    private String hot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public NewsItem(int id, String cover, String title, String content, String publishDate, int likeNum, int commentNum, int readNum, String hot) {
        this.id = id;
        this.cover = cover;
        this.title = title;
        this.content = content;
        this.publishDate = publishDate;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
        this.readNum = readNum;
        this.hot = hot;
    }
}
