package com.example.admin.weather_dtui_group7;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phong on 11/16/16.
 */
public class DailyFragment extends Fragment {
    ListView listView;
    ArrayList<ItemDaily> listitem = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.daily_layout, container, false);
        BarChart barChart = (BarChart) view.findViewById(R.id.chart);



        setChart(barChart);
        setlistview(view);
        return view;
    }
    public void setChart(BarChart barChart){
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("29/11");
        labels.add("30/11");
        labels.add("01/12");
        labels.add("02/12");
        labels.add("03/12");
        labels.add("04/12");

        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(27, 0));
        group1.add(new BarEntry(25, 1));
        group1.add(new BarEntry(29, 2));
        group1.add(new BarEntry(30, 3));
        group1.add(new BarEntry(26, 4));
        group1.add(new BarEntry(32, 5));

        ArrayList<BarEntry> group2 = new ArrayList<>();
        group2.add(new BarEntry(24, 0));
        group2.add(new BarEntry(20, 1));
        group2.add(new BarEntry(26, 2));
        group2.add(new BarEntry(29, 3));
        group2.add(new BarEntry(24, 4));
        group2.add(new BarEntry(25, 5));

        BarDataSet barDataSet1 = new BarDataSet(group1, "Nhiệt độ cao nhất");

        barDataSet1.setColor(Color.rgb(104, 241, 175));

        BarDataSet barDataSet2 = new BarDataSet(group2, "Nhiệt độ thấp nhất");
        barDataSet2.setColor(Color.rgb(164, 228, 251));

        ArrayList<IBarDataSet> dataset = new ArrayList<>();
        dataset.add(barDataSet1);
        dataset.add(barDataSet2);

        BarData data = new BarData(labels,dataset);
        barChart.setData(data);
        barChart.animateY(1000);
        barChart.getAxisRight().setEnabled(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.setDescription("");
        barChart.invalidate();
        barChart.getXAxis().setTextColor(Color.WHITE);
        barChart.getAxisLeft().setTextColor(Color.WHITE);
        //barChart.getAxis().setTextColor(Color.WHITE);
    }
    public void setlistview(View view){
        listView = (ListView) view.findViewById(R.id.listview);

        listitem.add(new ItemDaily(R.drawable.status1,"29/11","WED","Trời nắng và hanh khô","27\u00b0/24\u00b0",R.drawable.rightarrow));
        listitem.add(new ItemDaily(R.drawable.status2,"30/11","THU","Trời mưa và ẩm ướt","25°/20°",R.drawable.rightarrow));
        listitem.add(new ItemDaily(R.drawable.status5,"01/12","FRI","Trời có dông","29°/26°",R.drawable.rightarrow));
        listitem.add(new ItemDaily(R.drawable.status3,"02/12","SAT","Trời nắng","30°/29°",R.drawable.rightarrow));
        listitem.add(new ItemDaily(R.drawable.status4,"03/12","SUN","Trời nắng và có mây","26°/24°",R.drawable.rightarrow));
        listitem.add(new ItemDaily(R.drawable.status6,"04/12","MON","Trời có mây","32°/25°",R.drawable.rightarrow));

        ItemDailyAdapter adapter =new ItemDailyAdapter(view.getContext(),listitem);

        listView.setAdapter(adapter);
    }
}
