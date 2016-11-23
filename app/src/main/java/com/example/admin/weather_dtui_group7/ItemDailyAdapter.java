package com.example.admin.weather_dtui_group7;

import android.content.ClipData;
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
 * Created by phong on 11/19/16.
 */

public class ItemDailyAdapter extends BaseAdapter {
    class ViewHolder {
        ImageView iconWeather;
        TextView date_number;
        TextView date_string;
        TextView status;
        TextView degree;
        ImageView iconNext;
    }
    public ArrayList<ItemDaily> listDaily;
    LayoutInflater inflater = null;
    boolean[] animationStates;
    private Context mContext;
    public ItemDailyAdapter(Context context, ArrayList<ItemDaily> item){
        inflater =LayoutInflater.from(context);
        mContext = context;
        this.listDaily = item;

    }
    @Override
    public int getCount() {
        return listDaily.size();
    }

    @Override
    public Object getItem(int i) {
        return listDaily.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        animationStates = new boolean[getCount()];
        if(view == null){
            view = inflater.inflate(R.layout.item_listview,null);
            holder = new ViewHolder();
            holder.iconWeather = (ImageView)view.findViewById(R.id.iconWeather);
            holder.date_number = (TextView)view.findViewById(R.id.date_number);
            holder.date_string = (TextView)view.findViewById(R.id.date_string);
            holder.status = (TextView)view.findViewById(R.id.status);
            holder.degree = (TextView)view.findViewById(R.id.degree);
            holder.iconNext= (ImageView)view.findViewById(R.id.iconNext);
            if (!animationStates[i]) {
                animationStates[i] = true;
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.fade_in);
                animation.setStartOffset(i*700);
                view.startAnimation(animation);
            }
            view.setTag(holder);
        }
        else {
            holder =(ViewHolder)view.getTag();
        }
        final ItemDaily itemDaily = (ItemDaily)getItem(i);
        if(itemDaily !=null){
            holder.iconWeather.setImageResource(itemDaily.getIconWeather());
            holder.date_number.setText(itemDaily.getDate_number());
            holder.date_string.setText(itemDaily.getDate_string());
            holder.status.setText(itemDaily.getStatus());
            holder.degree.setText(itemDaily.getDegree());
            holder.iconNext.setImageResource(itemDaily.getIconNext());
        }
        return view;
    }
}
