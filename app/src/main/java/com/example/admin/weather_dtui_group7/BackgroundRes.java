package com.example.admin.weather_dtui_group7;

/**
 * Created by sunado on 11/23/2016.
 */

public class BackgroundRes {
    private static int imgList[]={R.drawable.bg1,R.drawable.bg2,R.drawable.bg3,R.drawable.bg4};
    private static int count=1;
    public static int getNext(){
        count=(count+1)%imgList.length;
        return imgList[count];
    }
    public static int getCurrent(){
        return imgList[count];
    }
}
