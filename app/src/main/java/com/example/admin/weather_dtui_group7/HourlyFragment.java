package com.example.admin.weather_dtui_group7;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

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
        listitem.add(new ItemHourly("22:00",R.drawable.status5,"Mưa giông lớn","26\u00b0C"));
        listitem.add(new ItemHourly("23:00",R.drawable.status2,"Mưa rào nhẹ","24\u00b0C"));
        listitem.add(new ItemHourly("0:00",R.drawable.status1,"Nắng nhẹ","30\u00b0C"));
        listitem.add(new ItemHourly("1:00",R.drawable.status3,"Nắng gay gắt","33\u00b0C"));
        listitem.add(new ItemHourly("2:00",R.drawable.status6,"Nhiều mây","28\u00b0C"));
        setLineGraph(view);
        setListView(view);
        return view;
    }
    public void setLineGraph(View view){
        lineChart = (LineChart) view.findViewById(R.id.linechart);
        setData();


        Legend l = lineChart.getLegend();


        l.setForm(Legend.LegendForm.LINE);
        l.setTextColor(Color.WHITE);
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




        set1.setColor(Color.WHITE);
        set1.setCircleColor(Color.WHITE);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(12f);
//        set1.setDrawFilled(true);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1);
        LineData data = new LineData(xVals, dataSets);
        lineChart.setDescription("");
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getXAxis().setTextColor(Color.WHITE);
        lineChart.getXAxis().setAxisLineColor(Color.WHITE);
        lineChart.getAxisLeft().setEnabled(false);
        lineChart.setData(data);
        lineChart.getLineData().setValueTextColor(Color.WHITE);
        lineChart.animateX(4000);
        lineChart.getLineData().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return String.valueOf((int) Math.floor(value))+"°";
            }
        });
        lineChart.setTouchEnabled(false);
    }
    public void setListView(View view){
        listView = (ListView)view.findViewById(R.id.listview_hour);
        ItemHourlyAdapter adapter =new ItemHourlyAdapter(view.getContext(),listitem);
        listView.setAdapter(adapter);

    }
}
