package com.vvn.vocavocani.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vvn.vocavocani.GroupInfo;
import com.vvn.vocavocani.R;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-07-28.
 */

public class GroupGridAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<GroupInfo> groupInfos = new ArrayList<>();
    LayoutInflater inf;

    public GroupGridAdapter(Context context, int layout, ArrayList<GroupInfo> groupInfos) {
        this.context = context;
        this.layout = layout;
        this.groupInfos = groupInfos;
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return groupInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return groupInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
            convertView = inf.inflate(layout, null);

        TextView groupName = (TextView) convertView.findViewById(R.id.group_name);
        TextView groupNew = (TextView) convertView.findViewById(R.id.group_new);
        ImageView groupCreateBtn = (ImageView) convertView.findViewById(R.id.group_create_btn);

        if (groupInfos.get(position) == null) {
            groupCreateBtn.setVisibility(View.VISIBLE);
            groupName.setText("");
            groupNew.setVisibility(View.GONE);
        } else {
            groupCreateBtn.setVisibility(View.GONE);
            groupName.setText(groupInfos.get(position).getGroupName());
            if (groupInfos.get(position).isNew()) {
                groupNew.setVisibility(View.VISIBLE);
            } else {
                groupNew.setVisibility(View.GONE);
            }
        }
        return convertView;
    }
}
