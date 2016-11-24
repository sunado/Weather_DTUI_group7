package com.example.admin.weather_dtui_group7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by phong on 11/22/16.
 */

public class ItemHourlyAdapter extends BaseAdapter {
    class ViewHolder {
        ImageView image;
        TextView hour;
        TextView status;
        TextView degree;

    }
    boolean[] animationStates;
    public ArrayList<ItemHourly> listHourly;
    LayoutInflater inflater = null;
    private Context mContext;
    public ItemHourlyAdapter(Context context, ArrayList<ItemHourly> item){
        inflater =LayoutInflater.from(context);
        mContext = context;
        this.listHourly = item;
    }
    @Override
    public int getCount() {
        return listHourly.size();
    }

    @Override
    public Object getItem(int position) {
        return listHourly.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        animationStates = new boolean[getCount()];
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_hourly,null);
            holder = new ItemHourlyAdapter.ViewHolder();
            holder.degree = (TextView) convertView.findViewById(R.id.degree_hourly);
            holder.hour = (TextView)convertView.findViewById(R.id.hour);
            holder.image =(ImageView)convertView.findViewById(R.id.image);
            holder.status = (TextView)convertView.findViewById(R.id.status_hourly);
            convertView.setTag(holder);
        }
        else {
            holder =(ItemHourlyAdapter.ViewHolder)convertView.getTag();
        }
        final ItemHourly itemHourly = (ItemHourly) getItem(position);
        if(itemHourly !=null){
            holder.image.setImageResource(itemHourly.getImage());
            holder.status.setText(itemHourly.getStatus());
            holder.degree .setText(itemHourly.getDegree());
            holder.hour.setText(itemHourly.getHour());
        }
        return convertView;
    }
}
