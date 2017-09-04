package com.vvn.vocavocani.group;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vvn.vocavocani.R;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-09-03.
 */

public class GroupQuestionCommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<GroupBoardComment> comments;
    private GroupBoardItem boardItem;
    private static final int HEADER = 2;
    private static final int LIST = 1;

    public GroupQuestionCommentAdapter(Context context, GroupBoardItem boardItem, ArrayList<GroupBoardComment> comments) {
        this.mContext = context;
        this.boardItem = boardItem;
        this.comments = comments;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("ViewType TEST", ""+viewType);
        switch (viewType) {
            case HEADER:
                View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_question_detail_header, parent, false);
                return new HeaderViewHolder(header);
            case LIST:
                View list = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_board_comment, parent, false);
                return new ViewHolder(list);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            int pos = position - 1; // Header 크기만큼 한칸 아래로
            ViewHolder commentHolder = (ViewHolder) holder;
            commentHolder.writer.setText(comments.get(pos).getWriter());
            commentHolder.content.setText(comments.get(pos).getContent());
            commentHolder.timestamp.setText(comments.get(pos).getTimestamp());
            commentHolder.commentLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(mContext, "댓글 클릭 ", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });

        } else if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            headerHolder.writer.setText(boardItem.getBoardWriterName());
            //headerHolder.writerPhoto.setResource(boardItem.getBoardWriterPhoto());
            headerHolder.title.setText(boardItem.getBoardTitle());
            //headerHolder.type.setText(boardItem.getBoardType());
            headerHolder.content.setText(boardItem.getContent());
            headerHolder.replyCount.setText(String.valueOf(boardItem.getReplyCount()));
            headerHolder.startTime.setText(boardItem.getTimestamp());
            headerHolder.endTime.setText(boardItem.getTimestamp());
            headerHolder.solveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "문제 풀기", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return comments.size() + 1; // Header 추가
    }

    //뷰타입 정하기
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER;
        }
        return LIST;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout commentLayout;
        TextView writer;
        TextView timestamp;
        TextView content;
        ImageView writerPhoto;

        public ViewHolder(View view) {
            super(view);
            commentLayout = (LinearLayout) view.findViewById(R.id.board_comment);
            writer = (TextView) view.findViewById(R.id.board_writer);
            timestamp = (TextView) view.findViewById(R.id.board_comment_date);
            content = (TextView) view.findViewById(R.id.board_comment_content);
            writerPhoto = (ImageView) view.findViewById(R.id.board_profile_img);
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView writer;
        TextView type;
        TextView title;
        ImageView writerPhoto;
        TextView replyCount;
        TextView startTime;
        TextView endTime;
        TextView content;
        Button solveButton;

        public HeaderViewHolder(View view) {
            super(view);
            writer = (TextView) view.findViewById(R.id.board_writer);
            startTime = (TextView) view.findViewById(R.id.start_time);
            endTime = (TextView) view.findViewById(R.id.end_time);
            content = (TextView) view.findViewById(R.id.board_content);
            type = (TextView) view.findViewById(R.id.board_type);
            title = (TextView) view.findViewById(R.id.board_title);
            replyCount = (TextView) view.findViewById(R.id.comment_count);
            writerPhoto = (ImageView) view.findViewById(R.id.board_profile_img);
            solveButton = (Button) view.findViewById(R.id.group_solve_problem_btn);
        }
    }
}

