package com.liuyue.luckweather.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuyue.luckweather.R;
import com.liuyue.luckweather.bean.AlarmBean;

import java.util.List;


public class AlarmAdapter extends BaseAdapter {
    public List<AlarmBean> mList;
    private Context mContext;


    public AlarmAdapter(Context context, List<AlarmBean> list){
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postion, View view, ViewGroup viewGroup) {
        final viewHolder viewHolder;

        if (view == null){
            viewHolder = new viewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.alarm_item,null);
            view.setTag(viewHolder);
            viewHolder.title_alarm_iv = view.findViewById(R.id.alarm_title_iv);
            viewHolder.title_alarm_tv=view.findViewById(R.id.alarm_title_tv);
            viewHolder.alarm_message_tv=view.findViewById(R.id.alarm_message_tv);
            viewHolder.alarm_remind_tv=view.findViewById(R.id.alarm_remind_tv);
        }else {
            viewHolder = (viewHolder) view.getTag();
        }
        viewHolder.title_alarm_iv.setImageResource(mList.get(postion).getImage());
        viewHolder.title_alarm_tv.setText(mList.get(postion).getTitle()+"预警");
        viewHolder.alarm_message_tv.setText(mList.get(postion).getMessage());
        viewHolder.alarm_remind_tv.setText(mList.get(postion).getRemind());
        return view;
    }

    static class viewHolder{
        public ImageView title_alarm_iv;
        public TextView title_alarm_tv;
        public TextView alarm_message_tv;
        public TextView alarm_remind_tv;
    }
}
