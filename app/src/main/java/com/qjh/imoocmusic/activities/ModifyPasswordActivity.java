package com.qjh.imoocmusic.activities;

import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.StringUtils;
import com.qjh.imoocmusic.R;

public class ModifyPasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_password_activty);
        initView();
    }

    private void initView() {
        initNavBar(true, StringUtils.getString(R.string.modify_pass), false);
    }

    /**
     * 最终确认修改密码的按钮事件
     * @param view
     */
    public void doModifyPassword(View view) {

    }
}
