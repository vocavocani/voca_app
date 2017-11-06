package com.vvn.vocavocani.question;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vvn.vocavocani.R;

/**
 * Created by soo13 on 2017-09-08.
 */

public class WorkBookCreateTitleFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.workbook_title_create_layout, container, false);

        layoutInit(rootView);

        return rootView;
    }

    private void layoutInit(View rootView) {

        EditText workbookTitle = (EditText) rootView.findViewById(R.id.workbook_title);
        EditText tagName = (EditText) rootView.findViewById(R.id.tag_name);
        Button addTag = (Button) rootView.findViewById(R.id.add_tag);
        TextView tagList = (TextView) rootView.findViewById(R.id.tag_list);
    }

    public static WorkBookCreateTitleFragment getFragment() {
        Bundle bundle = new Bundle();
        WorkBookCreateTitleFragment fragment = new WorkBookCreateTitleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static String getTitle() {
        return "Work Book Title";
    }
}
