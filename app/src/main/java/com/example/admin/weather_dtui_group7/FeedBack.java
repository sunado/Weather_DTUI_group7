package com.example.admin.weather_dtui_group7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

public class FeedBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        EditText edt1,edt2;
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_feedback);
        edt1 = (EditText)findViewById(R.id.problem);
        edt2 = (EditText)findViewById(R.id.location);
        edt1.setTextSize(12);
        edt2.setTextSize(12);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
