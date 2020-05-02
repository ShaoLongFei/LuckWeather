package com.liuyue.luckweather.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liuyue.luckweather.R;
import com.liuyue.luckweather.bean.CityWheatherBean;
import com.liuyue.luckweather.activity.CityMenuListener;

import java.util.List;


public class CityMenuAdapter extends BaseAdapter {
    private Activity context;
    private List<CityWheatherBean> cityWheatherBeans;
    private CityMenuListener cityMenuListener;

    public CityMenuAdapter(List<CityWheatherBean> cityWheatherBeans, Activity context, CityMenuListener cityMenuListener) {
        this.cityWheatherBeans = cityWheatherBeans;
        this.context = context;
        this.cityMenuListener=cityMenuListener;
    }

    @Override
    public int getCount() {
        return cityWheatherBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return cityWheatherBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;


        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.city_menu_item, null);
            holder.backgroundRl =convertView.findViewById(R.id.card_bg_rl);
            holder.tempTv = convertView.findViewById(R.id.card_temp_tv);
            holder.cityTv=convertView.findViewById(R.id.card_city_tv);
            holder.timeTv=convertView.findViewById(R.id.card_time_tv);
            holder.weatherTv=convertView.findViewById(R.id.card_weather_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.backgroundRl.setBackgroundResource(cityWheatherBeans.get(position).getIcon());
        holder.tempTv.setText(cityWheatherBeans.get(position).getTemp()+"℃");
        holder.cityTv.setText(cityWheatherBeans.get(position).getCity());
        holder.timeTv.setText(cityWheatherBeans.get(position).getTime());
        holder.weatherTv.setText(cityWheatherBeans.get(position).getWeather());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityMenuListener.OnClickListener(position);
            }
        });
        final View finalConvertView = convertView;
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cityMenuListener.OnLongClickListener(position, finalConvertView);
                return true;
            }
        });
        return convertView;
    }


    public class ViewHolder {
        private RelativeLayout backgroundRl;
        private TextView tempTv;
        private TextView cityTv;
        private TextView timeTv;
        private TextView weatherTv;
    }
}
