package com.vvn.vocavocani.question;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vvn.vocavocani.R;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-09-03.
 */

public class QuestionActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button nextButton;
    private RecyclerView checkboxListLayout;
    QuestionCheckboxAdapter checkboxAdapter;


    private ArrayList<Question> questionList = new ArrayList<>();
    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutInit();
    }

    private void layoutInit() {
        setContentView(R.layout.question_layout);

        setToolbarLayout();
        setContentLayout();
        setEventListener();
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

        TextView limitDate = (TextView) findViewById(R.id.limit_date);
        nextButton = (Button) findViewById(R.id.next_btn);
        checkboxListLayout = (RecyclerView) findViewById(R.id.checkbox_layout);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        checkboxListLayout.setHasFixedSize(true);
        checkboxListLayout.setLayoutManager(layoutManager);

        ArrayList<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer(1, false, "테스트 보기1"));
        answerList1.add(new Answer(2, false, "테스트 보기2"));
        answerList1.add(new Answer(3, true, "테스트 보기3"));
        answerList1.add(new Answer(4, false, "테스트 보기4"));
        ArrayList<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer(1, false, "테스트 보기1"));
        answerList2.add(new Answer(2, false, "테스트 보기2"));
        answerList2.add(new Answer(3, true, "테스트 보기3"));
        answerList2.add(new Answer(4, false, "테스트 보기4"));
        ArrayList<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer(1, false, "테스트 보기1"));
        answerList3.add(new Answer(2, false, "테스트 보기2"));
        answerList3.add(new Answer(3, true, "테스트 보기3"));
        answerList3.add(new Answer(4, false, "테스트 보기4"));


        questionList.add(new Question("1번문제 짱짱긴 문제\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ" +
                "\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ" +
                "\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\n", answerList1));
        questionList.add(new Question("2번문제 짱짱긴 문제\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ" +
                "\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ" +
                "\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\n", answerList2));
        questionList.add(new Question("3번문제 짱짱긴 문제\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ" +
                "\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ" +
                "\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\nㅇㄻㅇㄻㄴㅇㄻㄹㅇ\n", answerList3));

        checkboxAdapter = new QuestionCheckboxAdapter(
                this,
                questionList.get(currentQuestion).getAnswerList(),
                questionList.get(currentQuestion),
                currentQuestion+1,
                questionList.size());
        checkboxListLayout.setAdapter(checkboxAdapter);

        setQuestion();
    }

    private void setEventListener() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion < questionList.size() - 1) {
                    //saveData();
                    //getNextData();
                    currentQuestion++;
                    setQuestion();
                } else {
                    Toast.makeText(v.getContext(), "마지막 문제", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setQuestion() {
        checkboxAdapter.swap(questionList.get(currentQuestion).getAnswerList(), questionList.get(currentQuestion), currentQuestion+1);
        checkboxAdapter.notifyDataSetChanged();
    }
}
