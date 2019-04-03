package com.qjh.imoocmusic.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.qjh.imoocmusic.R;
import com.qjh.imoocmusic.customwidget.InputView;
import com.qjh.imoocmusic.utils.UserUtils;

/**
 * NavigationBar 顶部布局，也可以叫toolbar
 */
public class LoginActivity extends BaseActivity {

    private InputView inputPhone, inputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        initNavBar(false, getResources().getString(R.string.btn_login), false);
        inputPhone = fd(R.id.phone_input);
        inputPassword = fd(R.id.password_input);
    }

    /**
     * 跳转注册页面的点击事件
     * @param view
     */
    public void onRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * 登录按钮的点击事件
     * @param view
     */
    public void onLogin(View view) {
        String phone = inputPhone.getEditTextStr();
        String password = inputPassword.getEditTextStr();
        if (UserUtils.isValidateData(phone, password)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
