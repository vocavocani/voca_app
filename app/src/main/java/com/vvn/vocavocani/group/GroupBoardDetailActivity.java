package com.vvn.vocavocani.group;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vvn.vocavocani.R;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-09-01.
 */

public class GroupBoardDetailActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    int boardType = 0;
    public static final int BOARD = 0;
    public static final int QUESTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_board_detail);

        Intent receiveIntent = getIntent();
        boardType = receiveIntent.getIntExtra("type", BOARD);

        layoutInit();
    }

    private void layoutInit() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.group_board_list) ;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<GroupBoardComment> comments = new ArrayList<>();
        comments.add(new GroupBoardComment(0, "게시자", 0, "", "2017.07.01 오전 1:38",
                "오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구"));
        comments.add(new GroupBoardComment(0, "게시자", 0, "", "2017.07.01 오전 1:38",
                "오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구"));
        comments.add(new GroupBoardComment(0, "게시자", 0, "", "2017.07.01 오전 1:38",
                "오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구"));

        RecyclerView.Adapter commentAdapter;
        switch (boardType) {
            case QUESTION:
                commentAdapter = new GroupQuestionCommentAdapter(this,
                        new GroupBoardItem(0, "게시물 제목", 0, "게시자", "abc image", "2017.07.01 오전 1:38",
                                "오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구", 4),
                        comments);
                break;
            case BOARD:
            default:
                commentAdapter = new GroupBoardCommentAdapter(this,
                        new GroupBoardItem(0, "게시물 제목", 0, "게시자", "abc image", "2017.07.01 오전 1:38",
                                "오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구오직 우리 청춘에서만 구할 수 있는 것이다 청춘은 인생의 " +
                                        "황금시대다 우리는 이 황금시대의 가치를 충분히 발휘하 " +
                                        "기 위하여 이 황금시대를 영원히 붙잡아 어쩌구 저쩌구", 4),
                        comments);
        }

        recyclerView.setAdapter(commentAdapter) ;

        // RecyclerView를 Context 메뉴로 등록
        registerForContextMenu(recyclerView);
    }
}
