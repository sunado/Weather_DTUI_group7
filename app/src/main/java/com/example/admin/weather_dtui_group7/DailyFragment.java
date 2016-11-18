package com.example.admin.weather_dtui_group7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BarChart barChart = (BarChart) getActivity().findViewById(R.id.chart);

        //khoi tao

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("29/11");
        labels.add("30/11");
        labels.add("01/12");
        labels.add("02/12");
        labels.add("03/12");
        labels.add("04/12");

        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(27f, 0));
        group1.add(new BarEntry(28f, 1));
        group1.add(new BarEntry(29f, 2));
        group1.add(new BarEntry(30f, 3));
        group1.add(new BarEntry(26f, 4));
        group1.add(new BarEntry(32f, 5));

        ArrayList<BarEntry> group2 = new ArrayList<>();
        group2.add(new BarEntry(24f, 0));
        group2.add(new BarEntry(20f, 1));
        group2.add(new BarEntry(26f, 2));
        group2.add(new BarEntry(21f, 3));
        group2.add(new BarEntry(24f, 4));
        group2.add(new BarEntry(25f, 5));

        BarDataSet barDataSet1 = new BarDataSet(group1, "Group 1");

        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet2 = new BarDataSet(group2, "Group 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        List<IBarDataSet> dataset = new ArrayList<>();
        dataset.add(barDataSet1);
        dataset.add(barDataSet2);

        BarData data = new BarData(labels,dataset);
        System.out.println(data);
        barChart.setData(data);
        barChart.animateY(5000);
        barChart.invalidate();
        return inflater.inflate(R.layout.daily_layout,null);
    }
}
