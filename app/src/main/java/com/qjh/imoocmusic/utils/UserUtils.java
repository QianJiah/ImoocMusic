package com.qjh.imoocmusic.utils;

import android.content.Context;
import android.text.TextUtils;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.qjh.imoocmusic.R;

public class UserUtils {
    /**
     * 验证注册和登录信息是否有效
     * @param context
     * @param phone
     * @param password
     * @return
     */
    public static boolean isValidateData(String phone, String password) {
        //RegexUtils.isMobileSimple(phone);  这是简单验证手机号
        if (!RegexUtils.isMobileExact(phone)) { //精确验证手机号
            ToastUtils.showShort(StringUtils.getString(R.string.validate_phone));
            return false;
        }
        if (TextUtils.isEmpty(password)) {  //验证密码不为空
            ToastUtils.showShort(StringUtils.getString(R.string.validate_password));
            return false;
        }
        return true;
    }
}
