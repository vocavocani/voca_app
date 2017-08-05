package com.vvn.vocavocani.group;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vvn.vocavocani.R;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-08-06.
 */

public class GroupBoardAdapter extends RecyclerView.Adapter<GroupBoardAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<GroupBoardItem> memoDatas;

    public GroupBoardAdapter(Context context, ArrayList<GroupBoardItem> memoData) {
        this.memoDatas = memoData;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_board_adapter, parent, false);
        return new ViewHolder(v);
    }

    // 출력 될 아이템 관리
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int pos = position;
        // 각 뷰에 값넣기

        setViewText(holder, pos);


        holder.boardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 뷰 누를경우 상세 보기로 이동
                /*Intent intent = new Intent(mContext, MemoCreate.class);
                intent.putExtra("is_edit", true);
                intent.putExtra("memo_id", memoDatas.get(pos).get_id());

                ((AppCompatActivity) mContext).startActivityForResult(intent, ITEM_DELETE);*/
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
        holder.timestamp.setText(memoDatas.get(position).getTimestamp());
        holder.content.setText(memoDatas.get(position).getContent());
        holder.replyCount.setText(String.valueOf(memoDatas.get(position).getReplyCount()));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout boardItem;
        TextView title;
        TextView writer;
        TextView timestamp;
        TextView content;
        TextView replyCount;
        ImageView writerPhoto;

        public ViewHolder(View view) {
            super(view);
            boardItem = (RelativeLayout) view.findViewById(R.id.board_item);
            title = (TextView) view.findViewById(R.id.title);
            writer = (TextView) view.findViewById(R.id.writer_name);
            timestamp = (TextView) view.findViewById(R.id.timestamp);
            content = (TextView) view.findViewById(R.id.content);
            replyCount = (TextView) view.findViewById(R.id.reply_count);
            writerPhoto = (ImageView) view.findViewById(R.id.writer_photo);
        }
    }
}
