package com.vvn.vocavocani;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by soo13 on 2017-07-27.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MyGroupFragment.getFragment();
            case 1:
                return TrendGroupFragment.getFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                //return MyGroupFragment.getTitle();
            case 1:
                //return TrendGroupFragment.getTitle();
            default:
                return null;
        }
    }
}
