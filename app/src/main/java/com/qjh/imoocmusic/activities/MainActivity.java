package com.qjh.imoocmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.StringUtils;
import com.qjh.imoocmusic.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {
//项目 Project
//模块 Module
    //最顶部的bar 是 statusBar

    private RecyclerView rvGrid;
    private int spanCount = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initNavBar(false, StringUtils.getString(R.string.nav_title), true);
        iv_mine.setOnClickListener(this);
        rvGrid = fd(R.id.recycler_grid);
        rvGrid.setLayoutManager(new GridLayoutManager(this, spanCount));
//        rvGrid.setAdapter();
    }

    /**
     * 个人设置按钮点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PersonalActivity.class);
        startActivity(intent);
    }
}
