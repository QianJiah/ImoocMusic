package com.qjh.imoocmusic.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.qjh.imoocmusic.R;
import com.qjh.imoocmusic.activities.AblumActivity;
import com.qjh.imoocmusic.customwidget.SquareImageView;

public class MusicGridAdapter extends RecyclerView.Adapter<MusicGridAdapter.GridViewHolder>{

    private Context mContext;

    public MusicGridAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.music_item_grid, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        Glide.with(mContext)
                .load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3630500585,3295120327&fm=26&gp=0.jpg")
                .placeholder(R.mipmap.ic_placeholder)
                .into(gridViewHolder.squareImageView);
        gridViewHolder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AblumActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        SquareImageView squareImageView;
        View mItemView;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            squareImageView = itemView.findViewById(R.id.iv_grid);
            this.mItemView = itemView;
        }
    }
}
