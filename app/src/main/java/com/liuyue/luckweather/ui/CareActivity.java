package com.liuyue.luckweather.ui;

import android.Manifest;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.liuyue.luckweather.R;
import com.liuyue.luckweather.utils.AnimatorUtils;
import com.liuyue.luckweather.utils.Constant;
import com.liuyue.luckweather.utils.PermissionUnits;
import com.liuyue.luckweather.utils.SMSUtil;
import com.liuyue.luckweather.utils.SharePrefUtil;
import com.liuyue.luckweather.utils.TitleBarUtil;
import com.liuyue.luckweather.widget.AnimatedExpandableListView;
import com.gc.materialdesign.views.ButtonFlat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class CareActivity extends AppCompatActivity {

    private AnimatedExpandableListView listView;
    private ExampleAdapter adapter;
    private List<GroupItem> items = new ArrayList<GroupItem>();
    private ButtonFlat sendSMSBtn;

    @Override
    public void onBackPressed() {
        saveData();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TitleBarUtil.setStatusBarColor(this, R.color.clear_sky_day_start);
        setContentView(R.layout.activity_care);
        Slide slide=new Slide();
        slide.setSlideEdge(Gravity.RIGHT);
        getWindow().setEnterTransition(slide);
        getWindow().setExitTransition(slide);

        //检查权限
        List<String> fail = PermissionUnits.checkMorePermissions(CareActivity.this, Constant.PERMISSIONS);
        if (fail.size() != 0) {
            Toast.makeText(CareActivity.this, "我们需要一些必要的权限", Toast.LENGTH_SHORT).show();
            PermissionUnits.requestMorePermissions(CareActivity.this, fail, 0);
        }
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BROADCAST_SMS}, 1);

        sendSMSBtn = findViewById(R.id.care_send_sms_bt);
        sendSMSBtn.setBackgroundResource(R.drawable.bg_send_sms);
        //反射修改
        TextView textButton = null;
        Class temp = sendSMSBtn.getClass();
        try {
            Field f = temp.getDeclaredField("textButton");
            f.setAccessible(true);
            textButton = (TextView) f.get(sendSMSBtn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        textButton.setTextColor(getResources().getColor(R.color.white));

        addData();

        adapter = new ExampleAdapter(this);
        adapter.setData(items);

        listView = findViewById(R.id.care_list);
        listView.setAdapter(adapter);

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (listView.isGroupExpanded(groupPosition)) {
                    listView.collapseGroupWithAnimation(groupPosition);
                } else {
                    listView.expandGroupWithAnimation(groupPosition);
                }
                return true;
            }

        });

        sendSMSBtn.setOnClickListener(new View.OnClickListener() {
                  @RequiresApi(api = Build.VERSION_CODES.M)
                  @Override
                  public void onClick(View v) {
                      Set<String> phones = new HashSet<String>();
                      for (ChildItem childItem : adapter.items.get(2).items) {
                          if (childItem.isCheck) {
                              phones.add(childItem.number);
                          }
                      }
                      SMSUtil.sendSMS(CareActivity.this, phones);
                      Toast.makeText(CareActivity.this, "成功发送短信提醒！", Toast.LENGTH_SHORT).show();
                  }

              }
        );

        ((TextView) findViewById(R.id.titlebar_title)).setText("爱心提醒");
        findViewById(R.id.titlebar_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                finish();
            }
        });

    }

    private void saveData() {
        Set<String> careNumbers = new HashSet<>();
        for (ChildItem childItem : items.get(2).items) {
            if (childItem.isCheck) {
                careNumbers.add(childItem.number);
            }
        }
        Set<String> careWeathers = new HashSet<>();
        for (ChildItem childItem : items.get(1).items) {
            if (childItem.isCheck) {
                careWeathers.add(childItem.name);
            }
        }
        SharePrefUtil.saveSetString(CareActivity.this, SharePrefUtil.careNumbers, careNumbers);
        SharePrefUtil.saveSetString(CareActivity.this, SharePrefUtil.careWeathers, careWeathers);
        SharePrefUtil.saveBoolean(CareActivity.this, SharePrefUtil.careMode, items.get(0).items.get(0).isCheck);
    }

    private void addData() {
        GroupItem modeItem = new GroupItem();
        modeItem.title = "提醒模式";
        modeItem.hint = "设置提醒模式，分为手动模式和自动模式";
        modeItem.items = getCareModes();
        items.add(modeItem);
        GroupItem timeItem = new GroupItem();
        timeItem.title = "提醒时机";
        timeItem.hint = "设置爱心提醒时机，当满足条件时发送提醒";
        timeItem.items = getCareWeathers();
        items.add(timeItem);
        GroupItem contactsItem = new GroupItem();
        contactsItem.title = "提醒人";
        contactsItem.hint = "选择关心的人，当满足条件时发送提醒";
        contactsItem.items = getContacts();
        items.add(contactsItem);
    }

    private List<ChildItem> getCareModes() {

        Boolean isAuto = SharePrefUtil.getBoolean(CareActivity.this, SharePrefUtil.careMode, false);
        if (isAuto) {
            sendSMSBtn.setVisibility(View.GONE);
        } else {
            sendSMSBtn.setVisibility(View.VISIBLE);
        }
        List<ChildItem> childItemList = new ArrayList();
        ChildItem autoItem = new ChildItem();
        autoItem.name = "自动模式";
        autoItem.isCheck = isAuto;
        childItemList.add(autoItem);
        ChildItem handItem = new ChildItem();
        handItem.name = "手动模式";
        handItem.isCheck = !isAuto;
        childItemList.add(handItem);
        return childItemList;
    }

    private List<ChildItem> getCareWeathers() {
        Set<String> careWeathers = SharePrefUtil.getSetString(this, SharePrefUtil.careWeathers, new HashSet<String>());
        List<ChildItem> childItemList = new ArrayList<ChildItem>();
        for (String string : Constant.CARE_WEATHERS) {
            ChildItem childItem = new ChildItem();
            childItem.name = string;
            if (careWeathers.contains(string)) {
                childItem.isCheck = true;
            }
            childItemList.add(childItem);
        }
        return childItemList;
    }

    private static class GroupItem {
        String title;
        String hint;
        List<ChildItem> items = new ArrayList<ChildItem>();
    }

    private static class ChildItem {
        String name;
        String number;
        boolean isCheck = false;
    }

    private static class ChildHolder {
        TextView name;
        ImageView image;
        LinearLayout space;
    }

    private static class GroupHolder {
        TextView title;
        TextView hint;
    }

    private class ExampleAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {
        private LayoutInflater inflater;

        public List<GroupItem> items;

        public ExampleAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        public void setData(List<GroupItem> items) {
            this.items = items;
        }

        @Override
        public ChildItem getChild(int groupPosition, int childPosition) {
            return items.get(groupPosition).items.get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getRealChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            final ChildHolder holder;
            final ChildItem item = getChild(groupPosition, childPosition);
            if (convertView == null) {
                holder = new ChildHolder();
                convertView = inflater.inflate(R.layout.care_child_item, parent, false);
                holder.name = convertView.findViewById(R.id.care_name_tv);
                holder.image = convertView.findViewById(R.id.care_img_iv);
                holder.space = convertView.findViewById(R.id.care_space_ll);
                convertView.setTag(holder);
            } else {
                holder = (ChildHolder) convertView.getTag();
            }

            holder.name.setText(item.name);

            if (item.isCheck) {
                holder.image.setImageResource(R.drawable.ic_care_yes);
            } else {
                holder.image.setImageResource(R.drawable.ic_care_no);
            }

            holder.space.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item.isCheck) {
                        holder.image.setImageResource(R.drawable.ic_care_no);
                        AnimatorUtils.setScalse(holder.image);
                        if (item.name.equals("自动模式")) {
                            getChild(groupPosition, childPosition + 1).isCheck = true;
                            adapter.notifyDataSetChanged();
                            sendSMSBtn.setVisibility(View.GONE);
                        } else if (item.name.equals("手动模式")) {
                            getChild(groupPosition, childPosition - 1).isCheck = true;
                            adapter.notifyDataSetChanged();
                            sendSMSBtn.setVisibility(View.VISIBLE);
                        }
                        item.isCheck = false;
                    } else {
                        holder.image.setImageResource(R.drawable.ic_care_yes);
                        AnimatorUtils.setScalse(holder.image);
                        if (item.name.equals("自动模式")) {
                            getChild(groupPosition, childPosition + 1).isCheck = false;
                            adapter.notifyDataSetChanged();
                            sendSMSBtn.setVisibility(View.GONE);
                        } else if (item.name.equals("手动模式")) {
                            getChild(groupPosition, childPosition - 1).isCheck = false;
                            adapter.notifyDataSetChanged();
                            sendSMSBtn.setVisibility(View.VISIBLE);
                        }
                        item.isCheck = true;
                    }

                }
            });

            return convertView;
        }

        @Override
        public int getRealChildrenCount(int groupPosition) {
            return items.get(groupPosition).items.size();
        }

        @Override
        public GroupItem getGroup(int groupPosition) {
            return items.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return items.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupHolder holder;
            GroupItem item = getGroup(groupPosition);
            if (convertView == null) {
                holder = new GroupHolder();
                convertView = inflater.inflate(R.layout.care_group_item, parent, false);
                holder.title = convertView.findViewById(R.id.care_title_tv);
                holder.hint = convertView.findViewById(R.id.care_hint_tv);
                convertView.setTag(holder);
            } else {
                holder = (GroupHolder) convertView.getTag();
            }

            holder.title.setText(item.title);
            holder.hint.setText(item.hint);
            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int arg0, int arg1) {
            return true;
        }

    }

    private List<ChildItem> getContacts() {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] projection = new String[]{ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME};
        Cursor cursor = this.getContentResolver().query(uri, projection, null, null, null);
        Set<String> careNumbers = SharePrefUtil.getSetString(this, SharePrefUtil.careNumbers, new HashSet<String>());
        List<ChildItem> childItemList = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Long id = cursor.getLong(0);
                ChildItem childItem = new ChildItem();
                //获取姓名
                String name = cursor.getString(1);
                childItem.name = name;
                String[] phoneProjection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor phonesCusor = this.getContentResolver().query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI, phoneProjection,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + id,
                        null, null);
                if (phonesCusor != null && phonesCusor.moveToFirst()) {
                    //电话号码
                    String number = phonesCusor.getString(0).replace(" ", "");
                    childItem.number = number;
                    if (careNumbers.contains(number)) {
                        childItem.isCheck = true;
                    }
                }
                childItemList.add(childItem);
            }
            while (cursor.moveToNext());
        }
        return childItemList;
    }
}
