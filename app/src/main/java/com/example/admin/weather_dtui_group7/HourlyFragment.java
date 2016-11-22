package com.example.admin.weather_dtui_group7;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

/**
 * Created by phong on 11/16/16.
 */
public class HourlyFragment extends Fragment {
    LineChart lineChart;
    ListView listView;
    ArrayList<ItemHourly> listitem = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hourly_layout, container, false);
        setLineGraph(view);
        setListView(view);
        return view;
    }
    public void setLineGraph(View view){
        lineChart = (LineChart) view.findViewById(R.id.linechart);
        setData();


        Legend l = lineChart.getLegend();


        l.setForm(Legend.LegendForm.LINE);
    }
    private ArrayList<String> setXAxisValues(){
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("22:00");
        xVals.add("23:00");
        xVals.add("0:00");
        xVals.add("1:00");
        xVals.add("2:00");

        return xVals;
    }
    private ArrayList<Entry> setYAxisValues(){
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        yVals.add(new Entry(26, 0));
        yVals.add(new Entry(25, 1));
        yVals.add(new Entry(24, 2));
        yVals.add(new Entry(27, 3));
        yVals.add(new Entry(29, 4));

        return yVals;
    }
    private void setData() {
        ArrayList<String> xVals = setXAxisValues();

        ArrayList<Entry> yVals = setYAxisValues();

        LineDataSet set1;


        set1 = new LineDataSet(yVals, "Nhiệt độ theo giờ (°C)");
        set1.setFillAlpha(110);




        set1.setColor(Color.parseColor("#f44336"));
        set1.setCircleColor(Color.RED);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(9f);
        set1.setDrawFilled(true);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1);
        LineData data = new LineData(xVals, dataSets);
        lineChart.setDescription("");
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.setData(data);
        lineChart.animateX(1000);
        lineChart.animateY(1000);
    }
    public void setListView(View view){
        listView = (ListView)view.findViewById(R.id.listview_hour);
        listitem.add(new ItemHourly("22:00",R.drawable.status_cloud_sun,"mưa rào nhẹ","26\u00b0"));
        listitem.add(new ItemHourly("22:00",R.drawable.status_cloud_sun,"mưa rào nhẹ","26\u00b0"));
        listitem.add(new ItemHourly("22:00",R.drawable.status_cloud_sun,"mưa rào nhẹ","26\u00b0"));
        listitem.add(new ItemHourly("22:00",R.drawable.status_cloud_sun,"mưa rào nhẹ","26\u00b0"));
        listitem.add(new ItemHourly("22:00",R.drawable.status_cloud_sun,"mưa rào nhẹ","26\u00b0"));

        ItemHourlyAdapter adapter =new ItemHourlyAdapter(view.getContext(),listitem);

        listView.setAdapter(adapter);
    }
}
