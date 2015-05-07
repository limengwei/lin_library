package com.linwoan.library;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.linwoain.ui.LinActivity;

/**
 *沉浸式状态栏demo,不兼容ActionBar<br>
 * 1.继承LinActivity<br>
 * 2.使用{@link LinActivity#setChenjinContentView(View)}或者{@link LinActivity#setContentView(int)}填充布局<br>
 * 3.设置状态栏颜色<br>
 */
public class ChenjinActivity extends LinActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setChenjinContentView(R.layout.activity_second);
        setChenjinColor(Color.RED);
    }


    public void click(View v) {
        setChenjinColor(Color.BLUE);
    }
}
