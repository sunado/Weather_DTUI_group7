package com.example.admin.weather_dtui_group7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final TextView textView1 = (TextView) findViewById(R.id.text);
        final TextView textView2 = (TextView)findViewById(R.id.text1);
        Thread timer = new Thread() {
            public void run() {
                try {
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                    textView1.startAnimation(animation);
                    textView2.startAnimation(animation);
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent(Splash.this, MainActivity.class);
                    startActivity(i);
                }
            }
        };
        timer.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
