package com.vvn.vocavocani.group;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by soo13 on 2017-08-09.
 */

public class GroupPagerAdapter extends FragmentPagerAdapter {

    public GroupPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return GroupIntro.getFragment();
            case 1:
                return GroupBoardFragment.getFragment();
            case 2:
                return GroupQuestionFragment.getFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return GroupIntro.getTitle();
            case 1:
                return GroupBoardFragment.getTitle();
            case 2:
                return GroupQuestionFragment.getTitle();
            default:
                return null;
        }
    }
}