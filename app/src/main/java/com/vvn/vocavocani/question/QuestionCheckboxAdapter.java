package com.vvn.vocavocani.question;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.vvn.vocavocani.R;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-09-03.
 */

public class QuestionCheckboxAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private Context mContext;
    private ArrayList<Answer> answerList = new ArrayList<>() ;
    private Question question;
    private int currentQuestion;
    private int endQuestion;

    private static final int HEADER = 2;
    private static final int LIST = 1;

    public QuestionCheckboxAdapter(Context context, ArrayList<Answer> answerList, Question question, int currentQuestion, int endQuestion) {
        this.mContext = context;
        this.answerList = answerList;
        this.question = question;
        this.currentQuestion = currentQuestion;
        this.endQuestion = endQuestion;
    }

    public void swap(ArrayList<Answer> answerList, Question question, int currentQuestion) {
        this.answerList = answerList;
        this.question = question;
        this.currentQuestion = currentQuestion;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER:
                View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_header, parent, false);
                return new HeaderViewHolder(header);
            case LIST:
                View list = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_selector, parent, false);
                return new ViewHolder(list);
        }
        return null;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            final int pos = position - 1;

            ViewHolder listHolder = (ViewHolder) holder;
            setViewText(listHolder, pos);

            listHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    answerList.get(pos).setChecked(isChecked);
                }
            });
        } else if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

            headerHolder.questionNumber.setText(String.valueOf(currentQuestion));
            headerHolder.questionEndNumber.setText(String.valueOf(endQuestion));
            headerHolder.questionDesc.setText(question.getQuestionDesc());
        }
    }

    @Override
    public int getItemCount() {
        if (this.answerList == null)
            return 0;
        return this.answerList.size() + 1; // Header 추가
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER;
        }
        return LIST;
    }

    private void setViewText(ViewHolder holder, int position) {
        holder.checkbox.setText(answerList.get(position).getAnswerText());
        holder.checkbox.setChecked(answerList.get(position).isChecked());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkbox;

        public ViewHolder(View view) {
            super(view);
            checkbox = (CheckBox) view.findViewById(R.id.checkbox);
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView questionNumber;
        TextView questionEndNumber;
        TextView questionDesc;

        public HeaderViewHolder(View view) {
            super(view);
            questionNumber = (TextView) view.findViewById(R.id.question_number);
            questionEndNumber = (TextView) view.findViewById(R.id.question_end_number);
            questionDesc = (TextView) view.findViewById(R.id.question_desc);
        }
    }
}
