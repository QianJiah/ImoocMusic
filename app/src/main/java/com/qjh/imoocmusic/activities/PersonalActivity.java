package com.qjh.imoocmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.StringUtils;
import com.qjh.imoocmusic.R;

public class PersonalActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        initView();
    }

    private void initView() {
        initNavBar(true, StringUtils.getString(R.string.personal_center), false);
    }

    /**
     * 修改密码的按钮事件
     * @param view
     */
    public void onModifyPassword(View view) {
        Intent intent = new Intent(this, ModifyPasswordActivity.class);
        startActivity(intent);
    }

    /**
     * 退出登录按钮事件
     * @param view
     */
    public void onLogout(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
