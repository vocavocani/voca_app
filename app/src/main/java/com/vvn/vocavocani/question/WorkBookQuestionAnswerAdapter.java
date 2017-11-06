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
import android.widget.Toast;

import com.vvn.vocavocani.R;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-09-03.
 */

public class WorkBookQuestionAnswerAdapter extends RecyclerView.Adapter<WorkBookQuestionAnswerAdapter.ViewHolder>  {

    private Context mContext;
    private ArrayList<Answer> answerList = new ArrayList<>() ;

    public WorkBookQuestionAnswerAdapter(Context context, ArrayList<Answer> answerList) {
        this.mContext = context;
        this.answerList = answerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_selector, parent, false);
        return new ViewHolder(header);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int pos = position;

        setViewText(holder, pos);

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                buttonView.setChecked(true);
            }
        });
        holder.checkbox.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(), "문제 없애기", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.answerList == null)
            return 0;
        return this.answerList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private void setViewText(ViewHolder holder, int position) {
        holder.checkbox.setText(answerList.get(position).getAnswerText());
        holder.checkbox.setChecked(answerList.get(position).isChecked());
    }

    public void addItem(Answer answer) {
        answerList.add(answer);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkbox;

        public ViewHolder(View view) {
            super(view);
            checkbox = (CheckBox) view.findViewById(R.id.checkbox);
        }
    }
}
