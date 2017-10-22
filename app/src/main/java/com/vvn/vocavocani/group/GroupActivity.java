package com.vvn.vocavocani.group;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Toast;

import com.vvn.vocavocani.R;
import com.vvn.vocavocani.question.WorkBookCreateActivity;

public class GroupActivity extends AppCompatActivity
        implements AppBarLayout.OnOffsetChangedListener {

    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;

    private boolean mIsTheTitleContainerVisible = true;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutInit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.group_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
            case R.id.add_contents:
                switch (tabLayout.getSelectedTabPosition()) {
                    case 0:
                        Toast.makeText(this, "Group Setting Btn", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(this, "Add board article", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(this, "Add question", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, WorkBookCreateActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        Toast.makeText(this, "Add question popup", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        if (tabLayout.getSelectedTabPosition() == 0) {
            handleAlphaOnTitle(percentage, View.INVISIBLE);
            //handleToolbarTitleVisibility(percentage);
        } else {
            handleAlphaOnTitle(percentage, View.VISIBLE);
        }
    }

    private void layoutInit() {
        setContentView(R.layout.group_main);

        setToolbarLayout();
        setContentLayout();
    }

    private void setToolbarLayout() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);

        //mAppBarLayout.addOnOffsetChangedListener(this);
    }

    private void setContentLayout() {

        viewPager = (ViewPager) findViewById(R.id.group_view_pager);
        GroupPagerAdapter pagerAdapter = new GroupPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.group_tab);
        tabLayout.setupWithViewPager(viewPager);
        setTabIcons(tabLayout, pagerAdapter);
    }

    private void setTabIcons(TabLayout tabLayout, GroupPagerAdapter pagerAdapter) {
        final int[] iconList = {
                R.drawable.ic_add_black_24dp,
                R.drawable.ic_add_black_24dp,
                R.drawable.ic_add_black_24dp
        };

        final int[] selectedIconList = {
                R.drawable.checkmark,
                R.drawable.checkmark,
                R.drawable.checkmark
        };

        final String[] stringList = {

        };

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setText(pagerAdapter.getPageTitle(i));
            // Set tab's default icon
            if (i == tabLayout.getSelectedTabPosition())
                tabLayout.getTabAt(i).setIcon(selectedIconList[i]);
            else
                tabLayout.getTabAt(i).setIcon(iconList[i]);

            // Set tab's select/unselect action
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    tab.setIcon(selectedIconList[tab.getPosition()]);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    tab.setIcon(iconList[tab.getPosition()]);
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                    tab.setIcon(selectedIconList[tab.getPosition()]);
                }
            });
        }
    }

    private void handleAlphaOnTitle(float percentage, int visivility) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if(mIsTheTitleContainerVisible) {
                startAlphaAnimation(toolbar, ALPHA_ANIMATIONS_DURATION, visivility);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(toolbar, ALPHA_ANIMATIONS_DURATION, visivility);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation (View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }
}
