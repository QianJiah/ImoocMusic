package com.qjh.imoocmusic.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.blankj.utilcode.util.StringUtils;
import com.qjh.imoocmusic.R;
import com.qjh.imoocmusic.adapters.MusicListAdapter;
import com.qjh.imoocmusic.entities.MusicInfo;

import java.util.ArrayList;
import java.util.List;

public class AblumActivity extends BaseActivity {

    private RecyclerView rvList;
    private MusicListAdapter musicListAdapter;
    private List<MusicInfo> musicInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ablum);
        initData();
        initView();
    }

    private void initView() {
        initNavBar(true, StringUtils.getString(R.string.ablum_list), false);
        rvList = fd(R.id.recycler_list);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        musicListAdapter = new MusicListAdapter(musicInfos, null);
        rvList.setAdapter(musicListAdapter);
    }

    /**
     * 初始化歌曲数据
     */
    private void initData() {
        musicInfos = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            MusicInfo musicInfo = new MusicInfo("Imooc Music Item "+i, "Author "+i);
            musicInfos.add(musicInfo);
        }
    }
}
