package com.example.admin.weather_dtui_group7;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import pl.droidsonroids.gif.GifTextView;

/**
 * Created by phong on 11/16/16.
 */
public class NowFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.now_layout,null);
        final SwipeRefreshLayout refreshLayout =(SwipeRefreshLayout) v.findViewById(R.id.activity_main_swipe_refresh_layout);
        final DrawerLayout drawerLayout= (DrawerLayout) getActivity().findViewById(R.id.drawerLayout);
        drawerLayout.setBackground(getResources().getDrawable(R.drawable.bg2));

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                final Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 500ms
                        drawerLayout.setBackgroundResource(BackgroundRes.getNext());
                        refreshLayout.setRefreshing(false);
                    }
                }, 500);

            }
        });
        return v;
    }
}
