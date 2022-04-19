package com.example.testsmartcityapplication.ui.home.pojo;

import com.google.gson.annotations.Expose;

import java.util.List;

public class NewsCategory {
    private int id;
    private String name;
    private int sort;

    private List<NewsItem> newsItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<NewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    public NewsCategory(int id, String name, int sort, List<NewsItem> newsItems) {
        this.id = id;
        this.name = name;
        this.sort = sort;
        this.newsItems = newsItems;
    }
}
