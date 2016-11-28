package com.example.admin.weather_dtui_group7;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifTextView;

public class AddLocation extends AppCompatActivity {
    String[] location = new String[]{"Hà Nội,Hà Nội,(VN)","New York, (US)","San Francisco,California,(US)",
            "Hải Phòng, Việt Nam","Tokyo, (JP)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_add);
        ListView listView = (ListView)findViewById(R.id.list_location);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,location){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                textView.setTextSize(12);
                return view;
            }
        };
        listView.setAdapter(adapter);

        AutoCompleteTextView text =(AutoCompleteTextView)findViewById(R.id.auto);
        ArrayAdapter adapter_auto = new
                ArrayAdapter(this,android.R.layout.simple_list_item_1,location){
                    @NonNull
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view =super.getView(position, convertView, parent);

                        TextView textView=(TextView) view.findViewById(android.R.id.text1);
                        textView.setTextSize(12);
                        return view;
                    }
                };

        text.setAdapter(adapter_auto);
        text.setThreshold(1);
        text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        AddLocation.this.finish();
                        break;
                    case 1:
                        AddLocation.this.finish();
                        break;
                }
            }
        });
    }
}
