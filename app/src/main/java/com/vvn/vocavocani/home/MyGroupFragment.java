package com.vvn.vocavocani.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.vvn.vocavocani.GroupInfo;
import com.vvn.vocavocani.R;
import com.vvn.vocavocani.group.GroupActivity;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-07-27.
 */

public class MyGroupFragment extends android.support.v4.app.Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.my_group_layout, container, false);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*Intent intent = new Intent(MainActivity.this, MemoCreate.class);
                    startActivity(intent);*/
                }
            });
        }

        setGridView(rootView);
/*
        ImageButton createGroupBtn = (ImageButton) rootView.findViewById(R.id.group_create_btn);
        createGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GroupCreateActivity.class);
                startActivity(intent);
            }
        });*/
        return rootView;
    }

    public static MyGroupFragment getFragment() {
        Bundle bundle = new Bundle();
        MyGroupFragment fragment = new MyGroupFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static String getTitle() {
        // Generate title based on item position
        // return tabTitles[position];
        //Drawable image = getFragment().getContext().getResources().getDrawable(R.drawable.ic_add_black_24dp);
        //image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        //SpannableString sb = new SpannableString(" ");
        //ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        //sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return "My Group";
    }

    private void setGridView(View view) {
        ArrayList<GroupInfo> groupInfos = new ArrayList<>();
        groupInfos.add(new GroupInfo(0, "모임 이름1"));
        groupInfos.add(new GroupInfo(0, "모임 이름2"));
        groupInfos.add(null);

        GroupGridAdapter adapter = new GroupGridAdapter (
                getContext(),
                R.layout.group_item,
                groupInfos);

        GridView gv = (GridView) view.findViewById(R.id.group_list);
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "클릭 "+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), GroupActivity.class);
                startActivity(intent);
            }
        });
    }
}
