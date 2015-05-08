package com.linwoain.ui;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.linwoain.util.LLogUtils;

import java.lang.reflect.Field;


/**
 * Created by wuxuejian on 2015/5/8.
 * 实现4.4以上机型的沉浸式
 */
public class Translucent {


    private final Activity activity;

    public Translucent(Activity activity) {

        this.activity = activity;
    }


    private View view = null;


    private Translucent setTranslucent(View root) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            LinearLayout layout = new LinearLayout(activity);
            layout.setOrientation(LinearLayout.VERTICAL);
            view = new View(activity);
            int paddingHeight = getStatusBarHeight();
            LLogUtils.i("before--" + paddingHeight);
            if (activity.getActionBar() != null) {
                //此判断用于增加状态栏高度
                TypedValue tv = new TypedValue();
                if (activity.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                    paddingHeight += TypedValue.complexToDimensionPixelSize(tv.data, activity.getResources().getDisplayMetrics());
                }
            }

            LLogUtils.i("after--" + paddingHeight);
            layout.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, paddingHeight);

            layout.addView(root, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            activity.setContentView(layout);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
        return this;
    }

    /**
     * 使用侵入式方式在{@link Activity#setContentView(int)}或{@link Activity#setContentView(View)}方法调用之后
     *
     * @return 当前对象
     */
    public Translucent inject() {
        ViewGroup vg = (ViewGroup) activity.findViewById(android.R.id.content);
        View layoutView = vg.getChildAt(0);
        vg.removeView(layoutView);
        setTranslucent(layoutView);
        return this;
    }

    public Translucent setStatusBarColor(int color) {
        if (view == null) {
            throw new RuntimeException("use inject() ??");
        }
        view.setBackgroundColor(color);
        return this;
    }


    /**
     * 获取状态栏高度
     *
     * @return 状态栏高度
     */
    public int getStatusBarHeight() {

        int sbar = -1;
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            sbar = activity.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            Log.e("Translucent", "get status bar height fail");
            e1.printStackTrace();
        }
        return sbar;
    }


}
