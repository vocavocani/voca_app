package com.vvn.vocavocani.question;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vvn.vocavocani.R;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-09-08.
 */

public class WorkBookQuestionCreateFragment extends Fragment {

    WorkBookQuestionAnswerAdapter answerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.workbook_question_create_layout, container, false);

        layoutInit(rootView);

        return rootView;
    }

    private void layoutInit(View rootView) {

        TextView questionNumber = (TextView) rootView.findViewById(R.id.question_number);
        TextView questionEndNumber = (TextView) rootView.findViewById(R.id.question_end_number);
        TextView questionDesc = (TextView) rootView.findViewById(R.id.question_desc);
        LinearLayout addAnswer = (LinearLayout) rootView.findViewById(R.id.add_answer);
        Button addExplain = (Button) rootView.findViewById(R.id.add_explain);
        RecyclerView answerList = (RecyclerView) rootView.findViewById(R.id.answer_list);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(rootView.getContext());
        answerList.setHasFixedSize(true);
        answerList.setLayoutManager(layoutManager1);

        ArrayList<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer(1, true, "테스트 보기1"));
        answerList1.add(new Answer(2, true, "테스트 보기2"));

        answerAdapter = new WorkBookQuestionAnswerAdapter(
                rootView.getContext(),
                answerList1);

        answerList.setAdapter(answerAdapter);

        addAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerAdapter.addItem(new Answer(1, true, "테스트 보기"));
            }
        });
    }

    public static WorkBookCreateTitleFragment getFragment() {
        Bundle bundle = new Bundle();
        WorkBookCreateTitleFragment fragment = new WorkBookCreateTitleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static String getTitle() {
        return "Work Book Question";
    }
}
