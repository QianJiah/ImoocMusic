package com.qjh.imoocmusic.activities;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qjh.imoocmusic.R;

public class BaseActivity extends Activity {

    private ImageView iv_back, iv_mine;
    private TextView title;

    /**
     * findViewById的简写方法
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T fd(@IdRes int id) {
        return findViewById(id);
    }

    /**
     * 初始化NavigationBar
     * @param isShowBack
     * @param titleText
     * @param isShowMine
     */
    protected void initNavBar(boolean isShowBack, String titleText, boolean isShowMine) {
        iv_back = fd(R.id.left_image);
        iv_mine = fd(R.id.right_image);
        title = fd(R.id.title_text);

        iv_back.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        iv_mine.setVisibility(isShowMine ? View.VISIBLE : View.GONE);
        title.setText(titleText);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
