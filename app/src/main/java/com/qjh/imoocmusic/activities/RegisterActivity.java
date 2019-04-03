package com.qjh.imoocmusic.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.qjh.imoocmusic.R;
import com.qjh.imoocmusic.customwidget.InputView;

public class RegisterActivity extends BaseActivity {

    private InputView registerNum, firstPassword, confirmPassword;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        preferences = getSharedPreferences("ImoocData", MODE_PRIVATE);
        initView();
    }

    private void initView() {
        initNavBar(true, StringUtils.getString(R.string.btn_register), false);
        registerNum = fd(R.id.phone_input_register);
        firstPassword = fd(R.id.password_input_register);
        confirmPassword = fd(R.id.password_input_confirm);
    }

    /**
     * 真正注册的按钮操作，注册成功后跳转回登录页面
     * @param view
     */
    public void doRegister(View view) {
        String phone = registerNum.getEditTextStr();
        String firstPass = firstPassword.getEditTextStr();
        String secondPass = confirmPassword.getEditTextStr();
        if (!RegexUtils.isMobileExact(phone)) {
            ToastUtils.showShort(R.string.validate_phone);
        } else if (!firstPass.equals(secondPass)) {
            ToastUtils.showShort(R.string.twice_pass_wrong);
        } else if (TextUtils.isEmpty(firstPass) || TextUtils.isEmpty(secondPass)) {
            ToastUtils.showShort(R.string.pass_not_null);
        } else {
            ToastUtils.showShort(R.string.register_success);
            preferences.edit().putString("registerPhone", phone).apply();   //把手机号存进sharePreference
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("registerPhone", phone);
            startActivity(intent);
        }
    }
}
