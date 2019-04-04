package com.qjh.imoocmusic.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qjh.imoocmusic.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 欢迎页面展示 3s 后跳转到mainActivity
 * 1.延迟3s
 * 2.跳转页面
 */
public class WelcomeActivity extends BaseActivity {

    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }

    private void init() {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                //主线程中执行，3s 后执行这里的方法
                Log.e("hao", "当前线程名字："+ Thread.currentThread());
                go2LoginActivity();
            }
        }, 3 * 1000);
    }

    private void go2MainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void go2LoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();   //可以把当前Activity在任务栈中清除掉
    }
}
