package com.qjh.imoocmusic.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qjh.imoocmusic.R;
import com.qjh.imoocmusic.activities.PlayMusicActivity;
import com.qjh.imoocmusic.entities.MusicInfo;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.MyViewHolder> {
    private Context mContext;
    private RecyclerView mRecyclerView;
    private View mItemView;
    private List<MusicInfo> mData;
    private boolean isCalculateRecyclerHeight;

    public MusicListAdapter(List<MusicInfo> data, RecyclerView recyclerView) {
        mData = data;
        mRecyclerView = recyclerView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mItemView = LayoutInflater.from(mContext).inflate(R.layout.music_item_list, parent, false);
        return new MyViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        setRecyclerViewHeight();
        MusicInfo info = mData.get(position);
        holder.mTvListAuthor.setText(info.getMusicAuthor());
        holder.mTvListTitle.setText(info.getMusicName());
        Glide.with(mContext)
                .load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3630500585,3295120327&fm=26&gp=0.jpg")
                .placeholder(R.mipmap.ic_placeholder)
                .into(holder.mIvList);
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayMusicActivity.class);
                mContext.startActivity(intent);
            }
        });
        holder.mIvListPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mIvListPlay.setImageResource(R.mipmap.ic_pause);
            }
        });
//        holder.mIvListPlay.setImageBitmap(null);
//        holder.mIvList.setImageBitmap(null);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 设置RecyclerView的高度
     * 1.计算每一个item的高度
     * 2.统计item的数量
     * 3.RecyclerView的高度 = itemHeight * itemCounts;
     */
    private void setRecyclerViewHeight() {
        if (isCalculateRecyclerHeight || mRecyclerView == null) return;     //计算过了一次就不用再计算了
        isCalculateRecyclerHeight = true;
        //获取item的布局参数
        RecyclerView.LayoutParams itemParams = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
        //获取item的数量
        int itemCount = getItemCount();
        //得出RecyclerView应该设置的高度
        int recyclerViewHeight = itemParams.height * itemCount;
        Log.e("hao", "recyclerHeight = "+recyclerViewHeight);
        //获取RecyclerView的布局参数
        LinearLayout.LayoutParams recyclerParams = (LinearLayout.LayoutParams) mRecyclerView.getLayoutParams();
        recyclerParams.height = recyclerViewHeight;
        //最终设置
        mRecyclerView.setLayoutParams(recyclerParams);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvListAuthor;
        public TextView mTvListTitle;
        public ImageView mIvListPlay;
        public ImageView mIvList;
        public View mItemView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTvListAuthor = itemView.findViewById(R.id.tv_list_author);
            mTvListTitle = itemView.findViewById(R.id.tv_list_title);
            mIvListPlay = itemView.findViewById(R.id.iv_list_play);
            mIvList = itemView.findViewById(R.id.iv_list);
            this.mItemView = itemView;
        }
    }
}