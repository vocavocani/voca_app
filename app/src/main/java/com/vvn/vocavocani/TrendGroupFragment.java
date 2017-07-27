package com.vvn.vocavocani;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by soo13 on 2017-07-27.
 */

public class TrendGroupFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.trend_group_layout, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.setSupportActionBar(toolbar);

        return rootView;
    }

    public static TrendGroupFragment getFragment() {
        Bundle bundle = new Bundle();
        TrendGroupFragment fragment = new TrendGroupFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static String getTitle() {
        return "Trend Group";
    }
}
