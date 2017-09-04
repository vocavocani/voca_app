package com.vvn.vocavocani.group;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vvn.vocavocani.R;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-09-03.
 */

public class GroupQuestionFragment extends android.support.v4.app.Fragment {

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.group_question, container, false);

        layoutInit(rootView);

        return rootView;
    }

    private void layoutInit(View rootView) {
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        // RecyclerView 생성
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.question_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

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
        GroupQuestionAdapter groupBoardAdapter = new GroupQuestionAdapter(getContext(), boardItems);
        recyclerView.setAdapter(groupBoardAdapter);

        // RecyclerView를 Context 메뉴로 등록
        registerForContextMenu(recyclerView);
    }

    public static GroupQuestionFragment getFragment() {
        Bundle bundle = new Bundle();
        GroupQuestionFragment fragment = new GroupQuestionFragment();
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
        return "Group Question";
    }
}
