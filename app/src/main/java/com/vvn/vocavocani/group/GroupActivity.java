package com.vvn.vocavocani.group;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vvn.vocavocani.R;

import java.util.ArrayList;

public class GroupActivity extends AppCompatActivity
        implements AppBarLayout.OnOffsetChangedListener {

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;

    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;

    private RelativeLayout mTitleContainer;
    private TextView mTitle;
    private AppBarLayout mAppBarLayout;
    private GroupBoardAdapter groupBoardAdapter;

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
                Toast.makeText(this, "Add contents popup", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void layoutInit() {
        setContentView(R.layout.group_main);

        setToolbarLayout();
        setContentLayout();
    }

    private void setToolbarLayout() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mTitleContainer = (RelativeLayout) findViewById(R.id.group_layout);
        mTitle = (TextView) findViewById(R.id.toolbar_title);
        mAppBarLayout   = (AppBarLayout) findViewById(R.id.app_bar);

        mAppBarLayout.addOnOffsetChangedListener(this);
        startAlphaAnimation(mTitle, 0, View.INVISIBLE);
    }

    private void setContentLayout() {

        //SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);

        // RecyclerView 생성
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.board_list);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager1);

        // groupBoardAdapter 생성하면서 연결
        ArrayList<GroupBoardItem> boardItems = new ArrayList<>();
        boardItems.add(new GroupBoardItem(0, "게시물 제목", 0, "게시자", "abc image", "2017.07.01 오전 1:38",
                "오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구", 4));
        boardItems.add(new GroupBoardItem(0, "게시물 제목2", 0, "게시자2", "abc image", "2017.07.01 오전 1:31",
                "오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구", 2));
        boardItems.add(new GroupBoardItem(0, "게시물 제목2", 0, "게시자2", "abc image", "2017.07.01 오전 1:31",
                "오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구", 2));
        boardItems.add(new GroupBoardItem(0, "게시물 제목2", 0, "게시자2", "abc image", "2017.07.01 오전 1:31",
                "오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구", 2));
        boardItems.add(new GroupBoardItem(0, "게시물 제목2", 0, "게시자2", "abc image", "2017.07.01 오전 1:31",
                "오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구", 2));
        boardItems.add(new GroupBoardItem(0, "게시물 제목2", 0, "게시자2", "abc image", "2017.07.01 오전 1:31",
                "오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구", 2));
        groupBoardAdapter = new GroupBoardAdapter(this, boardItems);
        recyclerView.setAdapter(groupBoardAdapter);

        // RecyclerView를 Context 메뉴로 등록
        registerForContextMenu(recyclerView);
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if(mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }
    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if(!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
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
