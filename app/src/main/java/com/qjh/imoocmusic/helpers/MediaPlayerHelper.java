package com.qjh.imoocmusic.helpers;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;


/**
 * 音乐播放逻辑类
 */
public class MediaPlayerHelper {

    private static volatile MediaPlayerHelper instance;
    private Context mContext;
    private MediaPlayer mediaPlayer;
    private MediaPlayHelperListener mediaPlayHelperListener;
    private String path;    //音乐的地址

    private MediaPlayerHelper(Context context) {
        mContext = context.getApplicationContext();
        mediaPlayer = new MediaPlayer();
    }

    //设置监听器
    public void setMediaPlayHelperListener(MediaPlayHelperListener mediaPlayHelperListener) {
        this.mediaPlayHelperListener = mediaPlayHelperListener;
    }

    public static MediaPlayerHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (MediaPlayerHelper.class) {
                if (instance == null) {
                    instance = new MediaPlayerHelper(context);
                }
            }
        }
        return instance;
    }

    /**
     * 获取音乐的路径
     * @return
     */
    public String getPath() {
        return path;
    }

    /**
     * 音乐播放三部曲：
     * 1.setPath:  设置需要播放的音乐资源路径(地址)
     * 2.start:    播放音乐
     * 3.pause:    暂停音乐
     */

    //1. 设置需要播放的音乐资源路径
    public void setPath(String path) {
        /**
         * 三步：
         * 1.如果当前正在播放音乐，则需要重置播放状态
         * 2.设置播放路径
         * 3.准备播放
         */
        this.path = path;
        //1.如果当前正在播放音乐，则需要重置播放状态
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.reset();    //重置
        }

        //2.设置播放路径,通过Uri可播放网络歌曲
        try {
            mediaPlayer.setDataSource(mContext, Uri.parse(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3.准备播放
        mediaPlayer.prepareAsync();     //异步

        // 3.1  准备播放完的回调监听，告诉设备，我准备好了
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //异步加载完的通知
                if (mediaPlayHelperListener != null) {
                    mediaPlayHelperListener.onPreparedOver(mp);
                }
            }
        });

    }

    //2.start:    播放音乐
    public void start() {
        if (mediaPlayer.isPlaying()) return;    //正在播放则退出
        mediaPlayer.start();    //开始播放
    }

    //3.pause:  暂停播放
    public void pause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public interface MediaPlayHelperListener{

        void onPreparedOver(MediaPlayer mediaPlayer);
    }
}
