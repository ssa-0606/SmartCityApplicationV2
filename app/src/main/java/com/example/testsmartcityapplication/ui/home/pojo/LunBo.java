package com.example.testsmartcityapplication.ui.home.pojo;

public class LunBo {
    private int id;
    private int sort;
    private String advImg;
    private int targetId;
    private String type;

    public LunBo(int id, int sort, String advImg, int targetId, String type) {
        this.id = id;
        this.sort = sort;
        this.advImg = advImg;
        this.targetId = targetId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getAdvImg() {
        return advImg;
    }

    public void setAdvImg(String advImg) {
        this.advImg = advImg;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LunBo{" +
                "id=" + id +
                ", sort=" + sort +
                ", advImg='" + advImg + '\'' +
                ", targetId=" + targetId +
                ", type='" + type + '\'' +
                '}';
    }
}
