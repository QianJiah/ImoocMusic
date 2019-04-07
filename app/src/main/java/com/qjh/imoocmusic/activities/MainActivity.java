package com.qjh.imoocmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.StringUtils;
import com.qjh.imoocmusic.R;
import com.qjh.imoocmusic.adapters.MusicGridAdapter;
import com.qjh.imoocmusic.adapters.MusicListAdapter;
import com.qjh.imoocmusic.customwidget.GridDecoration;
import com.qjh.imoocmusic.entities.MusicInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
//项目 Project
//模块 Module
    //最顶部的bar 是 statusBar

    private RecyclerView rvGrid, rvList;
    private int spanCount = 3;
    private MusicGridAdapter gridAdapter;
    private MusicListAdapter listAdapter;
    private List<MusicInfo> musicInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        initNavBar(false, StringUtils.getString(R.string.nav_title), true);
        iv_mine.setOnClickListener(this);
        //网格RecyclerView
        rvGrid = fd(R.id.recycler_grid);
        rvGrid.setLayoutManager(new GridLayoutManager(this, spanCount));
        rvGrid.addItemDecoration(new GridDecoration(getResources().getDimensionPixelSize(R.dimen.lineWidth), rvGrid));
        rvGrid.setNestedScrollingEnabled(false);    //取消RecyclerView的滑动
        gridAdapter = new MusicGridAdapter(this);
        rvGrid.setAdapter(gridAdapter);
        //列表RecyclerView
        rvList = fd(R.id.recycler_list);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvList.setNestedScrollingEnabled(false);    //取消RecyclerView的滑动
        listAdapter = new MusicListAdapter(musicInfos, rvList);
        rvList.setAdapter(listAdapter);
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

    /**
     * 初始化歌曲数据
     */
    private void initData() {
        musicInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MusicInfo musicInfo = new MusicInfo("Imooc Music Item "+i, "Author "+i);
            musicInfos.add(musicInfo);
        }
    }
}
