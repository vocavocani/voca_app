package com.vvn.vocavocani.question;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.vvn.vocavocani.R;

/**
 * Created by soo13 on 2017-09-05.
 */

public class WorkBookCreateActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Handler handler;
    public static final int CHANGE_TITLE_LAYOUT = 1;
    public static final int CHANGE_QUESTION_LAYOUT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutInit();
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case CHANGE_TITLE_LAYOUT:
                        switchFragment(new WorkBookCreateTitleFragment());
                        return true;
                    case CHANGE_QUESTION_LAYOUT:
                        switchFragment(new WorkBookQuestionCreateFragment());
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void layoutInit() {
        setContentView(R.layout.workbook_create_layout);

        setToolbarLayout();
        setContentLayout();
    }

    private void setToolbarLayout() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void setContentLayout() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.workbook_body, new WorkBookCreateTitleFragment());
        fragmentTransaction.commit();
    }

    public void switchFragment(Fragment targetFragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.workbook_body, targetFragment);
        fragmentTransaction.commit();
    }
}
