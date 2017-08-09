package com.vvn.vocavocani.group;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vvn.vocavocani.R;

/**
 * Created by soo13 on 2017-08-09.
 */

public class GroupIntro extends android.support.v4.app.Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.group_intro, container, false);

        layoutInit(rootView);

        return rootView;
    }

    private void layoutInit(View rootView) {

        //TextView mTitle = (TextView) rootView.findViewById(R.id.toolbar_title);
    }

    public static GroupIntro getFragment() {
        Bundle bundle = new Bundle();
        GroupIntro fragment = new GroupIntro();
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
        return "Group Intro";
    }
}

