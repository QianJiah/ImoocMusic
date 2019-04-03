package com.qjh.imoocmusic.customwidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.qjh.imoocmusic.R;

/**
 *  自定义View实现登录的界面
 *  1.input_icon: 输入框前面的图标
 *  2.input_hint: 输入框的提示信息
 *  3.is_password: 输入的内容是否以密文的形式展示
 */
public class InputView extends FrameLayout{

    private int inputIconId;
    private String inputHintStr;
    private boolean isPassword;

    private View mView;
    private ImageView ivPhone;
    private EditText editPhoneNum;

    public InputView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public InputView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public InputView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public InputView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    /**
     * 初始化自定义属性
     * @param context
     * @param attr
     */
    private void init(Context context, AttributeSet attr) {
        if (attr == null) return;
        TypedArray typedArray = context.obtainStyledAttributes(attr, R.styleable.InputView);
        inputIconId = typedArray.getResourceId(R.styleable.InputView_input_icon, R.mipmap.ic_logo);
        inputHintStr = typedArray.getString(R.styleable.InputView_input_hint);
        isPassword = typedArray.getBoolean(R.styleable.InputView_is_password, false);
        typedArray.recycle();

        //绑定Layout
        mView = LayoutInflater.from(context).inflate(R.layout.input_view, this, false);
        ivPhone = mView.findViewById(R.id.input_icon);
        editPhoneNum = mView.findViewById(R.id.input_num);

        //自定义属性 与 Layout关联
        ivPhone.setImageResource(inputIconId);  //设置图片
        editPhoneNum.setHint(inputHintStr);     //设置提示信息
        editPhoneNum.setInputType(isPassword ? InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_PHONE);

        //最后，把Layout加入到InputView中
        addView(mView);
    }

    /**
     * 返回输入的内容
     * @return
     */
    public String getEditTextStr() {
        Log.e("hao", "输入的号码："+ editPhoneNum.getText().toString().trim());
        return editPhoneNum.getText().toString().trim();
    }
}
