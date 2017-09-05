package com.vvn.vocavocani.group;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vvn.vocavocani.R;
import com.vvn.vocavocani.question.QuestionActivity;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-09-03.
 */

public class GroupQuestionAdapter extends RecyclerView.Adapter<GroupQuestionAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<GroupBoardItem> memoDatas;

    public GroupQuestionAdapter(Context context, ArrayList<GroupBoardItem> memoData) {
        this.memoDatas = memoData;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_question_item, parent, false);
        return new ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int pos = position;

        setViewText(holder, pos);

        holder.boardItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 뷰 누를경우 상세 보기로 이동
                Toast.makeText(mContext, "클릭 "+pos, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, GroupBoardDetailActivity.class);
                intent.putExtra("type", GroupBoardDetailActivity.QUESTION);
                mContext.startActivity(intent);
            }
        });

        holder.solveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "문제풀기 "+pos, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, QuestionActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (this.memoDatas == null)
            return 0;
        return this.memoDatas.size();
    }

    // 아이템 position의 ID 값 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }

    public void swap(ArrayList<GroupBoardItem> memoDatas){
        this.memoDatas.clear();
        this.memoDatas.addAll(memoDatas);
        notifyDataSetChanged();
    }

    // 외부에서 아이템 추가 요청 시 사용
    public void add(GroupBoardItem memoData) {
        this.memoDatas.add(memoData);
    }

    // 외부에서 아이템 삭제 요청 시 사용
    public void remove(int _position) {
        this.memoDatas.remove(_position);
    }

    private void setViewText(ViewHolder holder, int position) {
        holder.title.setText(memoDatas.get(position).getBoardTitle());
        holder.writer.setText(memoDatas.get(position).getBoardWriterName());
        holder.startTime.setText(memoDatas.get(position).getTimestamp());
        holder.endTime.setText(memoDatas.get(position).getTimestamp());
        holder.content.setText(memoDatas.get(position).getContent());
        holder.replyCount.setText(String.valueOf(memoDatas.get(position).getReplyCount()));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout boardItemLayout;
        TextView title;
        TextView writer;
        TextView startTime;
        TextView endTime;
        TextView content;
        TextView replyCount;
        ImageView writerPhoto;
        Button solveButton;

        public ViewHolder(View view) {
            super(view);
            boardItemLayout = (RelativeLayout) view.findViewById(R.id.board_item);
            title = (TextView) view.findViewById(R.id.title);
            writer = (TextView) view.findViewById(R.id.writer_name);
            startTime = (TextView) view.findViewById(R.id.start_time);
            endTime = (TextView) view.findViewById(R.id.end_time);
            content = (TextView) view.findViewById(R.id.content);
            replyCount = (TextView) view.findViewById(R.id.reply_count);
            writerPhoto = (ImageView) view.findViewById(R.id.writer_photo);
            solveButton = (Button) view.findViewById(R.id.group_solve_problem_btn);
        }
    }
}
