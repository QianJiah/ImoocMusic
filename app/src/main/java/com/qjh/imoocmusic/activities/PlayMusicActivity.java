package com.qjh.imoocmusic.activities;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.qjh.imoocmusic.R;
import com.qjh.imoocmusic.customwidget.PlayMusicView;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {

    private ImageView ivBg;
    private PlayMusicView playMusicView;
    private static final String ICON_URL = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3630500585,3295120327&fm=26&gp=0.jpg";
    private static final String MUSIC_URI = "http://gddx.sc.chinaz.com/Files/DownLoad/sound1/201809/10633.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        //隐藏statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
    }

    private void initView() {
        ivBg = fd(R.id.play_bg);
        //使用高斯模糊背景，glide-transformations
        Glide.with(this)
                .load(ICON_URL)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25,10)))
                .into(ivBg);
        playMusicView = fd(R.id.play_music_view);
        playMusicView.setMusicCircleImageView(ICON_URL);    //设置圆形封面
//        playMusicView.turnPlayAnim();   //启动播放动画
//        playMusicView.starPlay(MUSIC_URI);  //播放音乐
        playMusicView.stopPlay();
    }

    public void onBackClick(View view) {
        onBackPressed();
    }
}
