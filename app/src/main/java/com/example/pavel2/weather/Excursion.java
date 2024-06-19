package com.example.pavel2.weather;

import android.content.Intent;

public class Excursion {
    private int id;
    private String type;
    private String title;
    private String url;
    private int visitors;


    @Override
    public String toString() {
        return "Excursion{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", visitors=" + visitors +
                ", tours_count=" + tours_count +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    private int tours_count;
    private String cityName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public int getTours_count() {
        return tours_count;
    }

    public void setTours_count(int tours_count) {
        this.tours_count = tours_count;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
