package com.example.admin.weather_dtui_group7;

/**
 * Created by phong on 11/21/16.
 */

public class ItemHourly {
    public String hour;
    public int image;
    public String status;
    public String degree;
    public ItemHourly(String hour,int image,String status,String degree){
        this.hour = hour;
        this.image = image;
        this.status = status;
        this.degree = degree;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
