package com.qjh.imoocmusic.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qjh.imoocmusic.R;

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

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
