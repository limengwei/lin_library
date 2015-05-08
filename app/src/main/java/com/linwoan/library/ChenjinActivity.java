package com.linwoan.library;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.linwoain.ui.LinActivity;

/**
 *沉浸式状态栏demo<br>
 * 1.继承LinActivity<br>
 * 3.设置状态栏颜色<br>
 */
public class ChenjinActivity extends LinActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        setChenjin();
        setChenjinColor(Color.RED);
    }


    public void click(View v) {
        setChenjinColor(Color.BLUE);
    }
}
