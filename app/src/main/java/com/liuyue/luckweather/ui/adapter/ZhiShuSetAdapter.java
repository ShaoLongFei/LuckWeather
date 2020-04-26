package com.liuyue.luckweather.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuyue.luckweather.R;
import com.liuyue.luckweather.bean.ZhiShuSetBean;
import com.liuyue.luckweather.widget.FunSwitch;
import java.util.List;


public class ZhiShuSetAdapter extends BaseAdapter {
    private List<ZhiShuSetBean> mList;
    private Context mContext;


    public ZhiShuSetAdapter(Context context, List<ZhiShuSetBean> list){
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
            view = LayoutInflater.from(mContext).inflate(R.layout.zhishu_set_item,null);
            view.setTag(viewHolder);
            viewHolder.name = view.findViewById(R.id.zhishu_set_name);
            viewHolder.funSwitch=view.findViewById(R.id.zhishu_set_switchButton) ;
        }else {
            viewHolder = (viewHolder) view.getTag();
        }
        viewHolder.name.setText(mList.get(postion).getName());
        viewHolder.funSwitch.setState(mList.get(postion).getIscheck());
        viewHolder.funSwitch.setOnStateChangeListener(new FunSwitch.OnStateChangeListener() {
            @Override
            public void OnStateChange(boolean state) {
                mList.get(postion).setIscheck(state);
            }
        });

        return view;
    }

    static class viewHolder{
        public TextView name;
        public FunSwitch funSwitch;
    }
}
