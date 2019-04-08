package com.qjh.imoocmusic.customwidget;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qjh.imoocmusic.R;
import com.qjh.imoocmusic.helpers.MediaPlayerHelper;

public class PlayMusicView extends FrameLayout {

    private Context mContext;
    private View mView;
    private ImageView ivPlay, ivNeedle, ivPan, ivRound;
    private FrameLayout centerFl; //整个音乐转盘的布局
    private Animation playPanAnim, playNeedleAnim, stopNeedleAnim;  //动画资源
    private boolean isPlaying;  //播放标志
    private MediaPlayerHelper mediaPlayerHelper;    //音乐播放类
    private String musicPath;  //音乐地址

    public PlayMusicView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;

        mView = LayoutInflater.from(mContext).inflate(R.layout.play_music, this, false);

        ivPlay = mView.findViewById(R.id.play_btn);
        ivNeedle = mView.findViewById(R.id.play_needle);
        ivPan = mView.findViewById(R.id.play_pan);
        ivRound = mView.findViewById(R.id.music_image);
        centerFl = mView.findViewById(R.id.center_fl);
        centerFl.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                turnPlayAnim();
            }
        });
        /**
         * 加载动画资源
         */
        playPanAnim = AnimationUtils.loadAnimation(mContext, R.anim.play_pan_anim);//光盘转动动画
        playNeedleAnim = AnimationUtils.loadAnimation(mContext, R.anim.play_needle_anim);//播放音乐，唱针转动动画
        stopNeedleAnim = AnimationUtils.loadAnimation(mContext, R.anim.stop_needle_anim);//停止音乐，唱针转动动画

        addView(mView);

        mediaPlayerHelper = MediaPlayerHelper.getInstance(mContext);    //初始化MediaPlayerHelper
    }

    /**
     * 切换播放动画及状态
     */
    public void turnPlayAnim() {
        if (isPlaying) {
            stopPlay();
        } else {
            starPlay(musicPath);
        }
    }

    /**
     * 播放音乐,加载相应动画
     */
    public void starPlay(String path) {
        //保存音乐的地址
        musicPath = path;

        ivPlay.setVisibility(View.GONE);
        centerFl.startAnimation(playPanAnim);
        ivNeedle.startAnimation(playNeedleAnim);
        isPlaying = true;

        /**
         * 播放音乐逻辑：判断当前需要播放的音乐是否是正在播放音乐
         * 1.Yes， 则直接调用mediaPlayerHelper.start();
         * 2.No,  则调用mediaPlayerHelper.setPath(String);
         */
        if (mediaPlayerHelper.getPath() != null
                && mediaPlayerHelper.getPath().equals(musicPath)) {
            mediaPlayerHelper.start();
        } else {
            mediaPlayerHelper.setPath(path);
            //setPath后，需要播放
            mediaPlayerHelper.setMediaPlayHelperListener(new MediaPlayerHelper.MediaPlayHelperListener() {
                @Override
                public void onPreparedOver(MediaPlayer mediaPlayer) {
                    mediaPlayerHelper.start();
                }
            });
        }

    }

    /**
     * 停止音乐，清除动画，并加载唱针的动画
     */
    public void stopPlay() {
        ivPlay.setVisibility(View.VISIBLE);
        centerFl.clearAnimation();  //清除光盘转动动画
        ivNeedle.startAnimation(stopNeedleAnim);
        isPlaying = false;

        mediaPlayerHelper.pause();
    }

    /**
     * 设置音乐光盘中的圆形图片
     */
    public void setMusicCircleImageView(String iconUrl) {
        Glide.with(mContext)
                .load(iconUrl)
                .into(ivRound);
    }
}
