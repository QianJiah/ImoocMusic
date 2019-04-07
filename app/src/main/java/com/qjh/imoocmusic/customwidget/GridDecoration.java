package com.qjh.imoocmusic.customwidget;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 自定义Grid分割线
 */
public class GridDecoration extends RecyclerView.ItemDecoration {

    private int mSpan;  //表示item之间的间隙宽度

    public GridDecoration(int mSpan, RecyclerView rv) {
        this.mSpan = mSpan;
        getRecyclerViewOffsets(rv);
    }

    /**
     *  目的是让item之间存在间隙，不用密密麻麻，
     *  有一个item就走一次这个方法
     * @param outRect 表示item的矩形边界
     * @param view    表示item的View
     * @param parent  表示RecyclerView
     * @param state   表示RecyclerView的状态
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpan;   //表示item与左边的距离

        /*if (parent.getChildAdapterPosition(view) % 3 == 0) {  //获取每一行第一个item（每行有3个item）
            outRect.left = 0;   //这样虽然会有缝隙，但同时会导致每行第一个item的高度比其他的高一点
        }*/

        // 系统view  margin属性
        // 当margin 为正数时， view会距离边界产生一个距离
        // 当margin 为负数时， view会超出边界产生一个距离
//        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) parent.getLayoutParams();
//        layoutParams.leftMargin = -mSpan;
//        parent.setLayoutParams(layoutParams);
    }

    /**
     * 为了RecyclerView每行的第一个item都贴紧layout
     * @param parent
     */
    private void getRecyclerViewOffsets(RecyclerView parent) {
        // 系统view  margin属性
        // 当margin 为正数时， view会距离边界产生一个距离
        // 当margin 为负数时， view会超出边界产生一个距离
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) parent.getLayoutParams();
        layoutParams.leftMargin = -mSpan;
        parent.setLayoutParams(layoutParams);
    }
}
