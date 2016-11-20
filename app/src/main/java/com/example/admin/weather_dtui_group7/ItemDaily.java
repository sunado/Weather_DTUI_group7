package com.example.admin.weather_dtui_group7;

/**
 * Created by phong on 11/19/16.
 */

public class ItemDaily {
    public int iconWeather;
    public String date_number;
    public String date_string;
    public String status;
    public String degree;
    public int iconNext;

    public ItemDaily(int iconWeather,String date_number,String date_string,String status, String degree,int iconNext) {
        this.iconWeather=iconWeather;
        this.date_number=date_number;
        this.date_string=date_string;
        this.status=status;
        this.degree=degree;
        this.iconNext=iconNext;
    }

    public int getIconWeather() {
        return iconWeather;
    }

    public String getDate_number() {
        return date_number;
    }

    public String getDate_string() {
        return date_string;
    }

    public String getStatus() {
        return status;
    }

    public String getDegree() {
        return degree;
    }

    public int getIconNext() {
        return iconNext;
    }

    public void setIconWeather(int iconWeather) {
        this.iconWeather = iconWeather;
    }

    public void setDate_number(String date_number) {
        this.date_number = date_number;
    }

    public void setDate_string(String date_string) {
        this.date_string = date_string;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setIconNext(int iconNext) {
        this.iconNext = iconNext;
    }
}
