package com.liuyue.luckweather.ui.adapter;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuyue.luckweather.R;
import com.liuyue.luckweather.bean.ZhiShuBean;
import com.liuyue.luckweather.ui.SetActivity;
import com.liuyue.luckweather.ui.WebViewActivity;
import com.liuyue.luckweather.utils.Constant;

import java.util.List;


public class ZhiShuAdapter extends RecyclerView.Adapter {
    private List<ZhiShuBean> zhiShuBeanList;
    private Activity activity;
    private Intent intent;

    public ZhiShuAdapter(List<ZhiShuBean> list, Activity activity) {
        this.zhiShuBeanList = list;
        this.activity = activity;
        intent=new Intent(activity, WebViewActivity.class);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(activity).inflate(R.layout.zhishu_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (!zhiShuBeanList.get(position).getName().equals("加号")){
            ((ViewHolder) holder).name.setText(zhiShuBeanList.get(position).getName());
            ((ViewHolder)holder).msg.setText(zhiShuBeanList.get(position).getMsg());
        }else {
            ((ViewHolder) holder).name.setVisibility(View.GONE);
            ((ViewHolder)holder).msg.setVisibility(View.GONE);
        }

        ((ViewHolder) holder).img.setImageResource(zhiShuBeanList.get(position).getImgResource());

        if (!zhiShuBeanList.get(position).getLink_url(activity.getResources()).equals("跳转设置")){
            ((ViewHolder) holder).item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("url",zhiShuBeanList.get(position).getLink_url(activity.getResources()));
                    activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
                }
            });
        }else {
            ((ViewHolder) holder).item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.startActivityForResult(new Intent(activity, SetActivity.class), Constant.INTENT_REQUEST_SET,
                            ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return zhiShuBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name;
        private TextView msg;
        private LinearLayout item;

        public ViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.zhishu_img);
            name=itemView.findViewById(R.id.zhishu_name_tv);
            msg=itemView.findViewById(R.id.zhishu_msg_tv);
            item=itemView.findViewById(R.id.zhishu_ll);
        }

    }
}
